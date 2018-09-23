import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class AddLibrarian implements ActionListener
{
JFrame jf;
TextField jtf1;
TextField jtf2;
TextField jtf3;
TextField jtf4;
TextField jtf5;
TextField jtf6,jtf7;
Button jb1,jb2;
JPasswordField jp;
AddLibrarian()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jb1=new Button("ADDLIBRARIAN");
jf.add(jb1);
jb1.addActionListener(this);
jb1.setBounds(20,100,40,40);
jb2=new Button("Back");
jb2.setBounds(20,180,40,40);
jf.add(jb2);
jb2.addActionListener(this);
jtf1=new TextField(10);
jtf2=new TextField(10);
jtf3=new TextField(10);
jtf4=new TextField(10);
jtf5=new TextField(10);
jtf6=new TextField(10);
jtf7=new TextField(10);
jf.setLayout(new FlowLayout(FlowLayout.LEFT,200,100));
JLabel jl=new JLabel("Name");
JLabel jl6=new JLabel("ID");
jf.add(jtf1);
jf.add(jtf2);
jf.add(jtf3);
jf.add(jtf4);
jf.add(jtf5);
jf.add(jtf6);
jf.add(jtf7);
JLabel jl1=new JLabel("Password");
JLabel jl2=new JLabel("Email id");
JLabel jl3=new JLabel("Address");
JLabel jl4=new JLabel("City");
JLabel jl5=new JLabel("Contact no.");
jf.add(jl6);
jf.add(jl);
jf.add(jl1);
jf.add(jl2);
jf.add(jl3);
jf.add(jl4);
jf.add(jl5);
try
{
                        Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost/puskin","root","");
			}catch(Exception e){}

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==jb1)
{
String s1=jtf1.getText();
int id=Integer.parseInt(s1);
String name=jtf2.getText();
String password=jtf3.getText();
String email=jtf4.getText();
String address=jtf5.getText();
String city=jtf6.getText();
String s7=jtf7.getText();
int contact=Integer.parseInt(s7);
int i=Delete.shift(id,name,password,email,address,city,contact);
if(i>0)
{
JOptionPane.showMessageDialog(jf,"Librarian added successfully");
LibrarianSection.main(new String[]{});
jf.dispose();
}
else
{
JOptionPane.showMessageDialog(jf,"librarian not added successfully");
}
}
if(e.getSource()==jb2)
{
AdminSection.main(new String[]{});
}
}
public static void main(String...s)
{
new AddLibrarian();
}
}
