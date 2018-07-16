package ui2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Administrator on 2018/7/13.
 */
public class AccountFrame  extends JFrame{
    private  JPanel panelSearch = new JPanel();
    private  JPanel panelProcess = new JPanel();
    private  JTextField txtSearch = new JTextField();
    private  JButton btnSearch = new JButton("search");
    private  JLabel labView = new JLabel("看我哦");
    private  JPanel panelAdd =new JPanel();
    private  JLabel labAddAcount = new JLabel("账号");
    private  JTextField txtAddAcount = new JTextField();
    private  JLabel labAddPssword= new JLabel("密码");
    private  JTextField  txtAddPssword = new JTextField();
    private  JLabel labAddnumber= new JLabel("电话号码");
    private  JTextField  txtAddnumber = new JTextField();
    private  JLabel labAddmailbox= new JLabel("邮箱");
    private  JTextField  txtAddmailbox = new JTextField();
    private  JButton btnAdd = new JButton("Add");
    private  JButton btnDelete = new JButton("Delete");
    private  JButton btnModify= new JButton("Modify");
    public  AccountFrame() {
        // panelSearch.setBackground(Color.yellow);
        // panelProcess.setBackground((Color.BLUE));
        panelSearch.setLayout(new BorderLayout());
        panelSearch.add(txtSearch);
        panelSearch.add(btnSearch,BorderLayout.EAST);
        //初始化panelAdd面板组件
        panelAdd.setLayout(new GridLayout(4,2));
        panelAdd.add(labAddAcount);
        panelAdd.add(txtAddAcount);
        panelAdd.add(labAddPssword);
        panelAdd.add(txtAddPssword);
        panelAdd.add(labAddnumber);
        panelAdd.add(txtAddnumber);
        panelAdd.add(labAddmailbox);
        panelAdd.add(txtAddmailbox);

        //panelAdd.setVisible(false);
        //初始化底部面板
        panelProcess.add(btnAdd);
        panelProcess.add(btnDelete);
        panelProcess.add(btnModify);


        this.add(panelSearch,BorderLayout.NORTH);
        this.add(panelProcess,BorderLayout.SOUTH);
        //this.add(panelAdd);
        this.add(labView);
        //添加事件处理
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //移除labview组件

                //1. 如果文不能是 add， 那么就要出现 添加页面
                //2 否则，就回到主页
              
                String text = btnAdd.getText();

                if (text.equals("Add")){
                    AccountFrame.this.remove(labView);
                    AccountFrame.this.add(panelAdd);
                    btnDelete.setText("cancel");
                    btnModify.setVisible(false);
                    text = "save";
                } else {
                    text = "Add";
                    AccountFrame.this.remove(panelAdd);
                    labView.setText("保存成功！！！");
                    AccountFrame.this.add(labView);
                    btnDelete.setText("delete");
                    btnModify.setVisible(true);
                }
                btnAdd.setText(text);
                AccountFrame.this.setVisible(false);
                AccountFrame.this.setVisible(true);
            }
        });

        //设置窗体相关属性
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value =txtSearch.getText();
                labView.setText(value);

            }
        });
        this.setSize(800,600);
        this.setTitle("账号首页");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);


    }
    public  static  void  main (String ... args){
        new AccountFrame();
    }
}
