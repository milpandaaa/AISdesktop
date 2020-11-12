package ru.itmo.app.service;

import com.sun.javafx.scene.control.skin.ComboBoxListViewSkin;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.Observable;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ru.itmo.app.model.Country;

import java.util.*;
import java.util.stream.Collectors;

public class ComboboxService {

    //Added here
    static Set<Country> countries = new TreeSet<Country>(Comparator.comparing(Country::getName)) {{
        add(new Country(1, "Afghanistan"));
        add(new Country(2, "Albania"));
        add(new Country(3, "Algeria"));
        add(new Country(4, "Andorra"));
        add(new Country(5, "Angola"));
        add(new Country(6, "Antigua and Barbuda"));
        add(new Country(7, "Argentina"));
    }};


    public static class HideableItem<T> {
        private final ObjectProperty<T> object = new SimpleObjectProperty<>();
        private final BooleanProperty hidden = new SimpleBooleanProperty();

        private HideableItem(T object) {
            setObject(object);
        }

        private ObjectProperty<T> objectProperty() {
            return this.object;
        }

        private T getObject() {
            return this.objectProperty().get();
        }

        private void setObject(T object) {
            this.objectProperty().set(object);
        }

        private BooleanProperty hiddenProperty() {
            return this.hidden;
        }

        private boolean isHidden() {
            return this.hiddenProperty().get();
        }

        private void setHidden(boolean hidden) {
            this.hiddenProperty().set(hidden);
        }

        @Override
        public String toString() {
            return getObject() == null ? null : getObject().toString();
        }
    }

    public void start(Stage stage) {


        //HBox root = new HBox();
        //root.getChildren().add(comboBox);

//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();


    }

    //Added here
    public List<String> loadFromDb() {
        return countries.stream()
                .map(Country::getName)
                .collect(Collectors.toList());
    }

    static Integer comboboxValue;

    public static <T> ComboBox<HideableItem<T>> createComboBoxWithAutoCompletionSupport(List<T> items) {
        ObservableList<HideableItem<T>> hideableHideableItems = FXCollections.observableArrayList(hideableItem -> new Observable[]{hideableItem.hiddenProperty()});

        items.forEach(item ->
        {
            HideableItem<T> hideableItem = new HideableItem<>(item);
            hideableHideableItems.add(hideableItem);
        });

        FilteredList<HideableItem<T>> filteredHideableItems = new FilteredList<>(hideableHideableItems, t -> !t.isHidden());

        ComboBox<HideableItem<T>> comboBox = new ComboBox<>();
        comboBox.setItems(filteredHideableItems);

        @SuppressWarnings("unchecked")
        HideableItem<T>[] selectedItem = (HideableItem<T>[]) new HideableItem[1];

        comboBox.addEventHandler(KeyEvent.KEY_PRESSED, event ->
        {
            if (!comboBox.isShowing()) return;

            comboBox.setEditable(true);
            comboBox.getEditor().clear();
        });

        comboBox.showingProperty().addListener((observable, oldValue, newValue) ->
        {
            System.out.println("+++value 3");
            if (newValue) {
                @SuppressWarnings("unchecked")
                ListView<HideableItem> lv = ((ComboBoxListViewSkin<HideableItem>) comboBox.getSkin()).getListView();

                Platform.runLater(() ->
                {
                    if (selectedItem[0] == null) // first use
                    {
                        double cellHeight = ((Control) lv.lookup(".list-cell")).getHeight();
                        lv.setFixedCellSize(cellHeight);
                    }
                });

                lv.scrollTo(comboBox.getValue());
            } else {
                HideableItem<T> value = comboBox.getValue();
                if (value != null) selectedItem[0] = value;

                comboBox.setEditable(false);

                System.out.println("+++value 1 " + selectedItem[0]);

                //Added here
                Optional<Integer> any = countries.stream().filter(country -> selectedItem[0].toString().equals(country.getName())).map(Country::getCode).findAny();
                comboboxValue = any.get();

                Platform.runLater(() ->
                {
                    comboBox.getSelectionModel().select(selectedItem[0]);
                    comboBox.setValue(selectedItem[0]);
                });
            }
        });

        comboBox.setOnHidden(event -> hideableHideableItems.forEach(item -> item.setHidden(false)));

        comboBox.getEditor().textProperty().addListener((obs, oldValue, newValue) ->
        {
            if (!comboBox.isShowing()) return;

            System.out.println("+++value 3");
            Platform.runLater(() ->
            {
                if (comboBox.getSelectionModel().getSelectedItem() == null) {
                    hideableHideableItems.forEach(item -> item.setHidden(!item.getObject().toString().toLowerCase().contains(newValue.toLowerCase())));
                } else {
                    boolean validText = false;

                    for (HideableItem hideableItem : hideableHideableItems) {
                        if (hideableItem.getObject().toString().equals(newValue)) {
                            validText = true;
                            break;
                        }
                    }

                    if (!validText) comboBox.getSelectionModel().select(null);
                }
            });
        });

        return comboBox;
    }
}