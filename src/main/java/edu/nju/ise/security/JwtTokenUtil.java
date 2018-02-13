package edu.nju.ise.security;

import edu.nju.ise.model.User;
import edu.nju.ise.utils.TimeUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID = -3301605591108950415L;

    private static final String CLAIM_KEY_USERNAME = "sub";
    private static final String CLAIM_KEY_CREATED = "created";
//    private static final String CLAIM_KEY_ROLE = "role";

//    private static final String AUTH_KEY = "authority";

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private Long expiration;
    @Value("${jwt.tokenHead}")
    private String tokenHead;
    @Value("${jwt.header}")
    private String tokenHeader;

    public String getTokenFromRequest(HttpServletRequest request) {
        String token;
        token = request.getHeader(tokenHeader);
        if (token == null) {
            Cookie[] cookies = request.getCookies();
            for (Cookie cookie: cookies) {
                if (cookie.getName().equals(this.tokenHeader)) {
                    token = cookie.getValue();
                    return token;
                }
            }
        }
        return token;
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            String t;
            if (token.startsWith(tokenHead)) {
                t = token.substring(tokenHead.length());
            } else {
                t = token;
            }
            final Claims claims = getClaimsFromToken(t);
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            String t;
            if (token.startsWith(tokenHead)) {
                t = token.substring(tokenHead.length());
            } else {
                t = token;
            }
            final Claims claims = getClaimsFromToken(t);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

//    public List<String> getRolesFromToken(String token) {
//        List<String> roles;
//        try {
//            String t;
//            if (token.startsWith(tokenHead)) {
//                t = token.substring(tokenHead.length());
//            } else {
//                t = token;
//            }
//            final Claims claims = getClaimsFromToken(t);
//            List<Map<String, Object>> maps = (List<Map<String, Object>>) claims.get(CLAIM_KEY_ROLE);
//            roles = new ArrayList<>();
//            for (Map<String, Object> m: maps) {
//                roles.add((String) m.get(AUTH_KEY));
//            }
//        } catch (Exception e) {
//            roles = null;
//        }
//        return roles;
//    }

//    public UserDetails getUserDetailsFromToken(String token) {
//        User userDetails = new User();
//        try {
//            String t;
//            if (token.startsWith(tokenHead)) {
//                t = token.substring(tokenHead.length());
//            } else {
//                t = token;
//            }
//            final Claims claims = getClaimsFromToken(t);
//            String username = claims.getSubject();
//            userDetails.setUsername(username);
//        } catch (Exception e) {
//            e.printStackTrace();
//            userDetails = null;
//        }
//        return userDetails;
//    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            String t;
            if (token.startsWith(tokenHead)) {
                t = token.substring(tokenHead.length());
            } else {
                t = token;
            }
            final Claims claims = getClaimsFromToken(t);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }

    private Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }

    public String generateToken(UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAIM_KEY_CREATED, new Date());
        //将角色也放入token，减轻访问验证服务器的压力
//        claims.put(CLAIM_KEY_ROLE, userDetails.getAuthorities());
        return generateToken(claims);
    }

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        User user = (User) userDetails;
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
//        final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created,
                        TimeUtils.commonStr2Date(user.getLastPasswordResetDate())));
    }

}
