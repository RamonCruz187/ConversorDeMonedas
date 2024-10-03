package principal;

import modelo.Moneda;
import servicio.ConexionAPI;
import servicio.ConversorJson;
import servicio.FechaYHora;
import servicio.GuardarArchivo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        int salida = 0;
        String monedaOrigen = "", monedaDestino = "";
        double montoAConvertir;
        Scanner teclado = new Scanner(System.in);
        ConexionAPI conexion = new ConexionAPI();
        String menu = """
                ****************************************
                Sea bienvenido/a al Conversor de moneda
                1) Dólar =>> Peso argentino
                2) Peso argentino =>> Dólar
                3) Dólar =>> Real brasileño
                4) Real brasileño =>> Dólar
                5) Dólar =>> Peso colombiano
                6) Peso colombiano =>> Dólar
                7) Salir
                Elija una opción valida:
                ****************************************\n""";
        String banner =
                "   _____ ____  _   ___      ________ _____   _____  ____  _____      _   _   _  \n" +
                        "  / ____/ __ \\| \\ | \\ \\    / /  ____|  __ \\ / ____|/ __ \\|  __ \\    | | | | | | \n" +
                        " | |   | |  | |  \\| |\\ \\  / /| |__  | |__) | (___ | |  | | |__) |  / __) __) __)\n" +
                        " | |   | |  | | . ` | \\ \\/ / |  __| |  _  / \\___ \\| |  | |  _  /   \\__ \\__ \\__ \\\n" +
                        " | |___| |__| | |\\  |  \\  /  | |____| | \\ \\ ____) | |__| | | \\ \\   (   (   (   /\n" +
                        "  \\_____\\____/|_| \\_|   \\/   |______|_|  \\_\\_____/ \\____/|_|  \\_\\   |_| |_| |_| \n";


        System.out.println(banner);
        while (salida != 7) {
            System.out.println(menu);
            try {
                salida = teclado.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Solo se aceptan valores enteros del 1 al 7");
            }
            if (salida < 1 || salida > 7) {
                System.out.println("Opción no valida. Solo se aceptan valores del 1 al 7");
                break;
            } else if (salida == 7) {
                System.out.println("Hasta pronto");
                break;
            }

            System.out.println("Ingrese el valor a convertir");
            try {
                montoAConvertir = teclado.nextDouble();

                switch (salida) {
                    case 1:
                        monedaOrigen = "USD";
                        monedaDestino = "ARS";
                        break;
                    case 2:
                        monedaOrigen = "ARS";
                        monedaDestino = "USD";
                        break;
                    case 3:
                        monedaOrigen = "USD";
                        monedaDestino = "BRL";
                        break;
                    case 4:
                        monedaOrigen = "BRL";
                        monedaDestino = "USD";
                        break;
                    case 5:
                        monedaOrigen = "USD";
                        monedaDestino = "COP";
                        break;
                    case 6:
                        monedaOrigen = "COP";
                        monedaDestino = "USD";
                        break;
                    case 7:
                        System.out.println("Hasta pronto");
                        break;
                    default:
                        System.out.println("Opción no valida. Solo se aceptan valores del 1 al 7");
                        salida = 7;
                        break;
                }

                //Conectamos con la base de datos y guardamos la consulta como un string
                String json = conexion.getConversion(monedaOrigen, monedaDestino, montoAConvertir);

                //Convertimos el json en un objeto Moneda
                ConversorJson conversorJson = new ConversorJson();
                Moneda moneda = conversorJson.convertir(json);
                moneda.setCantidad(montoAConvertir);

                //Creamos una instancia de la clase FechaYHora
                FechaYHora fechaYHora = new FechaYHora();

                //Imprimimos el resultado
                System.out.println("\n-------------------------------------------------------------------------------");
                System.out.println(moneda);
                System.out.println("-------------------------------------------------------------------------------\n");

                //Guardamos la consulta y la fecha en el archivo
                GuardarArchivo guardarArchivo = new GuardarArchivo();
                boolean guardadoOk = guardarArchivo.guardar("\n" + fechaYHora.getFechaYHora() + " ===>> " + moneda);

                if (guardadoOk) {
                    System.out.println("Archivo guardado con exito");
                } else {
                    System.out.println("Error al guardar el archivo");
                }

            } catch (InputMismatchException e) {
                salida = 7;
                System.out.println("Solo se aceptan valores numéricos positivos");
            } catch (Exception e) {
                salida = 7;
                System.out.println(e.getMessage());
            }
        }
    }
}
