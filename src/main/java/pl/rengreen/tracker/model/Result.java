package pl.rengreen.tracker.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Result {
    private Long resultId;
    private LocalDate date;
    private BigDecimal weight;
    private BigDecimal bmi;
    private String comment;
    private User user;

    public Result() {
    }

    public Result(Long resultId, LocalDate date, BigDecimal weight, User user) {
        this.resultId = resultId;
        this.date = date;
        this.weight = weight;
        this.user = user;
    }

    public Long getResultId() {
        return resultId;
    }

    public void setResultId(Long resultId) {
        this.resultId = resultId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getBmi(){
        //obliczenie BMI
        return this.weight
                .divide(this.user.getHeight(), new MathContext(4))
                .divide(this.user.getHeight(), new MathContext(4));
    }

    public void setBmi(BigDecimal bmi) {
        this.bmi = bmi;
    }

    public String getComment(){
        //komentarz dotyczący BMI (prawidłowe, za dużo, za mało)
        BigDecimal underweightValue = new BigDecimal(18.5);
        BigDecimal overweightValue = new BigDecimal(25);

        if (this.getBmi().compareTo(underweightValue)<0){
            return "niedowaga";
        } else if (this.getBmi().compareTo(overweightValue)<0){
            return "ok";
        } else {
            return "nadwaga";
        }
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
