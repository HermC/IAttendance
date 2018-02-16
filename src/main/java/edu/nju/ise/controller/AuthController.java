package edu.nju.ise.controller;

import edu.nju.ise.model.ResponseData;
import edu.nju.ise.model.User;
import edu.nju.ise.security.JwtTokenUtil;
import edu.nju.ise.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

/**
 * @author Hermit
 * @version 1.0 2018/02/13
 * */
@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody User user) throws AuthenticationException {
        final String token = authService.login(user.getUsername(), user.getPassword());
        return ResponseData.ok(token);
    }

    @RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ResponseData refresh(HttpServletRequest request) throws AuthenticationException {
        String token = jwtTokenUtil.getTokenFromRequest(request);
        String refreshToken = authService.refresh(token);
        if (refreshToken == null) {
            return ResponseData.badRequest("需要重新验证");
        } else {
            return ResponseData.ok(refreshToken);
        }
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData register(HttpServletRequest request) throws AuthenticationException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] authorities = request.getParameterValues("authorities");
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        return ResponseData.ok(authService.register(user, Arrays.asList(authorities)));
    }

}
