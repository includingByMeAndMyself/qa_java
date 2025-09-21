package com.example;

import java.util.Arrays;
import java.util.List;

public class AlexLion extends Lion {

    private final Predator predator;

    public AlexLion(Predator predator) throws Exception {
        super(predator, "Самец");
        this.predator = predator;
    }

    @Override
    public int getKittens() {
        return 0;
    }

    public List<String> getFriends() {
        return Arrays.asList("Марти", "Глория", "Мелман");
    }

    public String getPlaceOfLiving() {
        return "Нью-Йоркский зоопарк";
    }
}