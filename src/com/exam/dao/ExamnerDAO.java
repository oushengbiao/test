package com.exam.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.exam.bean.Examner;
import com.exam.utils.DBUtil;

public class ExamnerDAO {
//	String url="jdbc:oracle:thin:@localhost:1521:MYDB"; //orcl为数据库的SID 
//	static{
//		try {
//			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
//		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}  
//	}
	//考生登录验证
	public boolean login(String idCar){
		Connection conn=null;
		try {
			String sql="select * from CAR_EXAMINEE where ID_CARD=?";
			DBUtil dbUtil=new DBUtil();
			conn=DBUtil.getConn();
			Examner examner=DBUtil.queryBean(Examner.class, conn, sql, idCar);
			if(examner==null){
				return false;
				
			}else{
				return true;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//			finally{
//			DBUtil.closeConn(conn);
//		}
		return false;  
		
		
		
		
		
	}

}
