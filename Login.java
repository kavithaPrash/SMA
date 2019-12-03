package com.controller;

import java.net.UnknownHostException;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.net.UnknownHostException;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.bson.Document;

import com.bean.Admin;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.DBObject;
import com.mongodb.BasicDBObject;

import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoCredential;


@WebServlet("/Login")
public class Login extends HttpServlet{
		
		MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		MongoCredential credential=MongoCredential.createCredential("groupd", "sma", 
				   "sma".toCharArray()); 
		MongoDatabase database = mongo.getDatabase("sma");
		MongoCollection<Document> collection = database.getCollection("Admin");
		
		public Login() {
			super();
		}
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("emailid");
		String pwd = request.getParameter("pswd");
		
	
	  
	    int count=0;
	    int flag=0;
	    BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("emailid", uname);
		searchQuery.put("pswd", pwd);
		BasicDBObject where=new BasicDBObject();
		where.put("$and",searchQuery);
		FindIterable<Document> cursor = collection.find(searchQuery);
		Iterator curs = cursor.iterator(); 
		while (curs.hasNext()) {
			System.out.println(curs.next());
			count++;
			System.out.println(count);
		    flag=1;
		}
		
		if(flag==0)
		{
			System.out.println("Login failed");
			RequestDispatcher req = request.getRequestDispatcher("/Login.jsp");
			req.forward(request, response);
		}
		else
		{
			System.out.println("Login Success");
			RequestDispatcher req = request.getRequestDispatcher("/welcome.jsp");
			req.forward(request, response);
		}
		
		}

}

