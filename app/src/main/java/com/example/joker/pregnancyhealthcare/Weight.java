package com.example.joker.pregnancyhealthcare;

/**
 * Created by Joker on 20-May-17.
 */

public class Weight {
    String cat,week,bgain, again;

    public Weight() {
    }

    public Weight(String cat, String week, String bgain, String again) {
        this.cat = cat;
        this.week = week;
        this.bgain = bgain;
        this.again = again;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getBgain() {
        return bgain;
    }

    public void setBgain(String bgain) {
        this.bgain = bgain;
    }

    public String getAgain() {
        return again;
    }

    public void setAgain(String again) {
        this.again = again;
    }
}
