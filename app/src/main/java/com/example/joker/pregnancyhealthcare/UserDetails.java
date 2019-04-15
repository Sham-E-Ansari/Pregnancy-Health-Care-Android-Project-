package com.example.joker.pregnancyhealthcare;

/**
 * Created by Joker on 19-May-17.
 */

public class UserDetails {

    String uName, uEmail, uPass, uMob, uEmob1,uEmob2,uDop,uDob,uBld,uHeight, uWeight;

    public String getuHeight() {
        return uHeight;
    }

    public void setuHeight(String uHeight) {
        this.uHeight = uHeight;
    }

    public String getuWeight() {
        return uWeight;
    }

    public void setuWeight(String uWeight) {
        this.uWeight = uWeight;
    }

    public UserDetails(String uName, String uEmail, String uPass, String uMob, String uEmob1, String uEmob2, String uDop, String uDob, String uBld, String uHeight, String uWeight) {
        this.uName = uName;
        this.uEmail = uEmail;
        this.uPass = uPass;
        this.uMob = uMob;
        this.uEmob1 = uEmob1;
        this.uEmob2 = uEmob2;
        this.uDop = uDop;
        this.uDob = uDob;
        this.uBld = uBld;
        this.uHeight = uHeight;
        this.uWeight = uWeight;

    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuPass() {
        return uPass;
    }

    public void setuPass(String uPass) {
        this.uPass = uPass;
    }

    public String getuMob() {
        return uMob;
    }

    public void setuMob(String uMob) {
        this.uMob = uMob;
    }

    public String getuEmob1() {
        return uEmob1;
    }

    public void setuEmob1(String uEmob1) {
        this.uEmob1 = uEmob1;
    }

    public String getuEmob2() {
        return uEmob2;
    }

    public void setuEmob2(String uEmob2) {
        this.uEmob2 = uEmob2;
    }

    public String getuDop() {
        return uDop;
    }

    public void setuDop(String uDop) {
        this.uDop = uDop;
    }

    public String getuDob() {
        return uDob;
    }

    public void setuDob(String uDob) {
        this.uDob = uDob;
    }

    public String getuBld() {
        return uBld;
    }

    public void setuBld(String uBld) {
        this.uBld = uBld;
    }
}
