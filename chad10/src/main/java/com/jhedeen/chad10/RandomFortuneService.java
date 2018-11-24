package com.jhedeen.chad10;

import org.springframework.stereotype.Component;

@Component("random")
public class RandomFortuneService implements FortuneService {

    @Override
    public String getFortune() {
        return "You was not lucky today";
    }
}
