package com.jhedeen.demo;

public class HappyFortuneService implements FortuneService {

    @Override
    public String gerFortune() {
        return "Today is your lucky day!";
    }
}
