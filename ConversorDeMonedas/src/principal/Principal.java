package principal;

import modelo.Moneda;
import servicio.ConexionAPI;
import servicio.ConversorJson;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        int salida = 0;
        String monedaOrigen = "", monedaDestino = "";
        double montoAConvertir = 0;
        Scanner teclado = new Scanner(System.in);
        ConexionAPI conexion = new ConexionAPI();

        String menu= """
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
                ****************************************""";

        while (salida != 7) {

            System.out.println(menu);
            salida = teclado.nextInt();

            if (salida == 7){break;}
            System.out.println("Ingrese el valor a convertir");
            montoAConvertir = teclado.nextDouble();

            switch (salida) {
                case 1:
                    monedaOrigen = "USD";
                    monedaDestino = "ARS";
                    break;
                case 2:
                    System.out.println("Ingrese la cantidad de pesos argentinos que quiere convertir: ");

                    break;
                case 3:
                    System.out.println("Ingrese la cantidad de dolares que quiere convertir: ");

                    break;

                default:
                    System.out.println("Opción no valida");
                    salida = 7;
                    break;

            }
            String json= conexion.getConversion(monedaOrigen,monedaDestino, montoAConvertir);
            ConversorJson conversorJson = new ConversorJson();
            Moneda moneda = conversorJson.convertir(json);
            moneda.setCantidad(montoAConvertir);

            System.out.println(moneda);


}}}
