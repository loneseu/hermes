package cn.edu.seu.lone.hermes.application.controller;

import cn.edu.seu.lone.entity.user.User;
import cn.edu.seu.lone.entity.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserRepository userRepository;

    @RequestMapping("/name/{name}")
    public User getUserByName(@PathVariable String name) {
        return userRepository.findUserByName(name);
    }
}
