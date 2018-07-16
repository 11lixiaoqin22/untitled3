package opp;
/*
 * BOderLayout,可以将组件放置到东方，西方，北方，南方，中间5个区域，实例
 * 程序如下
 */
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ui1 {
    public static boolean RIGHT_TO_LEFT=false;
    public static void addcomponentstopane(Container pane) {
        if(!(pane.getLayout()instanceof BorderLayout)) {
            pane.add(new JLabel("Container doesn't use BorderLayout!"));
            return;
        }
        if(RIGHT_TO_LEFT) {
            pane.setComponentOrientation(
                    java.awt.ComponentOrientation
                            .RIGHT_TO_LEFT);
        }
        JButton button=new JButton("北方");
        pane.add(button,BorderLayout.PAGE_START);
        // MAKE the center component big,since that's the
        //typical usage of BorderLayout.
        button=new JButton("中间");
        button.setPreferredSize(new Dimension(200,100));
        pane.add(button,BorderLayout.CENTER);

        button=new JButton("西方");
        pane.add(button,BorderLayout.LINE_START);

        button=new JButton("南方");
        pane.add(button,BorderLayout.PAGE_END);

        button=new JButton(" 东方");
        pane.add(button,BorderLayout.LINE_END);
    }

    private static void createAndShowGUI() {
        //make sure we have nice window decorations.
        JFrame.setDefaultLookAndFeelDecorated(true);
        //create and set up the window.
        JFrame frame= new JFrame("BorderLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //SET UP THE CONTENT PANE
        addcomponentstopane(frame.getContentPane());
        //use the content pane's default borderlayout.no need for
        //display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            @Override
            public void run() {
                createAndShowGUI();
            }
        });

    }

}

