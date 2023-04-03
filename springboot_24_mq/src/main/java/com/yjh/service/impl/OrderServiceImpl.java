package com.yjh.service.impl;

import com.yjh.service.MessageService;
import com.yjh.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    public void order(String id) {
        // 一系列操作，包含各种服务调用，处理各种业务
        System.out.println("订单处理开始...");
        // 短信消息处理
        messageService.sendMessage(id);     // 将消息发送到消息队列
        System.out.println("订单处理结束");
        System.out.println();

    }
}
