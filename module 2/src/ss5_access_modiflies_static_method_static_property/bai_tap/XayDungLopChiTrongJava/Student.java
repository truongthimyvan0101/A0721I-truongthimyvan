package ss5_access_modiflies_static_method_static_property.bai_tap.XayDungLopChiTrongJava;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public void setName(String name) {
        this.name = name;
    }

    public void setClasses(String classes) {
        this.classes = classes;
    }

    Student(){

    }

    public String toString(){
        return "name: " + this.name + "\n" + "class: " + this.classes;
    }
}
