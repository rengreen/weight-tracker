package pl.rengreen.tracker.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.time.LocalDate;

public class Result {
    static final BigDecimal UNDERWEIGHT_VALUE = new BigDecimal(18.5);
    static final BigDecimal OVERWEIGHT_VALUE = new BigDecimal(25);
    static final String UNDERWEIGHT_COMMENT = "niedowaga";
    static final String HEALTHY_WEIGHT_COMMENT = "ok";
    static final String OVERWEIGHT_COMMENT = "nadwaga";

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

        if (this.getBmi().compareTo(UNDERWEIGHT_VALUE)<0){
            return UNDERWEIGHT_COMMENT;
        } else if (this.getBmi().compareTo(OVERWEIGHT_VALUE)<0){
            return HEALTHY_WEIGHT_COMMENT;
        } else {
            return OVERWEIGHT_COMMENT;
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
