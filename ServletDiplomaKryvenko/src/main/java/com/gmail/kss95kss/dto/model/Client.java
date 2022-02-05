package com.gmail.kss95kss.dto.model;

public class Client {

    private int id;
    private String name;
    private String secondName;
    private String login;
    private String password;
    private String email;
    private int role;

    public Client() {
    }

    public Client(int id, String name, String secondName, String login, String password, String email, int role) {
        this.id = id;
        this.name = name;
        this.secondName = secondName;
        this.login = login;
        this.password = password;
        this.email = email;
        this.role = role;
    }

    public Client(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                '}';
    }


}
