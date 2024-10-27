package PlanGo.webtech;


public class Reise {
    private String reiseziel;
    private String urlaubstyp;  // Strand, Stadt, Land
    private String datum;

    // Konstruktor
    public Reise(String reiseziel, String urlaubstyp, String datum) {
        this.reiseziel = reiseziel;
        this.urlaubstyp = urlaubstyp;
        this.datum = datum;
    }

    // Getter und Setter
    public String getReiseziel() {
        return reiseziel;
    }

    public void setReiseziel(String reiseziel) {
        this.reiseziel = reiseziel;
    }

    public String getUrlaubstyp() {
        return urlaubstyp;
    }

    public void setUrlaubstyp(String urlaubstyp) {
        this.urlaubstyp = urlaubstyp;
    }

    public String getDatum() {
        return datum;
    }

    public void setDatum(String datum) {
        this.datum = datum;
    }
}

