package com.Bob_R.review;

public class User {

    public String username;
    public String firstname;
    public String lastname;

    public Role role;

//    public String role = "asdasdd";
//
//    List<String> roleList = // "Admin", "Manager", "Employee"

    public User(String username, String firstname, String lastname, Role role) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", role=" + role +
                '}';
    }

}
