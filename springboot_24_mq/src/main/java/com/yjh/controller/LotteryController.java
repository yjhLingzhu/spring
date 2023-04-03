package com.yjh.controller;

import com.google.common.base.Joiner;
import com.sun.deploy.util.StringUtils;
import com.yjh.service.LotteryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lottery")
public class LotteryController {
    @Autowired
    private LotteryService lotteryService;

    @GetMapping
    public String getLottery() {
        List<Integer> nums = lotteryService.randomNums();
        String join = Joiner.on(", ").join(nums);
        return join;
    }
}
