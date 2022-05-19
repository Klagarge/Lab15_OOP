package GUI;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Container;

/**
 * main class for create the window
 */
public class GUI2 extends JFrame{
    int number;
    public static void main(String[] args) {
        new GUI2();
    }
    GUI2(){
        //set up the window with the layout
        setSize(200,200);
        setLocation(600,200);
        Container c = this.getContentPane();
        BoxLayout fl = new BoxLayout(c, BoxLayout.Y_AXIS);
		c.setLayout(fl);

        //create component on the window
        JSlider js1 = new JSlider(0, 100);
        js1.setValue(0);
        JProgressBar jp1 = new JProgressBar(0, 100);
        JLabel jl1 = new JLabel("waiting");

        //create the listener for the slider
        Listener l = new Listener(jp1, jl1, js1);
        js1.addChangeListener(l);

        //addd component on the window
        c.add(js1);
        c.add(jp1);
        c.add(jl1);

        this.setVisible(true);
    }
}

/**
 * class for detect slider mouvement
 */
class Listener implements ChangeListener {
	JProgressBar jp1;
    JLabel jl1;
    JSlider js1;
    int number = 0;
    /**
     * initialize the instance with parameters
     * @param jp1 progress bar who display the number of the slider
     * @param jl1 label progress bar who display the number of the slider
     * @param js1 slider who modify the label and the progress bar
     */
	Listener(JProgressBar jp1, JLabel jl1, JSlider js1){
		this.jp1 = jp1;
        this.jl1 = jl1;
        this.js1 = js1;
	}
	
    /**
     * modify the value of the label and the progress bar with the slider
     */
    @Override
    public void stateChanged(ChangeEvent e) {
        number = js1.getValue();
        jl1.setText("" + number);
        jp1.setValue(number);
        
    }
    
}

