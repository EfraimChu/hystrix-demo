package com.example.hystrixdemo.provider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author efraim.zhu
 * @Date 2019/12/31
 **/
@Controller
@RequestMapping("/demo")
public class DemoController {

    private static AtomicInteger count = new AtomicInteger();
    @GetMapping("/test1")
    @ResponseBody
    public String test1(@RequestParam String name) throws InterruptedException {
        System.out.println("/demo/test1:  count=" + count.incrementAndGet());
        Thread.sleep(500);

        return "test1 name=" + name;
    }
}
