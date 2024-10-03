package servicio;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConexionAPI {
    private String APIKEY = "006860a6e6d5fc22ff0aa3fa";
    private String urlBase = "https://v6.exchangerate-api.com/v6/" + APIKEY + "/pair/";

    public String getConversion(String monedaOrigen, String monedaDestino, double cantidad) throws IOException, InterruptedException {
        String url = urlBase + monedaOrigen + "/" + monedaDestino + "/" + cantidad;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
