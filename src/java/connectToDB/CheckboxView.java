package connectToDB;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean
public class CheckboxView {

    private String[] selectedCities;
    private ConnectToDB dbRequest;
    private String[] selectedModesOfTransport;
    private List<String> modesOfTransport;
    private String[] selectedRoute;
    private List<String> route;
    private String[] selectedOffense;
    private List<String> offense;
    private String cart;
    //
    private List<String> cities;

    @PostConstruct
    public void init() {
        dbRequest = new ConnectToDB();
        modesOfTransport = new ArrayList<String>();
        cities = new ArrayList<String>();
        route = new ArrayList<String>();
        offense = new ArrayList<String>();
        
        try {
           cities=dbRequest.getData("name", "city");
           modesOfTransport=dbRequest.getData("name", "modes_of_transport");
           route=dbRequest.getData("route.\"nameRoute\"", "route");
           
           
        } catch (Exception ex) {
            Logger.getLogger(CheckboxView.class.getName()).log(Level.SEVERE, null, ex);
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

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }

}
