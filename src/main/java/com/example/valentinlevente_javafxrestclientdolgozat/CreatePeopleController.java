package com.example.valentinlevente_javafxrestclientdolgozat;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

import java.io.IOException;


public class CreatePeopleController extends Controller{
    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private Button submitButton;

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 30);
        ageField.setValueFactory(valueFactory);
    }

    @FXML
    public void submitClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        int age = ageField.getValue();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (location.isEmpty()) {
            warning("Location is required");
            return;
        }
        Person newPerson = new Person(0, name, location, age, phoneNumber);
        Gson converter = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();
        String json = converter.toJson(newPerson);
        try {
            Response response = RequestHandler.post(App.BASE_URL, json);
            if (response.getResponseCode() == 201) {
                warning("Person added!");
                nameField.setText("");
                locationField.setText("");
                phoneNumberField.setText("");
                ageField.getValueFactory().setValue(30);
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
