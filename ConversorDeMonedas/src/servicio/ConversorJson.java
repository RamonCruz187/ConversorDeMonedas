package servicio;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import modelo.ConversorExchangeRate;
import modelo.Moneda;

public class ConversorJson {
    public Moneda convertir(String json){
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .create();
        ConversorExchangeRate conversorExchangeRate = gson.fromJson(json, ConversorExchangeRate.class);
        return new Moneda(conversorExchangeRate);

    }
}
