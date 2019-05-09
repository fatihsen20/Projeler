package com.company;

public class TuristikGemi extends Gemi {
    private int passengerCount;

    public TuristikGemi(String name, String year, int passengerCount) {
        super(name, year);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }
    public String toString(){
        return String.format("%s PassengerCount:%s",super.toString(),passengerCount);
    }
}
