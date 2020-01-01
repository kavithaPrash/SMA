package com.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.controller.AllSystemDetails;

@WebServlet("/Deallocation")
public class Deallocation extends HttpServlet{
	
	MongoClient mongoClient = new MongoClient();
    DB database = mongoClient.getDB("sma");
    DBCollection collection = database.getCollection("System");
	
	public Deallocation() {
		super();
	}
	
	protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
		System.out.println("Allocation");
		String systemid = AllSystemDetails.Systemid();
		DBObject query = new BasicDBObject("sysid", systemid);
		DBCursor cursor = collection.find(query);
		Double status=(Double)cursor.one().get("status");
		
		if(status==0.0) {
			
			JOptionPane.showMessageDialog(null, "System not allocated!!");

			RequestDispatcher req = request.getRequestDispatcher("/welcome.jsp");
			request.getRequestDispatcher("welcome.jsp").forward(request, response);
			req.forward(request, response);
			
			
		}
		else 
		{	
		//  String employeeid=JOptionPane.showInputDialog("enter employee id");
			 int input = JOptionPane.showConfirmDialog(null, 
		                "Are you sure to deallocate system!!", "Customized Dialog", 
		                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE,null);
			 System.out.println(input);
			 
			 //if input 0 - >ok 
			 //if input 2-> cancel
			 
			 if(input==0) {
				 BasicDBObject updatequery = new BasicDBObject();
					updatequery.append("$set", new BasicDBObject().append("empid","None"));				
					BasicDBObject searchQuery = new BasicDBObject().append("sysid", systemid);
					collection.update(searchQuery,updatequery);
					
					BasicDBObject updatestatusquery = new BasicDBObject();
					updatestatusquery.append("$set", new BasicDBObject().append("status", 0.0));				
					BasicDBObject updateQuery = new BasicDBObject().append("sysid", systemid);
					collection.update(updateQuery,updatestatusquery);
					
					RequestDispatcher req = request.getRequestDispatcher("/welcome.jsp");
					request.getRequestDispatcher("welcome.jsp").forward(request, response);
					req.forward(request, response);
			 }
			 
			 else {
		RequestDispatcher req = request.getRequestDispatcher("/welcome.jsp");
		request.getRequestDispatcher("welcome.jsp").forward(request, response);
		req.forward(request, response);
			 }
		}
	}
}
