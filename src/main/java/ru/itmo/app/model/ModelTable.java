package ru.itmo.app.model;

import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;

public class ModelTable {
    private Integer id;
    private String name;
    private String date;
    private String address;

    public ModelTable(Integer id, String name, String dateOfBirth, String address) {
        this.id = id;
        this.name = name;
        this.date = dateOfBirth;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDate() {
        return date;
    }

    public String getAddress() {
        return address;
    }
}
