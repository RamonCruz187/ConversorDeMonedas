package modelo;

public class Moneda {
    private String monedaOrigen;
    private String monedaDestino;
    private double cantidad;
    private double conversion_rate;
    private double conversion_result;

    public Moneda() {
    }



    public Moneda(ConversorExchangeRate conversorExchangeRate) {
        this.monedaOrigen = conversorExchangeRate.base_code();
        this.monedaDestino = conversorExchangeRate.target_code();
        this.conversion_rate = conversorExchangeRate.conversion_rate();
        this.conversion_result = conversorExchangeRate.conversion_result();
    }

    public String getMonedaOrigen() {
        return monedaOrigen;
    }

    public void setMonedaOrigen(String monedaOrigen) {
        this.monedaOrigen = monedaOrigen;
    }

    public String getMonedaDestino() {
        return monedaDestino;
    }

    public void setMonedaDestino(String monedaDestino) {
        this.monedaDestino = monedaDestino;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getConversion_rate() {
        return conversion_rate;
    }

    public void setConversion_rate(double conversion_rate) {
        this.conversion_rate = conversion_rate;
    }

    public double getConversion_result() {
        return conversion_result;
    }

    public void setConversion_result(double conversion_result) {
        this.conversion_result = conversion_result;
    }

    @Override
    public String toString() {
        return "El valor de "+cantidad+" ["+monedaOrigen+"] corresponden al valor final de =>>> "+conversion_result+" ["+monedaDestino+"]";
    }
}


