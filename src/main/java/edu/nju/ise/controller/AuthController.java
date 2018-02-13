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

/**
 * @author Hermit
 * @version 1.0 2018/02/13
 * */
@RestController
public class AuthController {

    @Value("${jwt.header}")
    private String tokenHeader;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(@RequestBody User user) throws AuthenticationException {
        final String token =jwtTokenUtil.getTokenFromRequest()
    }
}
