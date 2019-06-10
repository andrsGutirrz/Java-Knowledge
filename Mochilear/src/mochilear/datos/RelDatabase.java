/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mochilear.datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jsanchez
 */
public class RelDatabase {

    public static final String PROPERTIES_FILE_NAME = "/mochilear.properties";
    Connection cnx;

    public RelDatabase() {
        cnx=this.getConnection();
    }

    public Connection getConnection() {
        try {
             
            String driver = "com.mysql.jdbc.Driver";            
            String URL_conexion="jdbc:mysql://localhost:3306/Mochilear?user=root&password=password";
            Class.forName(driver).newInstance();
            return DriverManager.getConnection(URL_conexion);
        } catch (Exception e) {
            System.err.println(e.getMessage() + " error");
            System.exit(-1);
        }
        return null;
    }

    public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public ResultSet executeQuery(String statement) {
        try {
            Statement stm = cnx.createStatement();
            return stm.executeQuery(statement);
        } catch (SQLException ex) {
        }
        return null;
    }

    public int executeUpdateWithKeys(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement, Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stm.getGeneratedKeys();
            keys.next();
            return keys.getInt(1);
        } catch (SQLException ex) {
            return -1;
        }
    }
}
