//@edgar
package medicamento;

public class Medicamento {
    Conexion con = new Conexion();
    public static void main(String[] args) {
        //Conexion con = new Conexion();
        Medicamento med = new Medicamento();
        //con.conectar();
        boolean res = med.stockMedicamento(3,"stul");
        
        //con.buscarStock();
    }
    public boolean stockMedicamento(int codigo,String marca){
        int cant;
        con.conectar();
        cant = con.buscarStock(codigo,marca);
        return (cant < 10)? true:false;       
    }
}
