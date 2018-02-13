package edu.nju.ise.service.impl;

import edu.nju.ise.dao.AuthorityMapper;
import edu.nju.ise.dao.UserMapper;
import edu.nju.ise.exception.UserInvalidException;
import edu.nju.ise.model.User;
import edu.nju.ise.security.JwtTokenUtil;
import edu.nju.ise.service.AuthService;
import edu.nju.ise.utils.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * 用户验证接口实现类
 *
 * @author Hermit
 * @version 1.0 2018/02/13
 * */
@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AuthorityMapper authorityMapper;

    @Value("${jwt.tokenHead}")
    private String tokenHead;

    @Override
    public User register(User userToAdd, List<String> authorities) {
        final String username = userToAdd.getUsername();
        if (userMapper.findByUsername(username) != null) {
            throw new UserInvalidException("用户已存在");
        }

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        final String rawPassword = userToAdd.getPassword();
        userToAdd.setPassword(encoder.encode(rawPassword));
        userToAdd.setLastPasswordResetDate(TimeUtils.commonDate2Str(new Date()));

        return null;
    }

    @Override
    public String login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user == null) {
            throw new UserInvalidException("用户不存在");
        }

        // 验证密码是否正确
        UsernamePasswordAuthenticationToken upToken = new UsernamePasswordAuthenticationToken(username, password);
        final Authentication authentication = authenticationManager.authenticate(upToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //生成用户token
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        final String token = jwtTokenUtil.generateToken(userDetails);
        return token;
    }

    @Override
    public String refresh(String oldToken) {
        final String token = oldToken.substring(tokenHead.length());
        String username = jwtTokenUtil.getUsernameFromToken(token);
        User user = (User) userDetailsService.loadUserByUsername(username);
        if (jwtTokenUtil.canTokenBeRefreshed(token, TimeUtils.commonStr2Date(user.getLastPasswordResetDate()))) {
            return jwtTokenUtil.refreshToken(token);
        } else {
            return null;
        }

    }
}
