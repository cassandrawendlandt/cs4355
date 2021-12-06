import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random; 
//import java.text.NumberFormat;
/** @author Cassandra Wendlandt 3551700
*/
public class ElGamalEncDec extends JFrame implements ActionListener {
    
    //variables 
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

    public ElGamalEncDec(){
        setSize(450,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("ElGamal Encryption/Decryption");
        Container contentPane = getContentPane ();
		contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        int p = 65537;
        int g = 3;
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






    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource() == yButton){
            double x = Double.parseDouble(xField.getText());
            
            double y = Math.pow(g,x)%p;
            yField.setText(y+"");
        }

        if (e.getSource()==c1Button){
            double r = Double.parseDouble(rField.getText());
            
        }

    }

    public static void main (String[] args){
        new ElGamalEncDec().setVisible(true);
    }
}
