package GUI;
//TODO mettre commentaire

import javax.swing.*;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI1 extends JFrame {
    public static void main(String[] args) {
        new GUI1();
    }

    GUI1(){
        setTitle("Me");
        setSize(200,200);
        setLocation(600,200);

        FlowLayout fl = new FlowLayout();
		this.setLayout(fl);

        this.getContentPane().setBackground(Color.GREEN);

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
