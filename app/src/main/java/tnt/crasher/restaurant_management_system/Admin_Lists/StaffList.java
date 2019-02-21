package tnt.crasher.restaurant_management_system.Admin_Lists;

public class StaffList {

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPosition() {
        return position;
    }

    public String getTimeIn() {
        return timeIn;
    }

    public String getTimeOut() {
        return timeOut;
    }

    private String firstname;
    private String lastname;
    private String position;
    private String timeIn;
    private String timeOut;

    public StaffList(String firstname, String lastname, String position, String timeIn, String timeOut){
        this.firstname = firstname;
        this.lastname = lastname;
        this.position = position;
        this.timeIn = timeIn;
        this.timeOut = timeOut;
    }

}
