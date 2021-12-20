package com.company;

import java.util.Arrays;
import java.util.Objects;

interface Chepilduk{
    final String rightName = "Чепыльдук";
    final String yeah = "Да";
    final String no = "Нет";

    String getStatus();
    String isChpilduk();
}

class Area implements Comparable<Area>, Chepilduk{
    String name;
    double square;
    int population;

    public Area (String name, double square, int population){
        this.name = name;
        this.square = square;
        this.population = population;
    }

    public double getDensity(){
        return population/square;
    }
    @Override
    public String getStatus(){
        return "Не указанно";
    }

    @Override
    public String isChpilduk() {
        if(Objects.equals(this.name, Chepilduk.rightName))return Chepilduk.yeah;
        else return Chepilduk.no;
    }

    @Override
    public String toString() {
        return String.format(
                """
                        %-25s %s
                        %-25s %.2f
                        %-25s %d
                        %-25s %.2f
                        %-25s %s
                        %-25s %s
                        """,
                "Название:", name,
                "Площадь:", square,
                "Население:", population,
                "Плотность населения:", this.getDensity(),
                "Статус:", this.getStatus(),
                "Чепыльдук ли?:", this.isChpilduk());
    }

    @Override
    public int compareTo(Area o) {
        return this.name.compareTo(o.name);
    }

}

class Country extends Area implements Chepilduk{
    public Country (String name, double square, int population){
        super(name, square, population);
    }

    @Override
    public String getStatus(){
        if(population < 200)return "Маленькое поселение";
        if(population < 1000)return "Среднее поселение";
        if(population < 5000)return "Большое поселение";
        return "Крупное поселение";
    }

    @Override
    public String isChpilduk() {
        if(Objects.equals(this.name, Chepilduk.rightName))return Chepilduk.yeah;
        else return Chepilduk.no;
    }
}

class City extends Area implements Chepilduk{
    int universities;

    public City (String name, double square, int population, int universities){
        super(name, square, population);
        this.universities = universities;
    }
    @Override
    public String getStatus(){
        if(population < 50000)return "Малый город";
        if(population < 100000)return "Средний город";
        if(population < 250000)return "Большой город";
        if(population < 1000000)return "Крупный город";
        if(population < 3000000)return "Крупнейший город";
        return "Сверхкрупный город";
    }

    @Override
    public String isChpilduk() {
        if(Objects.equals(this.name, Chepilduk.rightName))return Chepilduk.yeah;
        else return Chepilduk.no;
    }

    @Override
    public String toString(){
        return super.toString() + String.format("%-25s %d\n", "Количество ВУЗов:", universities);
    }
}

public class Main {

    public static void main(String[] args) {
        Area[] areas = new Area[]{
                new Country("Верхняя коховка", 5000, 200),
                new City("Житомир", 5000, 300000, 15),
                new City("Псков", 1500, 200000, 4),
                new Country("Весёлая жизнь", 3456, 234),
                new City("Чепыльдук", 322, 242141, 1)
        };
        Arrays.sort(areas);
        for(Area x: areas){
            System.out.println(x);
        }

    }
}
