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
 * ��Apache DBUtils������ļ򵥷�װ��������ȡ���ӡ�����ɾ���ġ���ѯ��������ѯ�����ȷ���
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
     * ��ѯ�����ص��е��е�����
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
     * ��ѯ�����ص������ݣ�Map���
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
     * ��ѯ�����ص������ݣ�ĳ��Bean
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
     * ��ѯ�����ض������ݣ�List<Map>���
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
     * ��ѯ�����ض������ݣ�List<T>
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
     * ���£�����UPDATE��INSERT��DELETE��������Ӱ���������
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
