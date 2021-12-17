package capa_Logica;

public class Proyecto {

    private String codigo;
    private String tituloDelProyecto;
    private double costo;
    private int meses;
    
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTituloDelProyecto() {
        return tituloDelProyecto;
    }

    public void setTituloDelProyecto(String tituloDelProyecto) {
        this.tituloDelProyecto = tituloDelProyecto;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getMeses() {
        return meses;
    }

    public void setMeses(int meses) {
        this.meses = meses;
    }
}
