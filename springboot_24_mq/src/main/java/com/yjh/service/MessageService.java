package com.yjh.service;

public interface MessageService {
    // 将消息发送到消息队列中
    void sendMessage(String id);
    // 在消息队列获取id，然后真正的发送消息
    String doMessage();
}
