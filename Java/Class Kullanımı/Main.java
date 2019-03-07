public class Main {
    private String year;
    private String model;
    private double deger;

    public Main(String year, String model, double deger) {
        this.year = year;
        this.model = model;
        this.deger = deger;
    }

    public String getYear() {
        return year;
    }

    public void setYear() {
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public void setModel() {
        this.model = model;
    }

    public double getDeger() {
        return deger;
    }

    public void setDeger() {
        this.deger = deger;
    }

    public String toString() {
        return "Model:" + this.model + "\tYear:" + this.year + "\tDeger:" + this.deger;
    }
}