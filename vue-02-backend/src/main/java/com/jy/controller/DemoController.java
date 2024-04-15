package com.jy.controller;


import com.jy.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class DemoController {

    private static final Logger log = LoggerFactory.getLogger(DemoController.class);

    @GetMapping("/demo")
    public String demo(@RequestParam("id") String id,@RequestParam("name") String name){
        log.info("demo ok....");
        log.info("id:{}, name:{}", id, name);
        return "demo ok";
    }

    @PostMapping("test")
    public String test(@RequestBody User user){
        log.info("id:{}, name:{}", user.getId(), user.getName());
        log.info("test ok....");
        return "test ok";
    }

    @PutMapping("test1")
    public String test1(@RequestBody User user){
        log.info("id:{}, name:{}", user.getId(), user.getName());
        log.info("test1 ok....");
        return "test1 ok";
    }

}
