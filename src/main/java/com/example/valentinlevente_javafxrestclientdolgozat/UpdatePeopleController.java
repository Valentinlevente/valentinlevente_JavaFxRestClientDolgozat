package com.example.valentinlevente_javafxrestclientdolgozat;

import com.google.gson.Gson;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class UpdatePeopleController extends Controller{
    @FXML
    private TextField nameField;
    @FXML
    private TextField locationField;
    @FXML
    private TextField phoneNumberField;
    @FXML
    private Spinner<Integer> ageField;
    @FXML
    private Button updateButton;

    private Person person;

    public void setPerson(Person person) {
        this.person = person;
        nameField.setText(this.person.getName());
        locationField.setText(this.person.getCity());
        phoneNumberField.setText(this.person.getPhoneNumber());
        ageField.getValueFactory().setValue(this.person.getAge());
    }

    @FXML
    private void initialize() {
        SpinnerValueFactory.IntegerSpinnerValueFactory valueFactory =
                new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 200, 30);
        ageField.setValueFactory(valueFactory);
    }

    @FXML
    public void updateClick(ActionEvent actionEvent) {
        String name = nameField.getText().trim();
        String location = locationField.getText().trim();
        String phoneNumber = phoneNumberField.getText().trim();
        int age = ageField.getValue();
        if (name.isEmpty()) {
            warning("Name is required");
            return;
        }
        if (location.isEmpty()) {
            warning("Email is required");
            return;
        }
        if (phoneNumber.isEmpty()) {
            warning("Phone number is required");
            return;
        }
        this.person.setName(name);
        this.person.setCity(location);
        this.person.setPhoneNumber(phoneNumber);
        this.person.setAge(age);
        Gson converter = new Gson();
        String json = converter.toJson(this.person);
        try {
            String url = App.BASE_URL + "/" + this.person.getId();
            Response response = RequestHandler.put(url, json);
            if (response.getResponseCode() == 200) {
                Stage stage = (Stage) this.updateButton.getScene().getWindow();
                stage.close();
            } else {
                String content = response.getContent();
                error(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
