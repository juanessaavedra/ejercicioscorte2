package ejercicio6.service;

import ejercicio6.dto.CitasDTO;
import ejercicio6.interfaces.ICita;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CitasService implements ICita {

    private List<CitasDTO> citas;

    public CitasService() throws IOException, ClassNotFoundException {
        citas = new ArrayList<>();
    }


    @Override
    public CitasDTO findByCedula(int cedula) {
        return citas.stream()
                .filter(cita -> cita.getCedula() == cedula)
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<CitasDTO> findAll() throws IOException, ClassNotFoundException {
        citas = (List<CitasDTO>) ObjectSerializer.readObjectFromFile("Citas.ax");
        return citas;
    }

    @Override
    public void save(CitasDTO cita) throws IOException {
        citas.add(cita);
        ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
    }

    @Override
    public void update(CitasDTO cita) throws IOException {
        CitasDTO oldCita = findByCedula(cita.getCedula());
        if (oldCita != null) {
            citas.remove(oldCita);
            citas.add(cita);
            ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
        }
    }

    @Override
    public void delete(CitasDTO cita) throws IOException {
        citas.remove(cita);
        ObjectSerializer.writeObjectToFile(citas, "Citas.ax");
    }
}
