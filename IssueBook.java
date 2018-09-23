import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class IssueBook implements ActionListener
{
JFrame jf;
JButton jb,jb1;
TextField tf,tf1,tf2,tf3;
JLabel jl,jl1,jl2,jl3,jl4,jl5;
IssueBook()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jb=new JButton("ISSUE BOOK");
jb1=new JButton("Back");
jf.add(jb);
jf.add(jb1);
jb.addActionListener(this);
jb1.addActionListener(this);
jf.setLayout(new FlowLayout());
tf=new TextField(10);
tf1=new TextField(10);
tf2=new TextField(10);
tf3=new TextField(10);
jf.add(tf);
jf.add(tf1);
jf.add(tf2);
jf.add(tf3);
jl=new JLabel("id");
jl1=new JLabel("Student id");
jl2=new JLabel("Student Name");
jl3=new JLabel("Student Contact");
jf.add(jl);
jf.add(jl1);
jf.add(jl2);
jf.add(jl3);
jl4=new JLabel("ISSUE BOOK");
jl5=new JLabel("NOTE:PLEASE CHECK STUDENT ID BEFORE ISSUING BOOK");
jf.add(jl4);
jf.add(jl5);
try
{
                        Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
			}catch(Exception e){}

}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==jb)
{
String s1=tf.getText();
int id=Integer.parseInt(s1);
String s2=tf1.getText();
int student_id=Integer.parseInt(s2);
String student_name=tf2.getText();
String s4=tf3.getText();
int student_contact=Integer.parseInt(s4);
int i=Delete.issuebook(id,student_id,student_name,student_contact);
if(i>0)
{
JOptionPane.showMessageDialog(jf,"Book Issued Successfully");
}else
{
JOptionPane.showMessageDialog(jf,"Book Not Issued");
}
}
if(e.getSource()==jb1)
{
LibrarianSection.main(new String[]{});
}
}
public static void main(String...s)
{
new IssueBook();
}
}
