import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

//
/**
 * Final Project 1c: ElGamal Encryption/ Decryption 
 *  @author Cassandra Wendlandt 3551700
*/
public class ElGamalEncDec extends JFrame implements ActionListener {
    
    //creating the varibles needed for the program variables 
    private JLabel state1; 

    private JLabel xLabel;
    private JTextField xField;

    private JLabel ytitleLabel;
    private JLabel yLabel;
    private JButton yButton;
    private JTextField yField;

    private int p = 65537;
    private int g = 3;

    private JLabel mLabel;
    private JTextField mField;

    private JLabel enc;
    private JLabel rLabel;
    private JTextField rField;
    
    private JLabel c1TitleLabel ;
    private JButton c1Button;
    private JLabel c1JLabel;
    private JTextField c1TextField;

    private JLabel c2TitlLabel;
    private JButton c2Button;
    private JLabel c2Label;
    private JTextField c2Field;

    private JLabel dec; 
    private JLabel calculationJLabel;
    private JLabel answer;
    private JButton decButton;
    private JTextField decField;

    public ElGamalEncDec(){
        //setting the size and properites of the frame
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ElGamal Encryption/Decryption");

        //creating the content pane
        Container contentPane = getContentPane ();

        //setting the layouts
		contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        
        //initializing and placings the contents for the UI

        state1 = new JLabel("0. Given a large prime p=" + p + " a primary root g="+ g);
        gc.gridx=0;
        gc.gridy=0;
        contentPane.add (state1,gc);

        xLabel = new JLabel("1. Choose a private key x  x=");
        gc.gridx=0;
        gc.gridy=1;
        contentPane.add (xLabel,gc);

        xField=new JTextField(10);
        gc.gridx=1;
        gc.gridy=1;
        contentPane.add (xField,gc);

        ytitleLabel = new JLabel("2. Compute the corresponding public key y = g^x mod p");
        gc.gridx=0;
        gc.gridy=2;
        contentPane.add (ytitleLabel,gc);

        yButton= new JButton("Com");
        yButton.addActionListener(this);
        gc.gridx=1;
        gc.gridy=2;
        contentPane.add (yButton,gc);

        yLabel = new JLabel("y=");
        gc.gridx=0;
        gc.gridy=3;
        contentPane.add (yLabel,gc);

        yField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=3;
        contentPane.add (yField,gc);

        mLabel = new JLabel("3. Input a message m   m=");
        gc.gridx=0;
        gc.gridy=4;
        contentPane.add (mLabel,gc);

        mField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=4;
        contentPane.add (mField,gc);

        enc = new JLabel("4. Encrypt");
        gc.gridx=0;
        gc.gridy=5;
        contentPane.add (enc,gc);

        rLabel = new JLabel("4.1 Choose a random number r   r=");
        gc.gridx=0;
        gc.gridy=6;
        contentPane.add (rLabel,gc);

        rField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=6;
        contentPane.add (rField,gc);

        c1TitleLabel = new JLabel("4.2 Computer c1=g^r mod p");
        gc.gridx=0;
        gc.gridy=7;
        contentPane.add (c1TitleLabel,gc);

        c1Button = new JButton("Com");
        c1Button.addActionListener(this);
        gc.gridx=1;
        gc.gridy=7;
        contentPane.add (c1Button,gc);

        c1JLabel = new JLabel("c1=");
        gc.gridx=2;
        gc.gridy=7;
        contentPane.add (c1JLabel,gc);

        c1TextField = new JTextField(10);
        gc.gridx=3;
        gc.gridy=7;
        contentPane.add (c1TextField,gc);


        c2TitlLabel = new JLabel("4.3 Computer c2=m*y^r mod p");
        gc.gridx=0;
        gc.gridy=8;
        contentPane.add (c2TitlLabel,gc);

        c2Button = new JButton("Com");
        c2Button.addActionListener(this);
        gc.gridx=1;
        gc.gridy=8;
        contentPane.add (c2Button,gc);

        c2Label = new JLabel("c2=");
        gc.gridx=2;
        gc.gridy=8;
        contentPane.add (c2Label,gc);

        c2Field = new JTextField(10);
        gc.gridx=3;
        gc.gridy=8;
        contentPane.add (c2Field,gc);

        dec = new JLabel("5. Decrypt c= (c1,c2)"); 
        gc.gridx=0;
        gc.gridy=9;
        contentPane.add (dec,gc);
    
        calculationJLabel = new JLabel("m=c2/c1 ^x mod p");
        gc.gridx=0;
        gc.gridy=10;
        contentPane.add (calculationJLabel,gc);

        answer = new JLabel("m=");
        gc.gridx=2;
        gc.gridy=10;
        contentPane.add (answer,gc);

        decButton = new JButton("Dec");
        decButton.addActionListener(this);
        gc.gridx=1;
        gc.gridy=10;
        contentPane.add (decButton,gc);

        decField = new JTextField(10);
        gc.gridx=3;
        gc.gridy=10;
        contentPane.add (decField,gc);
    } //end of ElGamalEncDec()

    //action listener to complete the calcualtions when the buttons are clicked
    public void actionPerformed (ActionEvent e){
        //calculates y= g^x mod p
        if (e.getSource() == yButton){
            //gets the values from the x field 
            double x = Double.parseDouble(xField.getText());
            //calcualtes y
            double y = Math.pow(g,x)%p;
            //sets the vlaue to the y field 
            yField.setText(y+"");
        }//end of yButton if
        //calculates c1= g^r mod p
        if (e.getSource()==c1Button){
            //gets the r value from the r field
            double r = Double.parseDouble(rField.getText());
            //calculates the values
            double c = Math.pow(g,r)%p;
            //sets the values to the c1 field
            c1TextField.setText(c+"");  
        }//end of c1 button check
        //calculates the value of c2=m*y^r mod p
        if (e.getSource() == c2Button){
            //gets the m value from the m field 
            double m = Double.parseDouble(mField.getText());
            //gets the y value from the y field
            double y = Double.parseDouble(yField.getText());
            //gets the r values from the r field
            double r = Double.parseDouble(rField.getText());
            //calculates the value
            double c2 = (m*(Math.pow(y,r)))%p;
            //set the value to the c2 field 
            c2Field.setText(c2+"");
        }//end of if for the c2 button
        //calculates the decrypt value
        if (e.getSource() == decButton){
            //gets the c2 value from its field
            double c2 = Double.parseDouble(c2Field.getText());
            //gets the c1 value from its field
            double c1 = Double.parseDouble(c1TextField.getText());
            //gets the x value from its field 
            double x = Double.parseDouble(xField.getText());
            //calculates the m value
            double m = (c2/Math.pow(c1, x))%p;
            //sets the value to m the decField 
            decField.setText(m+"");
        }//end of 
    }//end of action performed

    public static void main (String[] args){
        new ElGamalEncDec().setVisible(true);
    }
}
