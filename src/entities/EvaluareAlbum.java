package entities;

public class EvaluareAlbum extends Evaluare{
    private Album album;
    private Integer notaConcept;
    private Integer notaProductie;

    public EvaluareAlbum(User user, Integer idEvaluare, Album album, Integer notaConcept, Integer notaProductie) {
        super(user, idEvaluare);
        this.album = album;
        this.notaConcept = notaConcept;
        this.notaProductie = notaProductie;
    }

    @Override
    public String toString() {
        return "EvaluareAlbum{" +
                "album=" + album +
                ", notaConcept=" + notaConcept +
                ", notaProductie=" + notaProductie +
                '}';
    }

    public Album getAlbum() {
        return album;
    }

    public Integer getNotaConcept() {
        return notaConcept;
    }

    public Integer getNotaProductie() {
        return notaProductie;
    }

    public void setNotaConcept(Integer notaConcept) {
        this.notaConcept = notaConcept;
    }

    public void setNotaProductie(Integer notaProductie) {
        this.notaProductie = notaProductie;
    }
}
