import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class DiffieHellman extends JFrame implements ActionListener {

    private JLabel state0;

    private int p = 65537;
    private int g = 3;

    private JLabel xJLabel; 
    private JLabel xLabel; 
    private JTextField xField; 

    private JLabel xJLabel2; 
    private JLabel xLabel2; 
    private JButton xButton; 
    private JTextField xField2;

    private JLabel yJLabel; 
    private JLabel yLabel; 
    private JTextField yField;

    private JLabel yJLabel2; 
    private JLabel yLabel2; 
    private JButton yButton; 
    private JTextField yField2;

    private JLabel kJLabel; 
    private JLabel kxLabel;
    private JTextField kField;
    private JButton kButton; 

    private JLabel kxLabel2;
    private JTextField kField2;
    private JButton kButton2; 


    public DiffieHellman(){
        setSize(800,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Diffie-Hellman Key Exchange");
        Container contentPane = getContentPane ();
		contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        int p = 65537;
        int g = 3;
        state0 = new JLabel("0. Given a large prime p=" + p + " a primary root g="+ g);
        gc.gridx=0;
        gc.gridy=0;
        contentPane.add (state0,gc);

        xJLabel = new JLabel("1. Choose a random number x"); 
        gc.gridx=0;
        gc.gridy=1;
        contentPane.add (xJLabel,gc);

        xLabel = new JLabel("x="); 
        gc.gridx=0;
        gc.gridy=2;
        contentPane.add (xLabel,gc);

        xField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=2;
        contentPane.add (xField,gc);

        xJLabel2 = new JLabel("2. Compute X=g^x mod p");
        gc.gridx=0;
        gc.gridy=3;
        contentPane.add (xJLabel2,gc);

        xButton = new JButton("Com");
        gc.gridx=1;
        gc.gridy=3;
        contentPane.add (xButton,gc); 
        xButton.addActionListener(this);

        xLabel2= new JLabel("X=");
        gc.gridx=0;
        gc.gridy=4;
        contentPane.add (xLabel2,gc);

        xField2 = new JTextField(10);
        gc.gridx=1;
        gc.gridy=4;
        contentPane.add (xField2,gc);

        yLabel = new JLabel("3. Choose a random number y"); 
        gc.gridx=0;
        gc.gridy=5;
        contentPane.add (yLabel,gc);

        yJLabel = new JLabel("y="); 
        gc.gridx=0;
        gc.gridy=6;
        contentPane.add (yJLabel,gc);

        yField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=6;
        contentPane.add (yField,gc);


        yJLabel2 = new JLabel("4. Compute Y=g^y mod p");
        gc.gridx=0;
        gc.gridy=7;
        contentPane.add (yJLabel2,gc);

        yButton = new JButton("Com");
        gc.gridx=1;
        gc.gridy=7;
        contentPane.add (yButton,gc); 
        yButton.addActionListener(this);

        yLabel2= new JLabel("Y=");
        gc.gridx=0;
        gc.gridy=8;
        contentPane.add (yLabel2,gc);

        yField2 = new JTextField(10);
        gc.gridx=1;
        gc.gridy=8;
        contentPane.add (yField2,gc);

        kJLabel=new JLabel("5. Calculate the session key g^xy mod p"); 
        gc.gridx=0;
        gc.gridy=9;
        contentPane.add (kJLabel,gc);

        kxLabel = new JLabel("K=Y^x mod p =");
        gc.gridx=0;
        gc.gridy=10;
        contentPane.add (kxLabel,gc);

        kField = new JTextField(10);
        gc.gridx=1;
        gc.gridy=10;
        contentPane.add (kField,gc);
        
        kButton = new JButton("Cal"); 
        gc.gridx=2;
        gc.gridy=10;
        contentPane.add (kButton,gc);
        kButton.addActionListener(this);

        kxLabel2 = new JLabel("K=X^y mod p =");
        gc.gridx=3;
        gc.gridy=10;
        contentPane.add (kxLabel2,gc);

        kField2 = new JTextField(10);
        gc.gridx=4;
        gc.gridy=10;
        contentPane.add (kField2,gc);

        kButton2 = new JButton("Cal");
        gc.gridx=5;
        gc.gridy=10;
        contentPane.add (kButton2,gc);
        kButton2.addActionListener(this);

        
    }

    public void actionPerformed (ActionEvent e){
        if (e.getSource()==xButton){
            int x = Integer.parseInt(xField.getText());
            double X = Math.pow(g,x)%p;
            xField2.setText(""+X);
        }

        if (e.getSource() == yButton){
            int y = Integer.parseInt(yField.getText());
            double Y = Math.pow(g,y)%p;
            yField2.setText(""+Y);
        }

        if (e.getSource()==kButton){
            double Y = Double.parseDouble(yField2.getText());
            int x = Integer.parseInt(xField.getText());
            double k = Math.pow(Y,x)%p;
            kField.setText(""+k);
        }

        if (e.getSource()==kButton2){
            double X = Double.parseDouble(xField2.getText());
            int y = Integer.parseInt(yField.getText());
            double k = Math.pow(X,y)%p;
            kField2.setText(""+k);
        }

    }

    public static void main (String[] args){
        new DiffieHellman().setVisible(true);
    }

    
}
