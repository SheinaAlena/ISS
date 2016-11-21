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
        Connection connection = null;
        PreparedStatement ps = null;

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = jdbc.getConnection();
            System.out.println("Соединение установлено");
            ps = connection.prepareStatement("SELECT "+ param1 +" FROM "+ param2);
            ResultSet result = ps.executeQuery();
            ResultSetMetaData md = result.getMetaData();
            int cnt = md.getColumnCount(); // получаем кол-во колонок (1..cnt)
            
            while (result.next()) {               
                for (int i = 1; i <= cnt; i++) {
                    String name = md.getColumnName(i);  // получем имя колонки
                    data.add(result.getString(i));     // получаем значение                 
                }
            }
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
}
