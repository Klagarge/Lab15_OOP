package BillGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * 
 */
public class ManagerGui extends JFrame{
    GridLayout grid;
    JLabel Jname;
    JLabel Jlogo;
    

    public ManagerGui(int n,int m, String name, String logoFilePath){
        grid = new GridLayout(n,m);
        Jname = new JLabel(name);
    }

    

}
