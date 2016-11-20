/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToDB;

/**
 *
 * @author Алена
 */
public class Transport {
    int id_transport;
    String number_transport;
    String city_transport;
    String route_transport;
    String modes_trnsport;

    Transport() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_transport() {
        return id_transport;
    }

    public void setId_transport(int id_transport) {
        this.id_transport = id_transport;
    }

    public String getNumber_transport() {
        return number_transport;
    }

    public void setNumber_transport(String number_transport) {
        this.number_transport = number_transport;
    }

    public String getCity_transport() {
        return city_transport;
    }

    public void setCity_transport(String city_transport) {
        this.city_transport = city_transport;
    }

    public String getRoute_transport() {
        return route_transport;
    }

    public void setRoute_transport(String route_transport) {
        this.route_transport = route_transport;
    }

    public String getModes_trnsport() {
        return modes_trnsport;
    }

    public void setModes_trnsport(String modes_trnsport) {
        this.modes_trnsport = modes_trnsport;
    }

    
    
}
