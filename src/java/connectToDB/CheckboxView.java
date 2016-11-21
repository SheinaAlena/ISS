package connectToDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CheckboxView {

    private String[] selectedCities;
    private ConnectToDB cities;
    private String[] selectedModesOfTransport;
    private List<String> modesOfTransport;
    private String[] selectedRoute;
    private List<String> route;
    private String[] selectedOffense;
    private List<String> offense;
    private String cart;
    private List<String> tableCity;
    
    public void init() throws Exception {
        cities = new ConnectToDB();
        modesOfTransport = new ArrayList<String>();
        route = new ArrayList<String>();
        offense = new ArrayList<String>();
        cart = "http://www.openstreetmap.org/export/embed.html?bbox=54.12689208984376%2C53.075877572693564%2C57.19207763671876%2C54.06583577161281&amp;layer=mapnik";
        cities.getData("*", "city");
        

    }

    public void query(Statement statement, List<String> list, String param, String dbColumn) throws SQLException {
        ResultSet result = statement.executeQuery(
                "SELECT " + param + " FROM " + dbColumn);
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

    public ConnectToDB getCities() {
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

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

}
