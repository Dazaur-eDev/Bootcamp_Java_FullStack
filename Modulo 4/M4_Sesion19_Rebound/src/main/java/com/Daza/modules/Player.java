package com.Daza.modules;

public class Player {
    private String name;
    private int age;
    private int number;

    public Player(String name, int age, int number) {
        this.name = name;
        this.age = age;
        this.number = number;
    }

    public Player() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Player createPlayer(String name, int age, int number) {
        return new Player(name, age, number);
    }

    @Override
    public String toString() {
        return "Jugador{" +
                "nombre='" + name + '\'' +
                ", edad=" + age +
                ", numero=" + number +
                '}';
    }
}
