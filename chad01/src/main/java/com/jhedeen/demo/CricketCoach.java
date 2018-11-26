package com.jhedeen.demo;

public class CricketCoach implements Coach
{
    private FortuneService fortuneService;
    private String emailAddress;
    private String team;

    public CricketCoach() {
        System.out.println("inside no-args constructor");
    }

    public void setFortuneService(FortuneService fortuneService) {
        System.out.println("inside setter method");
        this.fortuneService = fortuneService;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getTeam() {
        return team;
    }

    @Override
    public String getDaylyWorkout() {
        return "Practice fast bowling for 15 minutes";
    }

    @Override
    public String getDaylyFortune() {
        return fortuneService.gerFortune();
    }
}
