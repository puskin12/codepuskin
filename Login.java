import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame.*;
class Login implements ActionListener
{
JFrame jf;
JButton jb1;
JButton jb2;
Login()
{
jf=new JFrame("LIBRARY MANAGMENT SYSTEM");
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jb1=new JButton("Admin Login");
jb2=new JButton("Librarian Login");
jb1.addActionListener(this);
jb2.addActionListener(this);
jf.add(jb1);
jf.add(jb2);
jf.setLayout(new FlowLayout());
jf.setSize(400,400);
jf.setVisible(true);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==jb1)
{
AdminLogin.main(new String[]{});
jf.dispose();
} 
if(e.getSource()==jb2)
{
LibrarianLogin.main(new String[]{});
jf.dispose();
}
}
public static void main(String...s)
{
new Login();
}
}