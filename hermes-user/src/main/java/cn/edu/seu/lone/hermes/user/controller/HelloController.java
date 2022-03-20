package cn.edu.seu.lone.hermes.user.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @RequestMapping("/welcome")
    public String welcome() {
        return "welcome to hermes platform!";
    }
}
