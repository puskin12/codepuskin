import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.KeyEvent;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class MainClass {

  public static void main(String[] a) {
    JFrame frame = new JFrame("LabelFor Sample");
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    JLabel label = new JLabel("Username");
    JTextField textField = new JTextField();
    label.setDisplayedMnemonic(KeyEvent.VK_U);
    label.setLabelFor(textField);
    Container box = Box.createHorizontalBox();
    box.add(label);
    box.add(textField);
    frame.add(box, BorderLayout.NORTH);
    frame.add(new JButton("Submit"), BorderLayout.SOUTH);
    frame.setSize(300, 200);
    frame.setVisible(true);
  }
}

           