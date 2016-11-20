/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectToDB;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Алена
 */
public class JDBC {
    private static final Logger log=Logger.getLogger(JDBC.class.getName());
    private DataSource dataSource;
    
    public JDBC(){        
    }
    
    public void init(String dataSourceName){
        try{
            InitialContext initContext = new InitialContext();
            dataSource=(DataSource) initContext.lookup(dataSourceName);
        } catch (NamingException e){
            log.log(Level.SEVERE, "JNDIException: {0}", e.getMessage());
        }
    }
    public Connection getConnection() throws SQLException {
        if (dataSource == null) {
            throw new SQLException("DataSource is null.");
        }
         return dataSource.getConnection();
    }
}
