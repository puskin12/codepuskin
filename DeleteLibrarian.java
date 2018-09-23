import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class DeleteLibrarian implements ActionListener
{
JFrame jf;
JButton jb,jb1;
TextField tf;
DeleteLibrarian()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jb=new JButton("Delete");
jb1=new JButton("Back");
jb.addActionListener(this);
jb1.addActionListener(this);
jf.add(jb);
jf.add(jb1);
tf=new TextField();
jf.add(tf);
jf.setLayout(new FlowLayout(FlowLayout.LEFT,200,100));
tf.setBounds(20,40,100,40);
JLabel jl=new JLabel("Enter id");
jf.add(jl);
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
String sid=tf.getText();
				if(sid==null||sid.trim().equals("")){
					JOptionPane.showMessageDialog(jf,"Id can't be blank");
				}else{
					int id=Integer.parseInt(sid);
					int i=Delete.delete(id);
					if(i>0){
						JOptionPane.showMessageDialog(jf,"Record deleted successfully!");
					}else{
						JOptionPane.showMessageDialog(jf,"Unable to delete given id!");
					}
				}
			}
if(e.getSource()==jb1)
{
AdminSection.main(new String[]{});
}
}
public static void main(String...s)
{
new DeleteLibrarian();
}
}
			