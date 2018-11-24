package com.jhedeen.chad10;

import org.springframework.stereotype.Component;

@Component("happy")
public class HappyFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "Today is your lucky day!";
    }

    public HappyFortuneService() {
        System.out.println("Fortune constructor");
    }
}
