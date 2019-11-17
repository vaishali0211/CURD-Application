package com.example.myapplication02;

public class User {
    public String name;
    public String emailid;
    public String phoneno;

    public User(){

    }
    public User(String username, String email) {
        this.name = username;
        this.phoneno = phoneno;
        this.emailid = emailid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public User(String name, String emailid, String phoneno){
        this.name= name;
        this.emailid=emailid;
        this.phoneno=phoneno;

    }

}
