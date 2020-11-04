package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Pane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;

public class FxmlLoadder {
    private Pane view;

    public Pane getPane(String fileName){

        try{
            URL fileUrl = ControllerSearch.class.getResource("/sample/layer/" + fileName + ".fxml");
            if(fileUrl == null)
                throw new java.io.FileNotFoundException("File can't be found");

            view = new FXMLLoader().load(fileUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return view;
    }

}
