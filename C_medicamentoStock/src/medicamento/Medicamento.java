//@edgar
package medicamento;

public class Medicamento {
    Conexion con = new Conexion();
    /*public static void main(String[] args) {
        //Conexion con = new Conexion();
        Medicamento med = new Medicamento();
        //con.conectar();
        int res = med.stockMedicamento(15,"ibuprofeno","bago");
        System.out.println(" "+res+" "); 
        //con.buscarStock();
    }*/
    public boolean stockMedicamento(int codigo,String nombre,String marca){
        int cant;
        con.conectar();
        cant = con.buscarStock(codigo,nombre,marca);
        //return cant;
        return (cant > 10)? true:false;
        //return true;
    }
}
