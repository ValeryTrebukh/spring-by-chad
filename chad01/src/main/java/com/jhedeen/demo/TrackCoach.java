package com.jhedeen.demo;

public class TrackCoach implements Coach {

    private FortuneService theFortuneService;

    public TrackCoach(FortuneService theFortuneService) {
        this.theFortuneService = theFortuneService;
    }

    @Override
    public String getDaylyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDaylyFortune() {
        return "Just do it " + theFortuneService.gerFortune();
    }

    public void doInit() {
        System.out.println("Inside init method");
    }

    public void doDestroy() {
        System.out.println("Inside destroy method");
    }
}
