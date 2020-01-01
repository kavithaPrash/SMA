<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
        <script type="text/javascript">
        /*function promptmsg(){
            var empid=prompt("Enter employee ID ");
            document.write(empid);
            
                  }*/
</script>
    
<!DOCTYPE html>
<html> 

<body style="background-image: url('Images/newsys.jpg'); background-repeat: no-repeat; background-size: cover;"> 
	<center> 
	 
        <table border="1" cellpadding="3" style="color:white; margin-top:20px;">
            <tr>
                <th>System ID</th>
                <th>System Type</th>
                <th>System IP</th>
                <th>Employee ID</th>
                <th>Allocation status</th>
                <th>Allocate</th>
                <th>Deallocate</th>
            </tr>
            
          <tr>
          <td>${sysid}</td>
          <td>${systype}</td>
          <td>${sysip}</td>
          <td>${empid}</td>
          <td>${status}</td>
         <!--   <td><a href="welcome.jsp" onclick='promptmsg()'>Allocate</a>/<a href="Deallocation">Deallocate</a></td>-->
         <td><form method="post" action="Allocation"><button name="allocate">Allocate</button></form></td>
          <td><form method="post" action="Deallocation"><button name="deallocate">Deallocate</button></form></td>
          </tr>
          
       
										
<br>
      </div>
    
		
	</center> 
</body> 

</html> 
