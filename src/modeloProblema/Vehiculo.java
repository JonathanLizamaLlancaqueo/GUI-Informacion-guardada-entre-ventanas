package modeloProblema;

public class Vehiculo {

    private String patente;
    private String modelo;
    private Tipo tipo;
    private int tiempo;
    private double valor;

    public Vehiculo(String patente, String modelo, Tipo tipo, int tiempo, double valor) {
        this.patente = patente;
        this.modelo = modelo;
        this.tipo = tipo;
        this.tiempo = tiempo;
        this.valor = valor;
    }

    public String getPatente() {
        return this.patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getModelo() {
        return this.modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public int getTiempo() {
        return this.tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public double getValor() {
        return this.valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String toString() {
        return "Patente: " + patente + ", Modelo: " + modelo + ", Tipo: " + tipo.toString() + ", Tiempo: " + tiempo + ", Valor: $" + valor;
    }

}
