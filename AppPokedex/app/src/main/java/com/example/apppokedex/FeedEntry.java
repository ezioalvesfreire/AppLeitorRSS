package com.example.apppokedex;

import java.util.List;

public class FeedEntry {

    private String name;
    private String num;
    private String height;
    private String weight;
    private String imgURL;
    private List<String> type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

        public List<String> getType() {
            return type;
        }

        public void setType(List<String> type) {
            this.type = type;
        }

    @Override
    public String toString() {
        return "FeedEntry{" +
                "name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", height='" + height + '\'' +
                ", weiht='" + weight + '\'' +
                ", imgURL='" + imgURL + '\''
                   +                 ", type=" + type
                +'}';
    }
}