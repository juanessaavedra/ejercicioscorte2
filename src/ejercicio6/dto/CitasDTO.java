package ejercicio6.dto;

public class CitasDTO {

    private String nombrePaciente;

    private Integer cedula;

    private String fechaHora; //Las citas deben mostrarse en oden de fecha y hora .sort


    private String nombreMedico;


    public CitasDTO(String nombrePaciente, Integer cedula, String fechaHora, String nombreMedico) {
        this.nombrePaciente = nombrePaciente;
        this.cedula = cedula;
        this.fechaHora = fechaHora;
        this.nombreMedico = nombreMedico;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getNombreMedico() {
        return nombreMedico;
    }

    public void setNombreMedico(String nombreMedico) {
        this.nombreMedico = nombreMedico;
    }

    @Override
    public String toString() {
        return "CitasDTO{" +
                "nombrePaciente='" + nombrePaciente + '\'' +
                ", cedula=" + cedula +
                ", fechaHora='" + fechaHora + '\'' +
                ", nombreMedico='" + nombreMedico + '\'' +
                '}';
    }
}

