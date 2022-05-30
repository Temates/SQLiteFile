package com.example.sqlitefile;

public class DataModel {
    int Id;
    String nama;
    String password;

    public  DataModel() {

    }

    public DataModel(int id, String nama, String password) {
        this.Id = id;
        this.nama = nama;
        this.password = password;
    }

    public DataModel(String nama, String password) {
        this.nama = nama;
        this.password = password;
    }

    public int getId() {
        return Id;
    }

    public String getNama() {
        return nama;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.Id = id;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

