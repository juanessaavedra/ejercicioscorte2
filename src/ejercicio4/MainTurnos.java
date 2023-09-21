package ejercicio4;

import ejercicio4.dto.TurnosDTO;
import ejercicio4.interfaces.ITurnos;
import ejercicio4.service.TurnosService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class MainTurnos {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String opc = "1";
        ITurnos repo = new TurnosService();
        ITurnos prueba = (ITurnos) new AtomicInteger(1);


        do {
            Scanner s = new Scanner(System.in);
            System.out.println("Menu \n 1. Tomar turno (Agregar) \n 2. Mostrar cola de espera (listar) \n 3. Llamar cliente (Eliminar) \n 4. Contador de turnos \n 5. Salir =>");
            opc = s.next();

            switch (opc) {
                case "1": {


                    List<TurnosDTO> turnos = prueba.findAll();
                    for (int i = 0; i < 5; i++) {
                       // int turno = turnos.generarTurno();
                       // System.out.println("Se ha generado el turno" + turno);
                    }
                    System.out.println("Id");
                    Integer id = s.nextInt();
                    System.out.println("contador: ");
                    double contador = s.nextDouble();
                    repo.save(new TurnosDTO(id,1));
                    break;






                }
                case "2": {
                    List<TurnosDTO> turnos = repo.findAll();
                    if(!turnos.isEmpty()){ //isEmpty es para
                        turnos.forEach(System.out::println); //Los recorre porque ya los recibio
                    }else{
                        System.out.println("No hay turnos en espera");
                    }
                    break;
                }
                case "3": {

                    System.out.println("Llamar cliente");
                    System.out.print("ingrese el id de su turno ");
                    Integer id = s.nextInt();
                    repo.delete(repo.findByTurno(id));
                    repo.findAll().forEach(System.out::println);
                    break;

                }
                case "4": { //Contador de turnos, una funcion que sume los id

                    System.out.println("Cantidad de turnos totales");




                }
                case "5": {
                    opc = "5";
                    break;
                }
            }
        } while (opc!= "5");
    }
}
