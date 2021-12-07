import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
/**
 * Final Project 1c: Diffie Hellman Key Exchange 
 *  @author Cassandra Wendlandt 3551700
*/
public class DiffieHellman extends JFrame implements ActionListener {
    //creates the varibles that will be used throught the project
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
        //setting the size and properites of the frame
        setSize(750,275);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Diffie-Hellman Key Exchange");
        //creating the content pane
        Container contentPane = getContentPane ();
        //Setting the layout
		contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
         //initializing and placings the contents for the UI
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
    }//end of DiffieHallman()

    //action listener to complete the calcualtions when the buttons are clicked
    public void actionPerformed (ActionEvent e){
        //calcualtes X=g^x mod p
        if (e.getSource()==xButton){
            //gets the vlaoue forom the x field 
            int x = Integer.parseInt(xField.getText());
            //calcalates the value of big x
            double X = Math.pow(g,x)%p;
            //sets the values to the x field 
            xField2.setText(""+X);
        }//end of if for x button
        //calcualtes the value for Y=g^y mod p
        if (e.getSource() == yButton){
            //gets the vlaues form the y field
            int y = Integer.parseInt(yField.getText());
            //calcualtes the value of Y
            double Y = Math.pow(g,y)%p;
            //sets the value to the y field
            yField2.setText(""+Y);
        }//end of if for the y button 
        //calculates the value for K = Y^x mod p
        if (e.getSource()==kButton){
            //gets the values from the y field
            double Y = Double.parseDouble(yField2.getText());
            //gets the values from the x field 
            int x = Integer.parseInt(xField.getText());
            //calculates the k value
            double k = Math.pow(Y,x)%p;
            //adds the value to the k field 
            kField.setText(""+k);
        }//end of the if for the first k button
        //calculates the value for k= x^y mod p
        if (e.getSource()==kButton2){
            //gets the value from the x field
            double X = Double.parseDouble(xField2.getText());
            //gets the vlaue from the y field
            int y = Integer.parseInt(yField.getText());
            //calculates the k value
            double k = Math.pow(X,y)%p;
            //adds the value to the k field 
            kField2.setText(""+k);
        }//end of if for the second k button
    }//end of actionPerformed class 

    public static void main (String[] args){
        new DiffieHellman().setVisible(true);
    }

    
}
