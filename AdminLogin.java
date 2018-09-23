import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class AdminLogin implements ActionListener
{
JFrame jf1;
JButton jb3;
TextField jtf1;
JPasswordField jpf;
AdminLogin()
{
jf1=new JFrame();
jf1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jb3=new JButton("Login");
jb3.addActionListener(this);
jtf1=new TextField(20);
jtf1.setBounds(180,20,230,25);
JPanel panel=new JPanel();
//panel.setLayout(new FlowLayout(FlowLayout.LEFT,200,200));
jf1.setSize(400,400);
jf1.setVisible(true);
JLabel lbl = new JLabel("Admin Login Form");
lbl.setForeground(Color.blue);
lbl.setFont(new Font("Tahoma", Font.PLAIN, 18));
JLabel lbl1 = new JLabel("Enter Name:");
JLabel lbl2 = new JLabel("Enter Password:");
lbl1.setBounds(20,20,130,25);
lbl2.setBounds(20,180000,130,12500);
jpf=new JPasswordField(20);
jpf.addActionListener(this);
jpf.setBounds(180,180,230,125);
panel.add(lbl1);
panel.add(lbl2);
panel.add(lbl);
panel.add(jpf);
panel.add(jtf1);
panel.add(jb3);
lbl2.setLabelFor(jpf);
lbl1.setLabelFor(jtf1);
jf1.getContentPane().add(panel);
}
public void actionPerformed(ActionEvent e)
{
String name=jtf1.getText();
String password=new String(jpf.getPassword());

if((e.getSource()==jb3)&&(name.equals("admin"))&&(password.equals("admin123")))
{
AdminSection.main(new String[]{});
jf1.dispose();
}
else 
{
JOptionPane.showMessageDialog(jf1,"not appropriate info");
}
}
public static void main(String...s)
{
new AdminLogin();
}
}

		
