/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToDB;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import connectToDB.ConnectToDB;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author Алена
 */
@ManagedBean
public class dataDB extends ConnectToDB implements Serializable {

    private List<String> tableCity;
    private List<String> columns;
    private int cnt;
    private ConnectToDB dbTransport = new ConnectToDB();

    @PostConstruct
    public void init() {

    }

    public void buttonAction() {
        try {
            tableCity = ConnectToDB.getData("*", "city").data;
            columns = ConnectToDB.getData("*", "city").name;
            cnt = columns.size();
        } catch (Exception ex) {
            Logger.getLogger(dataDB.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public List<String> getColumns() {
        return columns;
    }

    public int getCnt() {
        return cnt;
    }

    public List<String> getTableCity() {
        return tableCity;
    }

    private int n = 0;
    private int n2 = 0;

    public String NumberOfColumn() {
        String nn = columns.get(n);
        n++;
        return nn;
    }

    public String NumberOfRecords() {
        String n1 = null;
        try {
            n1 = tableCity.get(n2);
            n2++;        

        } catch (Exception e) {
            System.out.println(e);
        }
        return n1;

    }
//    public void onRowEdit(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Car Edited", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }
//     
//    public void onRowCancel(RowEditEvent event) {
//        FacesMessage msg = new FacesMessage("Edit Cancelled", ((Car) event.getObject()).getId());
//        FacesContext.getCurrentInstance().addMessage(null, msg);
//    }

}
