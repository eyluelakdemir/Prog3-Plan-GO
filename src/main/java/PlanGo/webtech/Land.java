package PlanGo.webtech;

public class Land {
    private String name;
    private boolean besucht;
    private boolean geplant;

    public Land(String name, boolean besucht, boolean geplant) {
        this.name = name;
        this.besucht = besucht;
        this.geplant = geplant;
    }

    // Getter und Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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