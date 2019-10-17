package pl.rengreen.tracker.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import pl.rengreen.tracker.model.Result;
import pl.rengreen.tracker.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Controller {

    @FXML
    private Label label_welcome;

    @FXML
    private TableView<Result> table_weight;

    @FXML
    private TableColumn<Result, LocalDate> c_date;

    @FXML
    private TableColumn<Result, BigDecimal> c_weight;

    @FXML
    private TableColumn<Result, BigDecimal> c_bmi;

    @FXML
    private TableColumn<Result, String> c_comment;

    //dodanie nazw pól do wejścia danych (data i waga) oraz dodanie nazwy buttona wraz metodą zapisującą nowy odczyt
    @FXML
    private TextField tf_weight;

    @FXML
    private DatePicker date_input;

    @FXML
    private Button btn_submit;

    private User user;
    private List<Result> results = new ArrayList<>();

    @FXML
    void addResult(ActionEvent event) {
        long id = results.size() + 1;
        LocalDate date = date_input.getValue();
        BigDecimal weight = new BigDecimal(tf_weight.getText());
        results.add(new Result(id, date, weight, user));

        populateTable();
    }

    private void populateTable() {
        results.sort(Comparator.comparing(Result::getDate).reversed());
        ObservableList<Result> data = FXCollections.observableList(results);

        c_date.setCellValueFactory(new PropertyValueFactory<Result, LocalDate>("date"));
        c_weight.setCellValueFactory(new PropertyValueFactory<Result, BigDecimal>("weight"));
        //dodanie do tabeli BMI i komentarzy
        c_bmi.setCellValueFactory(new PropertyValueFactory<Result, BigDecimal>("bmi"));
        c_comment.setCellValueFactory(new PropertyValueFactory<Result, String>("comment"));

        table_weight.setItems(data);
    }

    public void initialize() {
        LocalDate today = LocalDate.now();
        date_input.setValue(today);

        user = new User(1L, "Anna", new BigDecimal("1.69"));

        results.add(new Result(1L, today.minusDays(112), new BigDecimal("72.0"), user));
        results.add(new Result(2L, today.minusDays(105), new BigDecimal("71.0"), user));
        results.add(new Result(3L, today.minusDays(98), new BigDecimal("70.5"), user));
        results.add(new Result(4L, today.minusDays(91), new BigDecimal("69.5"), user));
        results.add(new Result(5L, today.minusDays(84), new BigDecimal("69.0"), user));
        results.add(new Result(6L, today.minusDays(77), new BigDecimal("70.0"), user));
        results.add(new Result(7L, today.minusDays(70), new BigDecimal("69.0"), user));
        results.add(new Result(8L, today.minusDays(63), new BigDecimal("69.5"), user));
        results.add(new Result(9L, today.minusDays(56), new BigDecimal("69.0"), user));
        results.add(new Result(10L, today.minusDays(49), new BigDecimal("68.5"), user));
        results.add(new Result(11L, today.minusDays(42), new BigDecimal("67.5"), user));
        results.add(new Result(12L, today.minusDays(35), new BigDecimal("68.0"), user));
        results.add(new Result(13L, today.minusDays(28), new BigDecimal("67.0"), user));
        results.add(new Result(14L, today.minusDays(21), new BigDecimal("66.5"), user));
        results.add(new Result(15L, today.minusDays(14), new BigDecimal("66.5"), user));
        results.add(new Result(16L, today.minusDays(7), new BigDecimal("52.0"), user));

        populateTable();

        //powitanie użytkownika z jego imieniem
        label_welcome.setText("Witaj " + user.getName() + "!");

    }

}

