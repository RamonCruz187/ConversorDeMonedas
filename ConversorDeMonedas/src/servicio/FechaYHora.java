package servicio;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FechaYHora {
    LocalDateTime fechaYHora = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    String formattedDate = fechaYHora.format(formatter);

    public String getFechaYHora() {
        return "Consulta realizada con fecha y hora: " + formattedDate;
    }
}
