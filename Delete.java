import java.sql.*;
import java.util.*;
class Delete
{
public static int delete(int id)
{int status=0;
try{
                       
			Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
PreparedStatement ps=con.prepareStatement("Delete from ViewLibrarian where id=?");
ps.setInt(1,id);
status=ps.executeUpdate();
con.close();
}catch(Exception e){}
return status;
}
public static int add(int id,String name,String author,String publisher,int quantity)
{
int status=0;
try
{
Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
System.out.println("Test 1");
Calendar calender=Calendar.getInstance();
java.sql.Date added_date=new java.sql.Date(calender.getTime().getTime());
System.out.println("Test 2");
PreparedStatement ps=con.prepareStatement("Insert into ViewBooks (id,name,author,publisher,quantity,added_date) values (?,?,?,?,?,?)");
System.out.println("Test 3");
ps.setInt(1,id);
ps.setString(2,name);
ps.setString(3,author);
ps.setString(4,publisher);
ps.setInt(5,quantity);
ps.setDate(6,added_date);
System.out.println("Test 1");
status=ps.executeUpdate();
System.out.println("Test 1");
con.close();
}catch(Exception e){}
return status;
}

public static int issuebook(int id,int student_id,String student_name,int student_contact)
{
int status=0;
try
{
Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
Calendar calender=Calendar.getInstance();
java.sql.Date added_date=new java.sql.Date(calender.getTime().getTime());
status=updatebook(id);
if(status>0)
{
PreparedStatement ps=con.prepareStatement("Insert into IssueBook(id,student_id,student_name,student_contact) values (?,?,?,?)");
ps.setInt(1,id);
ps.setInt(2,student_id);
ps.setString(3,student_name);
ps.setInt(4,student_contact);
ps.setDate(5,added_date);
status=ps.executeUpdate();
}
con.close();
}catch(Exception e){}
return status;
}
public static int updatebook(int id){
	int status=0;
	int quantity=0,issued=0;
	try{
		
		Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
		PreparedStatement ps=con.prepareStatement("select quantity,issued from ViewBooks where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update ViewBooks set quantity=?,issued=? where id=?");
		ps2.setInt(1,quantity-1);
		ps2.setInt(2,issued+1);
		ps2.setInt(3,id);
		
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int returnbook(int id)
{
int status=0;
try{
                       
			Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
status=updatereturnbook(id);
if(status>0)
{
PreparedStatement ps=con.prepareStatement("Delete from IssueBook where id=?");
ps.setInt(1,id);
//ps.setInt(2,student_id);
status=ps.executeUpdate();
}
con.close();
}catch(Exception e){}
return status;
}
public static int updatereturnbook(int id){
	int status=0;
	int quantity=0,issued=0;
	try{
		
		Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
		PreparedStatement ps=con.prepareStatement("select quantity,issued from ViewBooks where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next()){
			quantity=rs.getInt("quantity");
			issued=rs.getInt("issued");
		}
		
		if(quantity>0){
		PreparedStatement ps2=con.prepareStatement("update ViewBooks set quantity=?,issued=? where id=?");
		ps2.setInt(1,quantity+1);
		ps2.setInt(2,issued-1);
		ps2.setInt(3,id);
		status=ps2.executeUpdate();
		}
		con.close();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int shift(int id,String name,String password,String email,String address,String city,int contact)
{
int status=0;
try
{
Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
PreparedStatement ps=con.prepareStatement("Insert into ViewLibrarian (id,name,password,email,address,city,contact) values (?,?,?,?,?,?,?)");
ps.setInt(1,id);
ps.setString(2,name);
ps.setString(3,password);
ps.setString(4,email);
ps.setString(5,address);
ps.setString(6,city);
ps.setInt(7,contact);
status=ps.executeUpdate();
con.close();
}catch(Exception e){
	e.printStackTrace();
}
return status;
}
public static boolean validate(String name,String password)
{
boolean status=false;
try
{
Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
PreparedStatement ps=con.prepareStatement("select * from ViewLibrarian where name=? and password=?");
ps.setString(1,name);
ps.setString(2,password);
ResultSet rs=ps.executeQuery();
status=rs.next();
con.close();
}catch(Exception e){}
return status;
}
}