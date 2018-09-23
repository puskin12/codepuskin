import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
class ReturnBook implements ActionListener
{
JFrame jf;
JButton jb,jb1;
JLabel jl,jl1,jl2,jl3;
TextField tf,tf1;
ReturnBook()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jf.setLayout(new FlowLayout());
jb=new JButton("Return Book");
jb1=new JButton("Back");
jb.addActionListener(this);
jb1.addActionListener(this);
jf.add(jb);
jf.add(jb1);
tf=new TextField(10);
tf1=new TextField(10);
jf.add(tf);
jf.add(tf1);
jl=new JLabel("id");
jl1=new JLabel("Student_id");
jf.add(jl);
jf.add(jl1);
jl2=new JLabel("Return Book");
jl3=new JLabel("Note:Check the book properly");
jf.add(jl2);
jf.add(jl3);
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
int i=Delete.returnbook(id);
if(i>0){
						JOptionPane.showMessageDialog(jf,"Return book successfully!");
					}else{
						JOptionPane.showMessageDialog(jf,"Unable to return given book!");
					}
}
if(e.getSource()==jb1)
{
LibrarianSection.main(new String[]{});
}
}
public static void main(String...s)
{
new ReturnBook();
}
}