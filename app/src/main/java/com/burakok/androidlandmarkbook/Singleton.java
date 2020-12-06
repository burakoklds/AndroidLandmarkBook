package com.burakok.androidlandmarkbook;

import android.graphics.Bitmap;

public class Singleton {

    private Bitmap choosenImage;
    private  static  Singleton singleton;

    private  Singleton() {

    }

    public Bitmap getChoosenImage() {
        return choosenImage;
    }

    public void setChoosenImage(Bitmap choosenImage) {
        this.choosenImage = choosenImage;
    }

    public  static  Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return  singleton;
    }
}
