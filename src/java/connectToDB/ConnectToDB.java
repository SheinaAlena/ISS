/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Алена
 */
public class ConnectToDB {

    private static final JDBC jdbc = DataAccessFactory.getJDBCUtils();

    public static List<String> getData(String param1, String param2) throws Exception {
        List<String> data = new ArrayList<String>();
        List<String> name = new ArrayList<String>();
        Connection connection = null;
        Statement ps = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = jdbc.getConnection();
            System.out.println("Соединение установлено");
            ps = connection.createStatement();
            //Выполним запрос
            ResultSet result = ps.executeQuery(
                    "SELECT " + param1 + " FROM " + param2);
            ResultSetMetaData md = result.getMetaData();
            int cnt = md.getColumnCount(); // получаем кол-во колонок (1..cnt)
           
            while (result.next()) {
                for (int i = 1; i <= cnt; i++) {
                    data.add(result.getString(i));    // получаем значение  
                }
            }
            
            for (int i = 1; i <= cnt; i++) {
                name.add(md.getColumnName(i));  // получем имя колонки
                
            }
            System.out.println(name);

        } catch (Exception ex) {
            //выводим наиболее значимые сообщения
            Logger.getLogger(CheckboxView.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CheckboxView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return data;

    }

    public static List<String> nameColumns(ResultSetMetaData md) {
        List<String> nameColumns = new ArrayList<String>();
        
        try {
            int cnt = md.getColumnCount();
            for (int i = 1; i <= cnt; i++) {
                nameColumns.add(md.getColumnName(i));
            }  // получем имя колонки
        } catch (SQLException ex) {
            Logger.getLogger(ConnectToDB.class.getName()).log(Level.SEVERE, null, ex);

        }
        return nameColumns;

    }

}
