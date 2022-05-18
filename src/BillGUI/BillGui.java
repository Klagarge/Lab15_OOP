package BillGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BillGui extends JFrame{
    String bill;
    JPanel jP;

    BillGui(String bill){
        this.bill = bill;

        //Create the frame with the layout
        this.setSize(400,600);
        this.setLocation(600,200);
        this.setVisible(true);
        FlowLayout fl = new FlowLayout();
		this.setLayout(fl);

        jP = new JPanel();

        JLabel jBill = new JLabel(bill);
        jP.add(jBill);
        
        this.add(jP);

        JButton buttonPrint = new JButton("Print");
        buttonPrint.addActionListener(new Impression1(jP)); 
        /*
            new ButtonListenerBill(this) {
            @Override
            public void actionPerformed(ActionEvent e){
                // TO-DO : print the pdf
            };
        });*/
        this.add(buttonPrint);


    }
}

/**
 * 
 */
class ButtonListenerBill implements ActionListener {
    JFrame Jf;

    ButtonListenerBill(JFrame Jf){
        this.Jf = Jf;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

    };

}
