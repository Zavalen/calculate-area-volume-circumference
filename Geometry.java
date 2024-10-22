/*
Zava
CS2050
Program2
02/08/2024
 */

public class Geometry {
    private int radius, height;
    private double circumference, area, volume;

    // Constructors
    public Geometry() {
        this.radius = 0;
        this.height = 0;
        this.circumference = 0.0;
        this.area = 0.0;
        this.volume = 0.0;
    }
    public Geometry(int radius) {
        this.radius = radius;
        this.height = 0;
        this.CalculateCirc();
        this.CalculateArea();
        this.volume = 0.0;
    }
    public Geometry(int radius, int height) {
        this.radius = radius;
        this.height = height;
        this.CalculateCirc();
        this.CalculateArea();
        this.Volume();
    }

    // Calculating methods
    private void CalculateCirc() {
        this.circumference = 2 * Math.PI * radius;
    }
    private void CalculateArea(){
        this.area = Math.PI * Math.pow(radius, 2);
    }
    private void Volume() {
        this.volume = area * height;
    }

    // Get and Set
    public double getRadius() {
        return radius;
    }
    public void setRadius(int radius) {
        this.radius = radius;

    }
    public double getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;

    }
    public double getCircumference() {
        return circumference;
    }
    public double getArea() {
        return area;
    }
    public double getVolume() {
        return volume;
    }



}
