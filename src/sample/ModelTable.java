package sample;

import javafx.scene.control.Button;

public class ModelTable {
    private Integer id;
    private String name;
//    private Button button;

    public ModelTable(Integer id, String name) {
        this.id = id;
        this.name = name;
//        this.button = new Button("Подробнее");
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
