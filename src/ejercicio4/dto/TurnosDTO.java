package ejercicio4.dto;

import java.io.Serializable;

public class TurnosDTO implements Serializable {
    private Integer id; //Una funcion que sume los id

    private double contadorTurnos;

    public TurnosDTO(Integer id, double contadorTurnos) {
        this.id = id;
        this.contadorTurnos = contadorTurnos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getContadorTurnos() {
        return contadorTurnos;
    }

    public void setContadorTurnos(double contadorTurnos) {
        this.contadorTurnos = contadorTurnos;
    }

    @Override
    public String toString() {
        return "TurnosDTO{" +
                "id=" + id +
                ", contadorTurnos=" + contadorTurnos +
                '}';
    }
}
