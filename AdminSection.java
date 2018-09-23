import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
class AdminSection implements ActionListener
{
JFrame jf;
JButton jb;
JButton jb1;
JButton jb2;
JButton jb3;
AdminSection()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jb=new JButton("ADD LIBRARIAN");
jb1=new JButton("VIEW LIBRARIAN");
jb2=new JButton("DELETE LIBRARIAN");
jb3=new JButton("LOGOUT");
jf.add(jb);
jf.add(jb1);
jf.add(jb2);
jf.add(jb3);
jf.setSize(400,400);
jf.setVisible(true);
jb.addActionListener(this);
jb1.addActionListener(this);
jb2.addActionListener(this);
jb3.addActionListener(this);
jf.setLayout(new FlowLayout(FlowLayout.LEFT,200,200));
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==jb)
{
AddLibrarian.main(new String[]{});
jf.dispose();
}
if(e.getSource()==jb1)
{
ViewLibrarian.main(new String[]{});
jf.dispose();
}
if(e.getSource()==jb2)
{
DeleteLibrarian.main(new String[]{});
jf.dispose();
}
if(e.getSource()==jb3)
{
Login.main(new String[]{});
jf.dispose();
}
}
public static void main(String...s)
{
new AdminSection();
}
}
