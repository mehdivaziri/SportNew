package com.tell.mehdi.sportnew.model;

import io.realm.RealmObject;

public class MainSportDatabase extends RealmObject {

    private int idMain;
    private String nameMain;
    private byte[] imageMain;

    public int getIdMain() {
        return idMain;
    }

    public void setIdMain(int idMain) {
        this.idMain = idMain;
    }

    public String getNameMain() {
        return nameMain;
    }

    public void setNameMain(String nameMain) {
        this.nameMain = nameMain;
    }

    public byte[] getImageMain() {
        return imageMain;
    }

    public void setImageMain(byte[] imageMain) {
        this.imageMain = imageMain;
    }


}
