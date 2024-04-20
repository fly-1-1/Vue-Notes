package com.jy.controller;


import com.jy.entity.User;
import com.jy.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jy
 * @since 2024-04-17
 */
@RestController
@RequiredArgsConstructor
@CrossOrigin
public class UserController {


    private static final Logger log = LoggerFactory.getLogger(UserController.class);
    private final IUserService userService;

    @GetMapping("/user")
    public List<User> Users(){
        return userService.list();
    }

    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        log.info("id:{}", id);
        userService.removeById(id);
    }

    @PostMapping("/user")
    public void addUser(@RequestBody User user){
        if(StringUtils.isEmpty(user.getId())){
            userService.save(user);
        }else{
            System.out.println("更新=============");;
            userService.updateById(user);
        }

    }

    @PutMapping("/user")
    public void updateUser(@RequestBody User user){
        userService.updateById(user);
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable("id") Long id){
        return userService.getById(id);
    }

}
