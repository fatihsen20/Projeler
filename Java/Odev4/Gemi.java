package com.company;

public class Gemi {
    private String name,year;

    public Gemi() {
    }

    public Gemi(String name, String year) {
        this.name = name;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
    public String toString(){
        return String.format("name:%s year:%s",name,year);
    }
}
