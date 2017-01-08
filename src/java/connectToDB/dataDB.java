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
public class dataDB implements Serializable {

    private List<String> directory;
    private List<String> tableCity;
    private String nameTable;
    private String columnName;
    private List<ColumnModel> columns;
    private ConnectToDB dbTransport = new ConnectToDB();

    @PostConstruct
    public void init() {
        
    }
    
    public void buttonAction() {
        directory = new ArrayList<String>();
        try {
            tableCity = dbTransport.getData("*", "city");
            
            System.out.println(tableCity);
        } catch (Exception ex) {
            Logger.getLogger(dataDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        //init();       
        createDynamicColumns();
    }

    public List<String> getTableCity() {
        return tableCity;
    }

    public String getNameTable() {
        return nameTable;

    }

    
    private void createDynamicColumns() {
        columns = new ArrayList<ColumnModel>();
          

    }

    static public class ColumnModel implements Serializable {

        private String header;
        private String property;

        public ColumnModel(String header, String property) {
            this.header = header;
            this.property = property;
        }

        public String getHeader() {
            return header;
        }

        public String getProperty() {
            return property;
        }

    }

    public List<ColumnModel> getColumns() {
        return columns;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

}
