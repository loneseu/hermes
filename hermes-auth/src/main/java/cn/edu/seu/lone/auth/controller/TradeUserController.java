package cn.edu.seu.lone.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class TradeUserController {

    private final UserDetailsService authUserDetailsService;

    @RequestMapping("/user")
    public UserDetails getUser(@RequestParam("username")String username) {

        return authUserDetailsService.loadUserByUsername(username);
    }
}
