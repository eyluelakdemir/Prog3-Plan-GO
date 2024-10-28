package PlanGo.webtech;

public class Land {
    private String name;
    private String urlaubsTyp;
    private boolean besucht;
    private boolean geplant;

    public Land(String name, boolean besucht, boolean geplant) {
        this.name = name;
        this.urlaubsTyp = getUrlaubstyp();
        this.besucht = besucht;
        this.geplant = geplant;
    }

    // Getter Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlaubstyp() {
        return urlaubsTyp;
    }

    public void setUrlaubstyp(String urlaubstyp) {
        this.urlaubsTyp= urlaubsTyp;
    }


    public boolean isBesucht() {
        return besucht;
    }

    public void setBesucht(boolean besucht) {
        this.besucht = besucht;
    }

    public boolean isGeplant() {
        return geplant;
    }

    public void setGeplant(boolean geplant) {
        this.geplant = geplant;
    }
}
