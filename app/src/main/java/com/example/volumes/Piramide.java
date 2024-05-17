package com.example.volumes;

public class Piramide {
    private double base;
    private double altura;

    public Piramide(double base, double altura) {
        setBase(base);
        setAltura(altura);
    }

    public double getBase() {
        return base;
    }

    public void setBase(double base) {
        this.base = base;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String calcularArea() {
        double area = (base * altura) / 3;
        return String.format("%.2f", area) + "m³";
    }

    public String toString() {
        return "Área: ";
    }

}
