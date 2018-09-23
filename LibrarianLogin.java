import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
class LibrarianLogin implements ActionListener
{
JFrame jf1;
JButton jb3;
TextField jtf1;
JPasswordField jpf;
LibrarianLogin()
{
jf1=new JFrame();
jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jb3=new JButton("Login");
jf1.add(jb3);
jtf1=new TextField(10);
jf1.add(jtf1);
jtf1.setBounds(40,40,40,40);
jf1.setLayout(new FlowLayout());
jf1.setSize(400,400);
jf1.setVisible(true);
JLabel lbl = new JLabel("Admin Login Form");
lbl.setForeground(Color.GRAY);
lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
JLabel lbl1 = new JLabel("Enter Name:");
JLabel lbl2 = new JLabel("Enter Password:");
jb3.addActionListener(this);
jpf=new JPasswordField(10);
jpf.addActionListener(this);
jf1.add(jpf);
jf1.add(lbl1);
jf1.add(lbl2);
try
{
                        Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql:///puskin","root","");
			}catch(Exception e){}
}
public void actionPerformed(ActionEvent e)
{
String name=jtf1.getText();
String password=new String(jpf.getPassword());
if(e.getSource()==jb3)
{
if(Delete.validate(name,password))
LibrarianSection.main(new String[]{});
jf1.dispose();
}
else 
{
JOptionPane.showMessageDialog(jf1,"not appropriate info");
}
}
public static void main(String...s)
{
new LibrarianLogin();
}
}

		
