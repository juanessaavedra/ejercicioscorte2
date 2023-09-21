package ejercicio6;

import ejercicio6.dto.CitasDTO;
import ejercicio6.interfaces.ICita;
import ejercicio6.service.CitasService;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MainCitas {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ICita repo = new CitasService();
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu \n 1. Agregar \n 2. Listar \n 3. Eliminar \n 4. Salir");
            opc = s.next();

            switch (opc) {
                case "1": {
                    System.out.println("Ingrese su nombre");
                    String nom = s.next();
                    System.out.println("Ingrese su cedula");
                    Integer ced = s.nextInt();
                    System.out.println("Ingrese la hora de la cita");
                    String date = s.next();
                    System.out.println("Ingrese el nombre del medico");
                    String med = s.next();
                    repo.save(new CitasDTO(nom,ced,date,med));
                    break;
                }
                case "2": {
                    List<CitasDTO> cita = repo.findAll();
                    if (!cita.isEmpty()) {

                        cita.forEach(System.out::println);
                    } else {
                        System.out.println("No hay registros");
                    }
                    break;
                }

                case "3": {
                    System.out.println("Ingrese su cedula para cancelar la cita");
                    Integer ced = s.nextInt();
                    repo.delete(repo.findByCedula(ced));
                    repo.findAll().forEach(System.out::println);
                    break;
                }
                case "4": {
                    opc = "4";
                    break;
                }

            }



        } while (opc != "4");

    }
}
