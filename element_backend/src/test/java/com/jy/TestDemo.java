package com.jy;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jy.entity.User;
import com.jy.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class TestDemo {

    @Autowired
    private IUserService userService;

    @Test
    public void test() {
        Page<User> page = Page.of(2, 5);
        //userService.page(page, new QueryWrapper<User>()).getRecords().forEach(System.out::println);
        userService.page(page).getRecords().forEach(System.out::println);


    }

}
