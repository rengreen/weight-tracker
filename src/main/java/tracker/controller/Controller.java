package main.java.tracker.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import main.java.tracker.model.Result;
import main.java.tracker.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Controller {

    @FXML
    private TableView<Result> table_weight;

    @FXML
    private TableColumn<Result, String> c_date;

    @FXML
    private TableColumn<Result, String> c_weight;

    @FXML
    private TableColumn<Result, String> c_bmi;

    @FXML
    private TableColumn<Result, String> c_comment;

    //TODO dodanie nazw pól do wejścia danych (data i waga) oraz dodanie nazwy buttona wraz metodą zapisującą nowy odczyt

    private ObservableList<Result> getInitialTableData() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        User user=new User(1L, "Anna", new BigDecimal("169.0"));
        List<Result> results =  Arrays.asList(
                new Result(1L, today.minusDays(112).format(formatter), "71.0", user),
                new Result(2L, today.minusDays(105).format(formatter), "71.0", user),
                new Result(3L, today.minusDays(98).format(formatter), "70.5", user),
                new Result(4L, today.minusDays(91).format(formatter), "69.5", user),
                new Result(5L, today.minusDays(84).format(formatter), "69.0", user),
                new Result(6L, today.minusDays(77).format(formatter), "70.0", user),
                new Result(7L, today.minusDays(70).format(formatter), "69.0", user),
                new Result(8L, today.minusDays(63).format(formatter), "69.5", user),
                new Result(9L, today.minusDays(56).format(formatter), "69.0", user),
                new Result(10L, today.minusDays(49).format(formatter), "68.5", user),
                new Result(11L, today.minusDays(42).format(formatter), "67.5", user),
                new Result(12L, today.minusDays(35).format(formatter), "68.0", user),
                new Result(13L, today.minusDays(28).format(formatter), "67.0", user),
                new Result(14L, today.minusDays(21).format(formatter), "66.5", user),
                new Result(15L, today.minusDays(14).format(formatter), "66.5", user),
                new Result(16L, today.minusDays(7).format(formatter), "66.0", user)
        );

        Collections.reverse(results);
        return FXCollections.observableList(results);
    }

    public void initialize() {
        //TODO powitanie użytkownika z jego imieniem

        ObservableList<Result> data = getInitialTableData();
        c_date.setCellValueFactory(new PropertyValueFactory<Result, String>("date"));
        c_weight.setCellValueFactory(new PropertyValueFactory<Result, String>("weight"));
        //TODO dodanie do tabeli BMI i komentarzy

        table_weight.setItems(data);

    }

}

