/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.presentacion.tablesmodel;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import mochilear.Entidades.Cliente;

/**
 *
 * @author andres
 */
public class ClientesTable extends AbstractTableModel{

    List<Cliente> rows;
    int[] cols;

    
    public ClientesTable(List<Cliente> rows, int[] cols) {
        this.rows = rows;
        this.cols = cols;
        initColNames();
    }
    
    public static final int CEDULA=0;
    public static final int NOMBRE=1;
    public static final int TELEFONO=2;
    public static final int CORREO=3; 
    public static final int RESIDENCIA=4;
    //-----------------------------------------
    String[] colNames = new String[5];
    private void initColNames(){
        colNames[CEDULA]= "CEDULA";
        colNames[NOMBRE]= "NOMBRE";
        colNames[TELEFONO]= "TELEFONO";
        colNames[RESIDENCIA]= "Residencia";
        colNames[CORREO]= "EMAIL";
    }
    
    @Override
    public int getRowCount() {
        return rows.size();
    }

    @Override
    public int getColumnCount() {
        return cols.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = rows.get(rowIndex);
        switch (cols[columnIndex]){
            case CEDULA: return cliente.getCedula();
            case NOMBRE: return cliente.getNombre();
            case TELEFONO: return cliente.getTelefono();
            case RESIDENCIA: return cliente.getResidencia();
            case CORREO: return cliente.getCorreo();
            default: return "";
        }
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
       //Me regresa el Tipo de Instrumento por cierta fila
    public Cliente getRowAt(int row) {
        return rows.get(row);
    }
    
    
}
