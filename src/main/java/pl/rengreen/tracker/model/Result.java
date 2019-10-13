package pl.rengreen.tracker.model;

public class Result {
    private Long resultId;
    private String date;
    private String weight;
    private String bmi;
    private String comment;
    private User user;

    public Result() {
    }

    public Result(Long resultId, String date, String weight, User user) {
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getBmi(){
        //TODO obliczenie BMI jako BigDecimal i zamiana na String
        return "0";
    }

    public void setBmi(String bmi) {
        this.bmi = bmi;
    }

    public String getComment(){
        //TODO komentarz dotyczący BMI (prawidłowe, za dużo, za mało)
        return "komentarz";
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
