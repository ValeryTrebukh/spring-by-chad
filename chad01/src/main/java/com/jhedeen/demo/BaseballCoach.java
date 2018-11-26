package com.jhedeen.demo;

public class BaseballCoach implements Coach {

    private FortuneService fortuneService;

    public BaseballCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDaylyWorkout() {
        return "Spent 30 minutes";
    }

    @Override
    public String getDaylyFortune() {

        return fortuneService.gerFortune();
    }
}
