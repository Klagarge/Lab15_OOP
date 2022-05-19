package BillGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.print.*;
import java.awt.image.BufferedImage;

/**
 * generate the bill in a window
 */
public class BillGui extends JFrame{
    String bill;
    JPanel jP;

    /**
     * initialize the bill in a window
     * @param bill string who contains the bill
     */
    BillGui(String bill){
        this.bill = bill;

        //Create the frame with the layout
        this.setSize(400,600);
        this.setLocation(600,200);
        this.setVisible(true);
        FlowLayout fl = new FlowLayout();
		this.setLayout(fl);

        //Create the label who contain the label with the bill
        jP = new JPanel();
        JLabel jBill = new JLabel(bill);
        jP.add(jBill);
        this.add(jP);

        //Create the button for print the bill
        JButton buttonPrint = new JButton("Print");
        buttonPrint.addActionListener(new ButtonListenerBill() {
        
            @Override
            public void actionPerformed(ActionEvent e){

                // Create a new printer Job
                PrinterJob pj = PrinterJob.getPrinterJob();
                pj.setJobName("Bill");

                // Create a printable element from a JPanel. This method is just a copy, it resize but isn't perfect.
                // It's just a first test. Should be improved
                // TODO : improve this method
                Printable printable = new Printable() {    
                    public int print(Graphics pg, PageFormat pf, int pageNum){
                        if (pageNum > 0) return Printable.NO_SUCH_PAGE;

                        Dimension size = jP.getSize();
                        BufferedImage bufferedImage = new BufferedImage(size.width, size.height, BufferedImage.TYPE_INT_RGB);
    
                        jP.print(bufferedImage.getGraphics());
    
                        Graphics2D g2 = (Graphics2D) pg;
                        g2.translate(pf.getImageableX(), pf.getImageableY());
                        g2.drawImage(bufferedImage, 0, 0, (int) pf.getWidth(), (int) pf.getHeight(), null);

                        return Printable.PAGE_EXISTS;
                    }
                };

                // Create and set a A4 paper
                Paper paper = new Paper();
                paper.setImageableArea(0, 0,2480,3508);
                paper.setSize(2480,3508);
                PageFormat format = new PageFormat();
                format.setPaper(paper);
                format.setOrientation(PageFormat.PORTRAIT);

                // Set all settings about the printing function
                pj.setPrintable (printable, format);

                // Launch the printer dialog for printing.
                if (pj.printDialog() == false) return;
                try {
                    pj.print();
                } catch (PrinterException ex) {}
            }
        });


        this.add(buttonPrint);

        
    }

}

/**
 * listener to detect the button to print the bill
 */
class ButtonListenerBill implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e){};
}







