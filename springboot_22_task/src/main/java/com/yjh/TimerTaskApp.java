package com.yjh;

import java.util.Timer;
import java.util.TimerTask;

public class TimerTaskApp {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("yjh...");
            }
        };
        // 延迟0秒开始，每隔2秒执行一次
        timer.schedule(task, 0, 2000);
    }
}
