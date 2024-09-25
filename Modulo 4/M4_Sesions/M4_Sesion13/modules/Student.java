package M4_Sesion13.modules;

import java.time.LocalDate;

public class Student {
    private String name;
    private String rut;
    private LocalDate bornData;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public LocalDate getBornData() {
        return bornData;
    }

    public void setBornData(LocalDate bornData) {
        this.bornData = bornData;
    }

    public Student(String name, String rut, LocalDate bornData) {
        this.name = name;
        this.rut = rut;
        this.bornData = bornData;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", rut='" + rut + '\'' +
                ", bornData=" + bornData +
                '}';
    }
}
