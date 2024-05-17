package com.example.volumes;

public class Esfera {

    private double raio;

    public Esfera(double raio) {
        this.raio = raio;
    }

    public double getRaio() {
        return raio;
    }

    public void setRaio(double raio) {
        this.raio = raio;
    }

    @Override
    public String toString() {
        return "Esfera{" +
                "Raio: " + raio +
                "}";
    }

    private double volume;
    public double calcularVolume(){
        volume = (4 * 3.14 * raio)/3;
        return volume;
    }
}

