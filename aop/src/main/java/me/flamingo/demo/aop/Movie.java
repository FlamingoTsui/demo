package me.flamingo.demo.aop;

import org.springframework.stereotype.Service;

/**
 * @author flamingo
 * @create 9/12/21 10:21 PM
 */
@Service
public class Movie implements Performance{

    @Override
    public void perform(String name) {
        System.out.println("播放电影🎬:" + name);
    }
}
