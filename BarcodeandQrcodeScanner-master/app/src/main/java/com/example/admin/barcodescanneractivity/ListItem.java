package com.example.admin.barcodescanneractivity;

public class ListItem {

    public String heading;
    public String desc;
    public int count;
    public int price;
    public String imageURL;



    public ListItem(String heading, String desc, int price, int count, String imageURL) {
        this.heading = heading;
        this.desc = desc;
        this.price = price;
        this.count = count;
        this.imageURL = imageURL;
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }


    public void setCount(int count) {
        this.count = count;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getHeading() {
        return heading;
    }

    public String getDesc() {
        return desc;
    }
}
