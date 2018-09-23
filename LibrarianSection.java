import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.sql.*;
import java.util.*;
class LibrarianSection implements ActionListener
{
JFrame jf;
JButton jb,jb1,jb2,jb3,jb4,jb5;
LibrarianSection()
{
jf=new JFrame();
jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
jf.setSize(400,400);
jf.setVisible(true);
jf.setLayout(new FlowLayout());
jb=new JButton("ADD BOOKS");
jb1=new JButton("VIEW BOOKS");
jb2=new JButton("ISSUE BOOK");
jb3=new JButton("VIEW ISSUE BOOKS");
jb4=new JButton("RETURN BOOK");
jb5=new JButton("LOGOUT");
jb.addActionListener(this);
jb1.addActionListener(this);
jb2.addActionListener(this);
jb3.addActionListener(this);
jb4.addActionListener(this);
jb5.addActionListener(this);
JLabel jp=new JLabel("LIBRARIAN SECTION");
jf.add(jb);
jf.add(jb1);
jf.add(jb2);
jf.add(jb3);
jf.add(jb4);
jf.add(jb5);
jf.add(jp);
}
public void actionPerformed(ActionEvent e)
{
if(e.getSource()==jb)
{
AddBooks.main(new String[]{});
}
if(e.getSource()==jb1)
{
ViewBooks.main(new String[]{});
}
if(e.getSource()==jb2)
{
IssueBook.main(new String[]{});
}
if(e.getSource()==jb3)
{
ViewIssueBook.main(new String[]{});
}
if(e.getSource()==jb4)
{
ReturnBook.main(new String[]{});
}
if(e.getSource()==jb5)
{
Login.main(new String[]{});
}
}
public static void main(String...s)
{
new LibrarianSection();
}
}


 