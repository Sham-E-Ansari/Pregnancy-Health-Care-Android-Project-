package com.example.joker.pregnancyhealthcare;

/**
 * Created by Joker on 29-Jan-18.
 */

public class HospitalDetails {
    String hName,hLoc, hnumber;
    int _id;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public HospitalDetails(String hName, String hLoc, String hnumber) {
        this.hName = hName;
        this.hLoc = hLoc;
        this.hnumber = hnumber;
    }

    public String gethName() {
        return hName;
    }
    public void sethName(String hName) {
        this.hName = hName;
    }
    public String gethLoc() {
        return hLoc;
    }
    public void sethLoc(String hLoc) {
        this.hLoc = hLoc;
    }
}
