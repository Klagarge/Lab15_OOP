package BillGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 * 
 */
public class ManagerGui extends JFrame {
    GridLayout grid;
    JLabel Jname;
    JLabel Jlogo;
    ImageIcon logo;
    String buttonNameQuit = "Quit";
    String buttonNameBill = "Show bill";
    double ratio = 207.0/163.0;
    

    Vector<Row> prestations = new Vector<>();
    Vector<Integer> valuePrestations = new Vector<Integer>();
    

    /**
     * 
     */
    public ManagerGui(String name, String logoFilePath, String[] prestationsName, GarageManager garageManager){
        this.setSize(400,600);
        this.setLocation(600,200);
        this.setVisible(true);

        grid = new GridLayout(prestationsName.length + 2,2);
        this.setLayout(grid);

        //Create and add header
        //logo = new ImageIcon(logoFilePath);
        Jname = new JLabel(name);
        this.add(Jname);
        
        //logo = new ImageIcon(new ImageIcon(logoFilePath).getImage().getScaledInstance(207, 163, Image.SCALE_DEFAULT));
        //Jlogo = new JLabel(logo);
        Jlogo = resize(Jname, logoFilePath);
        this.add(Jlogo);


        //Create rows for prestations
        for(String s : prestationsName){
            prestations.add(new Row(s));
        }
        //add rows on the Jframe
        for(Row r : prestations){
            this.add(r.label);
            this.add(r.spinner);
        }

        //Create and add button 
        JButton buttonBill = new JButton(buttonNameBill);
        buttonBill.addActionListener(new ButtonListenerManager(valuePrestations, prestations, garageManager){
            /**
             * 
             */
            @Override
            public void actionPerformed(ActionEvent e){
                //Get the value of each spinner
                for (int i = 0; i < prestations.size(); i++) {
                    int value = (int)prestations.elementAt(i).spinner.getValue();
                    for (int j = 0; j < value; j++) {
                        valuePrestations.add(i);
                    }
                    System.out.println(value);
                }
                
                new BillGui(garageManager.generateHTMLBill(valuePrestations));
            };
        });

        JButton buttonQuit = new JButton(buttonNameQuit);
        buttonQuit.addActionListener(new ButtonListenerManager(this){
            /**
             * 
             */
            @Override
            public void actionPerformed(ActionEvent e){
                Jf.dispose();
            };
        });
        
        this.add(buttonBill);
        this.add(buttonQuit);

    }

    private JLabel resize(JLabel Jlogo, String logoFilePath){
        //TODO put in listener for resize when frame is resize.
        int width = (int)Jlogo.getSize().getWidth();
        int height = (int)Jlogo.getSize().getHeight();
        height = height > 0 ? height:65;
        System.out.println(width + "x"+ height);
        ImageIcon logo = new ImageIcon(new ImageIcon(logoFilePath).getImage().getScaledInstance((int) (height*ratio), height, Image.SCALE_DEFAULT));
        return new JLabel(logo);
    }
}


/**
 * 
 */
class Row {
    JLabel label;
    JSpinner spinner;

    Row(String title){
        label = new JLabel(title);
        spinner = new JSpinner();
    }
}

/**
 * 
 */
class ButtonListenerManager implements ActionListener {
    JFrame Jf;
    Vector<Integer> valuePrestations;
    Vector<Row> prestations;
    GarageManager garageManager;

    ButtonListenerManager(Vector<Integer> valuePrestations, Vector<Row> prestations, GarageManager garageManager){
        this.valuePrestations = valuePrestations;
        this.prestations = prestations;
        this.garageManager = garageManager;
    };

    ButtonListenerManager(JFrame Jf){
        this.Jf = Jf;
    }

    @Override
    public void actionPerformed(ActionEvent e){};

}




