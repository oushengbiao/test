package com.exam.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 * 对Apache DBUtils工具类的简单封装，包括获取连接、增、删、改、查询多条、查询单条等方法
 * @author Administrator
 *
 */
public class DBUtil {
	private static final QueryRunner runner = new QueryRunner();
	
    public static Connection getConn() {
        Connection conn = null;
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();//.newInstance();????
            conn = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521:ORCL","scott", "oubiao1991");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    public static void closeConn(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 查询：返回单行单列的数据
     * @param column
     * @param conn
     * @param sql
     * @param params
     * @return T
     */
    public static <T> T queryColumn(String column, Connection conn, String sql, Object... params) {
        T result = null;
        try {
            result = runner.query(conn, sql, new ScalarHandler<T>(column), params);
            closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 查询：返回单条数据，Map结果
     * @param conn
     * @param sql
     * @param params
     * @return Map
     */
    public static Map<String, Object> queryMap(Connection conn, String sql, Object... params) {
        Map<String, Object> result = null;
        try {
            result = runner.query(conn, sql, new MapHandler(), params);
            closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
    /**
     * 查询：返回单条数据，某个Bean
     * @param cls
     * @param map
     * @param conn
     * @param sql
     * @param params
     * @return T
     */
    public static <T> T queryBean(Class<T> cls, Connection conn, String sql, Object... params) {
        T result = null;
        try {
        	result = runner.query(conn, sql, new BeanHandler<T>(cls), params);
//        	closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询：返回多条数据，List<Map>结果
     * @param conn
     * @param sql
     * @param params
     * @return List<Map>
     */
    public static List<Map<String, Object>> queryMapList(Connection conn, String sql, Object... params) {
        List<Map<String, Object>> result = null;
        try {
            result = runner.query(conn, sql, new MapListHandler(), params);
            closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
    
   
    /**
     * 查询：返回多条数据，List<T>
     * @param cls
     * @param map
     * @param conn
     * @param sql
     * @param params
     * @return List<T>
     */
    public static <T> List<T> queryBeanList(Class<T> cls, Connection conn, String sql, Object... params) {
        List<T> result = null;
        try {
        	result = runner.query(conn, sql, new BeanListHandler<T>(cls), params);
        	closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 更新（包括UPDATE、INSERT、DELETE，返回受影响的行数）
     * @param conn
     * @param sql
     * @param params
     * @return int
     */
    public static int update(Connection conn, String sql, Object... params) {
        int result = 0;
        try {
            result = runner.update(conn, sql, params);
            closeConn(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }
}
