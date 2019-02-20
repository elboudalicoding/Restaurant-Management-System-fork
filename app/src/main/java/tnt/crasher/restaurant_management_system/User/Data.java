package tnt.crasher.restaurant_management_system.User;


import java.util.ArrayList;

class Data {
    String title,about, price;
    int photo;
    float rating;

    Data(String title, String about, int photo, float rating, String price) {
        this.title = title;
        this.about = about;
        this.photo = photo;
        this.rating = rating;
        this.price = price;
    }

    Data(String title, String about, int photo) {
        this.title = title;
        this.about = about;
    }

}
