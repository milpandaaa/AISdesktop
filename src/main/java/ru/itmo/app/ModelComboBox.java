package ru.itmo.app;

public class ModelComboBox {

    Integer code;

    String name;

    public ModelComboBox() {
    }

    public ModelComboBox(Integer code, String name) {
        this.code = code;
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
