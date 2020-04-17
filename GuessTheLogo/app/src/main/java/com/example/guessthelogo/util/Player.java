package com.example.guessthelogo.util;

import java.util.Objects;

public final class Player {
    private String name;
    private int score;
    private int chanceUsed;

    private static final Player INSTANCE = new Player();

    private Player(){
        this.name = "";
        this.score = 0;
        this.chanceUsed = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getChanceUsed() {
        return chanceUsed;
    }

    public static Player getInstance(){
        return INSTANCE;
    }

    public static void updateName(String name){
        INSTANCE.name = name;
    }

    public static void updateScore(){
        INSTANCE.score++;
    }

    public static void updateChance(){
        INSTANCE.chanceUsed++;
    }

    public static void resetPlayer(){
        INSTANCE.chanceUsed = 0;
        INSTANCE.score = 0;
    }
}
