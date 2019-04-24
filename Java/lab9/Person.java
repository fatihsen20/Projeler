public class Person {
    private String name,adress;
    public Person(String name,String adress){
        this.name=name;
        this.adress=adress;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String toString(){
        return String.format("name:%s adress:%s",name,adress);
    }
}
