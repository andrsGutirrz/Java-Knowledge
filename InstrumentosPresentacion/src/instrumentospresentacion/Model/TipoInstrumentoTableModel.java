/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package instrumentospresentacion.Model;

import instrumentosEntidades.TipoInstrumento;
import java.util.List;
import javax.swing.table.AbstractTableModel;


public class TipoInstrumentoTableModel extends AbstractTableModel{
    List<TipoInstrumento> rows;//FILAS que contienen Tipos de instrumentos
    int[] cols;//COLUMNAS donde se guardar cada atributo de los Tipos de instrumentos

    //-----CONSTRUCTOR CON PARAMETROS-------
    public  TipoInstrumentoTableModel(int[] cols, List<TipoInstrumento> rows){
        this.cols=cols;
        this.rows=rows;
        initColNames();
    }
    //----OBTENER LA CANTIDAD DE COLUMNAS----
    public int getColumnCount() {
        return cols.length;
    }
    //--OBTENER EL NOMBRE DE CADA COLUMNA---
    public String getColumnName(int col){
        return colNames[cols[col]];
    }

    public Class<?> getColumnClass(int col){
        switch (cols[col]){
            default: return super.getColumnClass(col);
        }    
    }    
    //--OBTENER EL TAMANO DE LA FILA
    public int getRowCount() {
        return rows.size();
    }
    //--OBTIENE UN INSTRUMENTO POR 
    public Object getValueAt(int row, int col) {
        TipoInstrumento ti = rows.get(row);
        switch (cols[col]){
            case CODIGO: return ti.getCodigo();
            case NOMBRE: return ti.getNombre();
            case UNIDAD: return ti.getUnidad();
            
            default: return "";
        }
    }    

   //Me regresa el Tipo de Instrumento por cierta fila
    public TipoInstrumento getRowAt(int row) {
        return rows.get(row);
    }
    
    public static final int CODIGO=0;
    public static final int NOMBRE=1;
    public static final int UNIDAD=2;
   
    String[] colNames = new String[3];
    private void initColNames(){
        colNames[CODIGO]= "Codigo";
        colNames[NOMBRE]= "Nombre";
        colNames[UNIDAD]= "Unidad";
        
    }
            
}
