package GUI;

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * main class for create the window
 */
public class GUI1 extends JFrame {
    public static void main(String[] args) {
        new GUI1();
    }
    GUI1(){
        //set up the window
        setTitle("Me");
        setSize(200,200);
        setLocation(600,200);
        this.getContentPane().setBackground(Color.GREEN);

        //set the layout for the window
        FlowLayout fl = new FlowLayout();
		this.setLayout(fl);

        //create and add component on the window
        JButton jb1 = new JButton("Foo");
        JButton jb2 = new JButton("bar");
        ButtonListener bl = new ButtonListener(this);
		jb1.addActionListener(bl);
        jb2.addActionListener(bl);
        this.add(jb1);
        this.add(jb2);


        this.setVisible(true);

    }
}

/**
 * set up the class for detect button
 */
class ButtonListener implements ActionListener{
	JFrame f1;
	
	ButtonListener(JFrame f1){
		this.f1 = f1;
	}
	
    //change color from background
	@Override
	public void actionPerformed(ActionEvent e){
        if(f1.getContentPane().getBackground()==Color.GREEN) {
            f1.getContentPane().setBackground(Color.BLUE);
        }
        else {
            f1.getContentPane().setBackground(Color.GREEN);
        }

        if (e.getActionCommand().contains("bar")) {
            f1.getContentPane().setBackground(Color.ORANGE);
        }
	}
}
