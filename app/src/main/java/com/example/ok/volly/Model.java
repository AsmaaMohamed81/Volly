package com.example.ok.volly;

/**
 * Created by ok on 31/01/2018.
 */

public class Model {

   private String Title;
 private    String Desc;
  private   String img;

    public Model(String title, String desc, String img) {
        Title = title;
        Desc = desc;
        this.img = img;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {

        return Title;
    }

    public String getDesc() {
        return Desc;
    }

    public String getImg() {
        return img;
    }
}
