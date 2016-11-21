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
public class DataAccessFactory {
    private static final DataAccessFactory instance = new DataAccessFactory();
    private JDBC jdbcUtil;
 
    private DataAccessFactory() {
    }
 
    public static DataAccessFactory getInstance() {
        return instance;
    }
 
    private JDBC prepareJDBCUtils() {
        if (jdbcUtil == null) {
            jdbcUtil = new JDBC();
            jdbcUtil.init("jdbc/ISS");
        }
 
        return jdbcUtil;
    }
 
    public static synchronized JDBC getJDBCUtils() {
        return getInstance().prepareJDBCUtils();
    }
}

