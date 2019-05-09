package com.company;

public class KargoGemisi extends Gemi {
    private int totalWeight;

    public KargoGemisi(String name, String year, int totalWeight) {
        super(name, year);
        this.totalWeight = totalWeight;
    }

    public int getTotalWeight() {
        return totalWeight;
    }

    public void setTotalWeight(int totalWeight) {
        this.totalWeight = totalWeight;
    }
    public String toString(){
        return String.format("%s Kapasite:%s",super.toString(),totalWeight);
    }
}
