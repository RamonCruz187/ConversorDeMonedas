package servicio;

import java.io.FileWriter;

public class GuardarArchivo {
    public boolean guardar(String consulta) {
        try {
            FileWriter writer = new FileWriter("consultas.txt", (true));
            writer.write(consulta);
            writer.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}