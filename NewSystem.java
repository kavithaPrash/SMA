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
import org.bson.types.ObjectId;

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
import com.mongodb.DBCursor;
import com.mongodb.client.MongoDatabase; 
import com.mongodb.MongoCredential;
import static java.lang.System.out;


@WebServlet("/NewSystem")
public class NewSystem extends HttpServlet{
		
		/*MongoClient mongo = new MongoClient( "localhost" , 27017 ); 
		MongoCredential credential=MongoCredential.createCredential("groupd", "sma", 
				   "sma".toCharArray()); 
		MongoDatabase database = mongo.getDatabase("sma");
		MongoCollection<Document> collection = database.getCollection("Admin");*/
	
	    MongoClient mongoClient = new MongoClient();
	    DB database = mongoClient.getDB("sma");
	    DBCollection collection = database.getCollection("System");

		public NewSystem() {
			super();
		}
		
		protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
	
			System.out.println("System db");
			String sysid = request.getParameter("sys_id");
			String systype = request.getParameter("sys_type");
			String sysip = request.getParameter("sys_ip");
			
			System.out.println(sysid+" "+systype+" "+sysip);
			
		/*	DBObject query = new BasicDBObject("sysid", sysid);
			DBCursor found = collection.find(query);
			System.out.println(found);*/
			int found=0;
			
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put("sysid", sysid);
			BasicDBObject where=new BasicDBObject();
			where.put("$and",searchQuery);
			//FindIterable<Document> cursor = collection.find(searchQuery);
			DBCursor cursor = collection.find(searchQuery);
			Iterator curs = cursor.iterator(); 
			while (curs.hasNext()) {
				
				System.out.println(curs.next());
			    found=1;
			}
			
			
			

			if (found==0) {
			  //  collection.insertOne(new Document("title", title).append("url", url));
			
		
			System.out.println("Insertion complete");
			DBObject system = new BasicDBObject("sysid", sysid)
	                .append("systype",systype)
	                .append("sysip", sysip)
	                .append("empid","null")
	                .append("status", 0.0);
			collection.insert(system);	
			
			RequestDispatcher req = request.getRequestDispatcher("/home.jsp");
			request.getRequestDispatcher("home.jsp").forward(request, response);
			req.forward(request, response);
			}
			
			else
			{
				System.out.println("ID already exists");
				RequestDispatcher req = request.getRequestDispatcher("/NewSystem.jsp");
				request.getRequestDispatcher("NewSystem.jsp").forward(request, response);
				req.forward(request, response);
				
			}
		}
		
}
	
	  
