package com.example.volumes;

public class Cilindro {
    private double raio;
    private double altura;

    public Cilindro(double raio, double altura) {
        this.raio = raio;
        this.altura = altura;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double calcularVol() {
        return Math.PI * Math.pow(raio, 2) * altura;
    }

    @Override
    public String toString() {
        return String.format("O volume do cilindro é: %.1f m³", calcularVol());
    }
}
