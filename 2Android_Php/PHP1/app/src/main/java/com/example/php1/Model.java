package com.example.php1;

public class Model {
    public   int id;
    public String username;
    public String password;

    // constructor
    public Model(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }


    // setter and getter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
