package BillGUI;

import java.awt.*;
import java.awt.event.*;
import java.util.Vector;
import javax.swing.*;

/**
 * 
 */
public class ManagerGui extends JFrame{
    GridLayout grid;
    JLabel Jname;
    JLabel Jlogo;
    ImageIcon logo;

    Vector<Row> prestations = new Vector<>();
    

    /**
     *
     */
    public ManagerGui(String name, String logoFilePath, String[] prestationsName){
        this.setSize(400,600);
        this.setLocation(600,200);
        this.setVisible(true);

        grid = new GridLayout(prestationsName.length + 2,2);
        this.setLayout(grid);

        //Create and add header
        logo = new ImageIcon(logoFilePath);
        Jlogo = new JLabel(name);
        Jname = new JLabel(name);
        this.add(Jname);
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
        JButton ButtonBill = new JButton();
        JButton ButtonQuit = new JButton();
        this.add(ButtonBill);
        this.add(ButtonQuit);


        
    }

}

class Row {
    JLabel label;
    JSpinner spinner;

    Row(String title){
        label = new JLabel(title);
        spinner = new JSpinner();
    }

}


