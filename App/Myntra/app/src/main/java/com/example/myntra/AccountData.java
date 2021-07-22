package com.example.myntra;

public class AccountData {
    private String name;
    private String mail;
    private String phone;
    private String password;

    public AccountData(String name, String mail, String phone, String password) {
        this.name = name;
        this.mail = mail;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getMail() {
        return mail;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
