<%@page import="org.bson.Document"%>
<%@page import="com.mongodb.client.MongoCollection"%>
<%@page import="com.mongodb.DBObject"%>
<%@page import="com.mongodb.BasicDBObject"%>
<%@page import="com.mongodb.DBCollection"%>
<%@page import="com.connection.dbconnect"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
%>
       
<script type="text/javascript">
function validateForm()
{
var uname=document.forms["logForm"]["emailid"].value;
var password=document.forms["logForm"]["pswd"].value;
if (uname==null || uname=="")
{
alert("Please provide email id");
return false;
}
if (password==null || password=="")
{
alert("Please provide Password");
return false;
}
}
</script>



<!DOCTYPE html>
<html>
    <head>
        <title>system management</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>
    <body>

        <div class="container">

            <div class="row">

                <div class="offset-md-3 col" style="margin-top: 5%;">
                    <h3 style="margin-left:20%; color:indigo"> Login</h3>
                    <br>
       
                    <form method="post" name="logForm" action="Home" onsubmit="return validateForm()">
                            <div class="form-group">
                                    <label for="Email">Email</label>
                                    <input type="email"  name="emailid" class="form-control" style="width: 50%;" placeholder="Enter email">
                                  </div>
                                  <div class="form-group">
                                    <label for="Password">Password</label>
                                    <input type="password" name="pswd" class="form-control" style="width: 50%;" placeholder="Password" width="30px">
                                  </div>
                                  <br>
                                  <button  type="submit" class="btn btn-primary" style="margin-left: 20%;" name="Login">Submit</button>
                    </form>

                </div>
            </div>
        </div>
    

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

<%-- 
out.println("hello");
if(request.getParameter("Login") != null) {
    session.setAttribute("status", "guest");
}
String login=request.getParameter("Login");
if(login!=null)
{
	dbconnect mydb=dbconnect.createInstance();
	DBCollection collection = mydb.getCollection("Admin");
	String user= request.getParameter("emailid");
	out.println("username= "+user);
	String password = request.getParameter("pswd"); 
	out.println("password= "+password);
	BasicDBObject query = new BasicDBObject();
	query.put("emailid",user);
	query.put("pswd",password);
	BasicDBObject where=new BasicDBObject();
	where.put("$and",query);
	DBObject doc=collection.findOne(query);
	if(doc!=null)
	{
		session.setAttribute("emailid",request.getParameter("emailid"));
		response.sendRedirect("home.jsp");
	}
	else
	{
		out.println("\nInvalid credentials");
	}
}
--%>
