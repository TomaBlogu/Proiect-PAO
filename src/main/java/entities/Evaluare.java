package entities;

public class Evaluare {
    private User user;
    private Integer idEvaluare;

    public Evaluare(User user, Integer idEvaluare) {
        this.user = user;
        this.idEvaluare = idEvaluare;
    }

    public User getUser() {
        return user;
    }

    public Integer getIdEvaluare() {
        return idEvaluare;
    }

}
