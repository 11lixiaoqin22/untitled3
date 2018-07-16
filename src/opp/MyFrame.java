package opp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/7/12.
 */
public class MyFrame extends JFrame{
    public MyFrame() {
        this.setSize(400, 750);
        GridLayout gridLayout = new GridLayout(5, 2);
        this.setLayout(gridLayout);
        JLabel xs = new JLabel("姓名");
        JTextField field1 = new JTextField(30);
        JLabel xs2 = new JLabel("性别");
        JTextField field2 = new JTextField(30);
        JLabel xs3 = new JLabel("学号");
        JTextField field3 = new JTextField(30);
        JLabel xs4 = new JLabel("年龄");
        JTextField field4 = new JTextField(30);

        JButton button = new JButton("查询");
        button.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JOptionPane.showConfirmDialog(null, ""+field1.getText() + ","
                                + field2.getText() + "," + field3.getText()+","+field4.getText());
                    }
                }
        );
        this.add(xs);
        this.add(field1);
        this.add(xs2);
        this.add(field2);
        this.add(xs3);
        this.add(field3);
        this.add(xs4);
        this.add(field4);

        this.add(button);
        this.setVisible(true);
        this.setDefaultCloseOperation(MyFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[]){
        new MyFrame();
    }
}
