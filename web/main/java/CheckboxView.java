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
    private String[] selectedOffense;
    private List<String> offense;
    
     @PostConstruct
    public void init() {
        cities = new ArrayList<String>();
        modesOfTransport = new ArrayList<String>();
        route = new ArrayList<String>();
        offense=new ArrayList<String>();
        
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
            
            query(statement,cities,"city","city");
            query(statement,modesOfTransport,"modes","modes_of_transport");
            //query(statement,route,"\"nameRoute"\","route"); 
            ResultSet result3 = statement.executeQuery(
                    "SELECT \"nameRoute\" FROM route");
            while (result3.next()) {
              route.add(result3.getString("nameRoute"));              
            }
            query(statement,offense,"type","offense");
            
           
            
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

    public void query(Statement statement,List<String> list, String param, String dbColumn) throws SQLException {
        ResultSet result = statement.executeQuery(
                "SELECT "+param+" FROM "+dbColumn);
        while (result.next()) {
            list.add(result.getString(param));
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
    
    public String[] getSelectedOffense() {
        return selectedOffense;
    }
 
    public void setSelectedOffense(String[] selectedOffense) {
        this.selectedOffense = selectedOffense;
    }
 
    public List<String> getOffense() {
        return offense;
    } 
    
}