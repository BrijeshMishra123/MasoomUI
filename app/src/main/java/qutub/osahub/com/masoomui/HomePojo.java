package qutub.osahub.com.masoomui;

/**
 * Created by Qutub on 7/27/2015.
 */
import android.graphics.Bitmap;

import java.io.Serializable;
public class HomePojo implements Serializable {
    String name;
    String date;
    String place;
    Bitmap image;

    public HomePojo() {
    }

    public HomePojo(String place, String name, String date, Bitmap image) {
        this.place = place;
        this.name = name;
        this.date = date;
        this.image = image;
    }
    public HomePojo(String place, String name, String date) {//just for runnig the app ,dummy method
        this.place = place;
        this.name = name;
        this.date = date;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
