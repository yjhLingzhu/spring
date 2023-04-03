package com.yjh.service.impl;

import com.yjh.service.LotteryService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class LotteryServiceImpl implements LotteryService {
    @Override
    public List<Integer> randomNums() {
        // 生成Random对象
        Random random = new Random();
        // 列表
        ArrayList<Integer> lotteryList = new ArrayList<Integer>();
        // 随机生成彩票数据
        for (int i = 0; i < 6; i++) {
            // 1-33
            int anInt = random.nextInt(33)+1;
            if (lotteryList.contains(anInt)) {
                i--;
                continue;
            }
            lotteryList.add(i, anInt);
        }
        int index = random.nextInt(6);
        lotteryList.add(lotteryList.get(index));
        return lotteryList;
    }
}
