<!doctype html>
<html>
<head><title>Student Registration</title></head>
<body>  
<form action="studentreg.htm" method="post">
<table> 
<tr>
<th>Student Name</th>
<td><input type="text" name="name" required></td>
</tr>
<tr>
<th>Student EmailID</th>
<td><input type="email" name="emailId" required></td>
</tr>
<tr>
<th>Password</th>
<td><input type="password" name="password" required></td>
</tr>
<tr>
<th>PhoneNumber</th>
<td><input type="number" name="phoneNum" required></td>
</tr>
<tr>
<th>Student College</th>
<td><input type="text" name="college" required></td>
</tr>
<tr>
<th>Student DOB</th>
<td><input type="date" name="dob" required></td>
</tr>
<tr>
<th>Student Address</th>
<td><textarea name="address" required></textarea></td>
</tr>
<tr>
<td colspan="2" ><input type="submit" value="Register"/></td>
</tr>
</table>
</form>
</body></html>