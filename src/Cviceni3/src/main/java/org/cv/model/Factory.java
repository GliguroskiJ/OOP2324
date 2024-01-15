package org.cv.model;
import java.util.ArrayList;
import java.util.List;

public class Factory {
    private List<Car> carList= new ArrayList<>();
    private int year;

    public Factory(int year) {
        this.year = year;
    }

    public void createCar(String brand, String engine, String color)
    {
        this.carList.add(new Car(brand,engine,color,this.year));
    }

    @Override
    public String toString() {
        String out="";
        for(int i=0;i<this.carList.size();i++)
        {
            out+=String.format("\n%d. vyrobene auto je: %s",i,carList.get(i).toString());
        }
        return out;
    }
}
