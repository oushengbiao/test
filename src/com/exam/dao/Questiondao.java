package com.exam.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.exam.bean.QuestionBank;
import com.exam.utils.DBUtil;

public class Questiondao {
	DBUtil dbUtil;
	public Questiondao(){
		dbUtil=new DBUtil();
	}
	public static ArrayList<QuestionBank> innitialPapar() {
		ArrayList<Integer> list=getAllQuestionno();
		return getAllQustion(list);
	}

	/**
	 * 拿到100道题的题目编号集合。。
	 * @return
	 */
	public static ArrayList<Integer> getAllQuestionno() {
		ArrayList<Integer> list=new ArrayList<Integer>();
		String sql="select count(ID_Q) 总数 from CAR_QUESTION where 1=?";
		Connection conn=DBUtil.getConn();
		Object sum=DBUtil.queryColumn("总数", conn, sql, 1);//查询到的数据的列名。。。
		DBUtil.closeConn(conn);
		Random ran=new Random();
		for(int x=0;x<5;x++){
			int no=ran.nextInt(10)+1;
			if(!list.contains(no))
				list.add(no);
			else
				x--;
		}
		return list;	
	}
	//根据题目编号从数据库里面拿题放到list集合中。。
	public static ArrayList<QuestionBank> getAllQustion(ArrayList<Integer> list){
		String sql="select * from CAR_QUESTION where ID_Q=?";
		Connection conn=DBUtil.getConn();
		Object[] arr=new Integer[list.size()];
		int i=0;
		ArrayList<QuestionBank> allQue=new ArrayList<QuestionBank>();
		QuestionBank question;
		for(Integer no:list){
//			System.out.println(no);
			arr[i]=no;
			i++;
		}
		for(int x=0;x<arr.length;x++){
			question=DBUtil.queryBean(QuestionBank.class, conn, sql, arr[x]);
			allQue.add(question);
		}
		return allQue;
		
	}
	
	
	

}
