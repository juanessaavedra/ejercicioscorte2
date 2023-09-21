package ejercicio4.interfaces;

import ejercicio4.dto.TurnosDTO;

import java.io.IOException;
import java.util.List;

public interface ITurnos {

    TurnosDTO findByTurno(int id);

    List<TurnosDTO> findAll() throws IOException, ClassNotFoundException;


    void save (TurnosDTO turno) throws IOException;

    void update (TurnosDTO turno) throws IOException;

    void delete (TurnosDTO turno) throws IOException;
}
