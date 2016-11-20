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

/**
 *
 * @author Алена
 */

public class dataDB implements Serializable {

    private List<String> directory;
    private List<String> tableTransport;
    private String nameTable;
    private String columnName;
    private List<ColumnModel> columns;
    private ConnectToDB dbTransport= new  ConnectToDB();
    
    public dataDB() throws SQLException, Exception {
        tableTransport = new ArrayList();
        tableTransport=ConnectToDB.getData("*", "city");
        //dbTransport.getData("*","city");
        createDynamicColumns();
    }

    public List<String> getTableTransport() {
        return tableTransport;
    }

    public void setTableTransport(List<String> tableTransport) {
        this.tableTransport = tableTransport;
    }

    @PostConstruct
    public void init() {
        directory = new ArrayList<String>();
        directory.add("Транспорт");
        directory.add("Города и районы");
        directory.add("Виды перевозок");
        directory.add("Нарушения");
        directory.add("Маршруты");
    }

    public String getNameTable() {
        return nameTable;

    }

    private void createDynamicColumns() {  
        columns= new ArrayList<ColumnModel>();
        columns.add(new ColumnModel("Госномер","number"));
        columns.add(new ColumnModel("Город/район","city"));
        columns.add(new ColumnModel("Тип перевозок","modes"));
        
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
