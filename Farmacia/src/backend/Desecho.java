package backend;

import java.sql.Date;

public class Desecho {
    private int idMedicamento;
    private Date fecha;
    private float totalPerdido;
    private int cantidad;
    private String motivoDesecho;

    public Desecho(int idMedicamento, Date fecha, float totalPerdido, int cantidad, String motivoDesecho){
        this.idMedicamento = idMedicamento;
        this.fecha = fecha;
        this.totalPerdido = totalPerdido;
        this.cantidad = cantidad;
        this.motivoDesecho = motivoDesecho;
    }

    public Date getFecha() {
        return fecha;
    }

    public float getTotalPerdido() {
        return totalPerdido;
    }

    public int getCantidad() {
        return cantidad;
    }

    public int getIdMedicamento() {
        return idMedicamento;
    }

    public String getMotivoDesecho() {
        return motivoDesecho;
    }
}
