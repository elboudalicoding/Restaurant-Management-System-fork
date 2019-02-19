package tnt.crasher.restaurant_management_system.User;


class Data {
    String title,about;
    int photo,viewtype;
    float rating;

    Data(String title, String about, int photo, float rating, int viewtype) {
        this.title = title;
        this.about = about;
        this.photo = photo;
        this.rating = rating;
        this.viewtype=viewtype;
    }

    Data(String title, String about, int photo, int viewtype) {
        this.title = title;
        this.about = about;
        this.viewtype=viewtype;
    }

}
