package entities;

public class EvaluareMelodie extends Evaluare{
    private Melodie melodie;
    private Integer notaVersuri;
    private Integer notaFlow;

    public EvaluareMelodie(User user, Integer idEvaluare, Melodie melodie, Integer notaVersuri, Integer notaFlow) {
        super(user, idEvaluare);
        this.melodie = melodie;
        this.notaVersuri = notaVersuri;
        this.notaFlow = notaFlow;
    }

    public Melodie getMelodie() {
        return melodie;
    }

    public Integer getNotaVersuri() {
        return notaVersuri;
    }

    public Integer getNotaFlow() {
        return notaFlow;
    }

    public void setNotaVersuri(Integer notaVersuri) {
        this.notaVersuri = notaVersuri;
    }

    public void setNotaFlow(Integer notaFlow) {
        this.notaFlow = notaFlow;
    }

    @Override
    public String toString() {
        return "EvaluareMelodie{" +
                "melodie=" + melodie +
                ", notaVersuri=" + notaVersuri +
                ", notaFlow=" + notaFlow +
                '}';
    }
}
