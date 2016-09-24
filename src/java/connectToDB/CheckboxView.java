package connectToDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

 
@ManagedBean
public class CheckboxView {
    private String[] selectedCities;
    private List<String> cities;
    private String[] selectedModesOfTransport;
    private List<String> modesOfTransport;
    private String[] selectedRoute;
    private List<String> route;
    
     @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        modesOfTransport = new ArrayList<String>();
        route = new ArrayList<String>();
        
        Connection connection = null;
        String url = "jdbc:postgresql://localhost:5432/RSS";
        String name = "postgres";
        String password = "123";
        try {           
            Class.forName("org.postgresql.Driver");
            System.out.println("Драйвер подключен");
            connection = DriverManager.getConnection(url, name, password);
            System.out.println("Соединение установлено");
            Statement statement = null;
            statement = connection.createStatement();
            
            ResultSet result1 = statement.executeQuery(
                    "SELECT city FROM city");
            while (result1.next()) {
              cities.add(result1.getString("city"));
              
            }
            ResultSet result2 = statement.executeQuery(
                    "SELECT modes FROM modes_of_transport");
            while (result2.next()) {
              modesOfTransport.add(result2.getString("modes"));
              
            }
            ResultSet result3 = statement.executeQuery(
                    "SELECT nameRoute FROM route");
            while (result3.next()) {
              route.add(result3.getString("nameRoute"));
              
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
 
    }
  
    public String[] getSelectedCities() {
        return selectedCities;
    }
 
    public void setSelectedCities(String[] selectedCities) {
        this.selectedCities = selectedCities;
    }
 
    public List<String> getCities() {
        return cities;
    } 
    
    public String[] getSelectedModesOfTransport() {
        return selectedModesOfTransport;
    }
 
    public void setSelectedModesOtransport(String[] selectedModesOfTransport) {
        this.selectedModesOfTransport = selectedModesOfTransport;
    }
 
    public List<String> getModesOfTransport() {
        return modesOfTransport;
    }
 
    public String[] getSelectedRoute() {
        return selectedRoute;
    }
 
    public void setSelectedRoute(String[] selectedRoute) {
        this.selectedRoute = selectedRoute;
    }
 
    public List<String> getRoute() {
        return route;
    } 
    
}