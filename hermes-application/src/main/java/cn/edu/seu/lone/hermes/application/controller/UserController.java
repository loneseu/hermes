package cn.edu.seu.lone.hermes.application.controller;

import cn.edu.seu.lone.entity.TradeUser;
import cn.edu.seu.lone.entity.repository.TradeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final TradeUserRepository userRepository;

    @RequestMapping("/name/{name}")
    public TradeUser getUserByName(@PathVariable String name) {
        return userRepository.findUserByName(name);
    }
}
