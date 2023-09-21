package ejercicio4.service;

import ejercicio4.dto.TurnosDTO;
import ejercicio4.interfaces.ITurnos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TurnosService implements ITurnos {
    private List<TurnosDTO> turnos;

    public TurnosService () throws IOException, ClassNotFoundException {
        turnos = new ArrayList<>(); //Cola de espera
    }




    @Override
    public TurnosDTO findByTurno(int turno) {
        return turnos.stream()
                .filter(x -> x.getId() == turno)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<TurnosDTO> findAll() throws IOException, ClassNotFoundException {
        turnos = (List<TurnosDTO>) TurnosSeralizar.readObjectFromFile("turnos.ax");
        return turnos;
    }

    @Override
    public void save(TurnosDTO turno) throws IOException {
        turnos.add(turno);
        TurnosSeralizar.writeObjectToFile(turnos, "turnos.ax");
    }

    @Override
    public void update(TurnosDTO turno) throws IOException {
        TurnosDTO oldTurno = findByTurno(turno.getId());
        if (oldTurno != null) {
            turnos.remove(oldTurno);
            turnos.add(turno);
            TurnosSeralizar.writeObjectToFile(turnos, "turnos.ax");
        }
    }

    @Override
    public void delete(TurnosDTO turno) throws IOException {
        turnos.remove(turno);
        TurnosSeralizar.writeObjectToFile(turnos, "turnos.ax");
    }
}
