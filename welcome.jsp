<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
  empty-cells:hide;
  padding:10px;

}
</style>
<meta charset="UTF-8">
<title>welcome</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body style="background-color:gray;">

        <div class="container">

            <div class="row">

                <div class="offset-md-4 col" style="margin-top: 5%;">
                <%-- String username = request.getParameter("emailid"); --%>
                                    <h1>welcome Admin </h1></div>
                                    <div  style="margin-top:0%; margin-left:0%;">
                                    <table  align="left" style="width:100%; margin-left:5px;">
	<tr>
		<th> Systemid</th>
		<th>SystemType</th>
		<th>ipaddress</th>
		<th>Allocation to (emp id)</th>
		<th>systemstatus</th>
		<th>allocate/deallocate</th>

</tr>
</table>
										
<br>
      </div>
    

        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>

