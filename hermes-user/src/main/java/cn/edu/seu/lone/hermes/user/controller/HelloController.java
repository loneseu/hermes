package cn.edu.seu.lone.hermes.user.controller;

import cn.edu.seu.lone.entity.TradeUser;
import cn.edu.seu.lone.entity.repository.TradeUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class HelloController {

    private final TradeUserRepository userRepository;


    @RequestMapping("/welcome")
    public String welcome() {
        return "10682 welcome to hermes platform!";
    }


    @RequestMapping("/name/{name}")
    public TradeUser getUserByName(@PathVariable String name) {
        return userRepository.findUserByName(name);
    }
}
