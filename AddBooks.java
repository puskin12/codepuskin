import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class AddBooks implements ActionListener
{
JFrame jf;
JButton jb,jb1;
TextField tf,tf1,tf2,tf3,tf4;
JLabel jl,jl1,jl2,jl3,jl4;
AddBooks()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jb=new JButton("ADD BOOKS");
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
tf4=new TextField(10);
jf.add(tf);
jf.add(tf1);
jf.add(tf2);
jf.add(tf3);
jf.add(tf4);
jl=new JLabel("ID");
jl1=new JLabel("Name");
jl2=new JLabel("Author");
jl3=new JLabel("Publisher");
jl4=new JLabel("quantity");
jf.add(jl);
jf.add(jl1);
jf.add(jl2);
jf.add(jl3);
jf.add(jl4);
jl1.setLabelFor(tf);
jl2.setLabelFor(tf1);
jl3.setLabelFor(tf2);
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
if(s1==null||s1.trim().equals(""))
{
JOptionPane.showMessageDialog(jf,"Id can't be blank");
}
String name=tf1.getText();
if(name==null||name.trim().equals(""))
{
JOptionPane.showMessageDialog(jf,"Name can't be blank");
}
String author=tf2.getText();
if(author==null||author.trim().equals(""))
{
JOptionPane.showMessageDialog(jf,"Author can't be blank");
}
String publisher=tf3.getText();
if(publisher==null||publisher.trim().equals(""))
{
JOptionPane.showMessageDialog(jf,"Publisher can't be blank");
}
String s2=tf4.getText();
int quantity=Integer.parseInt(s2);
if(s2==null||s2.trim().equals(""))
{
JOptionPane.showMessageDialog(jf,"Quantity can't be blank");
}
int i=Delete.add(id,name,author,publisher,quantity);
if(i>0){
				JOptionPane.showMessageDialog(jf,"Books added successfully!");
				LibrarianSection.main(new String[]{});
				jf.dispose();
				
			}else{
				JOptionPane.showMessageDialog(jf,"Sorry unable to save!");
			}
}							
if(e.getSource()==jb1)
{
LibrarianSection.main(new String[]{});
}
}
public static void main(String...s)
{
new AddBooks();
}
}