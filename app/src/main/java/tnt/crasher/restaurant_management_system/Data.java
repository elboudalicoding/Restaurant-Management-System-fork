package tnt.crasher.restaurant_management_system;

/**
 * Created by HP ElitBook on 9/17/2016.
 */
class Data {
    String title,about;
    int photo,viewtype;

    Data(String title, String about, int photo,int viewtype) {
        this.title = title;
        this.about = about;
        this.photo = photo;
        this.viewtype=viewtype;
    }

    Data(String title, String about,int viewtype) {
        this.title = title;
        this.about = about;
        this.viewtype=viewtype;
    }

}
