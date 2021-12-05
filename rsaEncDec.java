import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Random; 
//import java.text.NumberFormat;
/** @author Cassandra Wendlandt 3551700
*/
public class rsaEncDec extends JFrame implements ActionListener {

    private JLabel primeNumberLabel;
    private JLabel p;
    private JLabel q;
    private JButton primeNumberGen; 
    private JTextField ptTextField;
    private JTextField qTextField;

    private JLabel nLabel; 
    private JButton nComButton;
    private JLabel nJLabel; 
    private JTextField nTextField;

    private JLabel eLabel; 
    private JTextField eArea;

    private JLabel dLabel; 
    private JLabel dLabel2; 
    private JButton dCalButton;
    private JTextField dField;

    private JLabel mLabel; 
    private JTextField mField;

    private JLabel cJLabel;
    private JLabel cJLabel2;
    private JTextField cField;
    private JButton encButton; 


    private JLabel dJLabel;
    private JLabel dJLabel2;
    private JButton decButton; 
    private JLabel status;
	
		
	public rsaEncDec () {
			
		setSize (600,400);
        setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        setTitle("RSA Encryption/Decryption");
        Container contentPane = getContentPane ();
		contentPane.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();

		primeNumberLabel = new JLabel("1. Generate primes p and q" );
        JLabel primeNumberLabel2 = new JLabel ("1000<p,q<5000");
        status = new JLabel("Nothing is clicked"); 

        p = new JLabel ("p=");
        ptTextField = new JTextField (10);
        q = new JLabel ("q=");
        qTextField = new JTextField (10);
        primeNumberGen = new JButton("Gen");
        primeNumberGen.addActionListener(this);
         gc.gridx=0;
         gc.gridy=0;
         contentPane.add (primeNumberLabel,gc);
         gc.gridx=1;
         gc.gridy=0;
         contentPane.add(primeNumberGen,gc);
         gc.gridx=2;
         gc.gridy=0;
         contentPane.add (primeNumberLabel2,gc);
         gc.gridx=3;
         gc.gridy=0;
         contentPane.add(status,gc);
         gc.gridx=0;
         gc.gridy=1;
         contentPane.add(p,gc);
         gc.gridx=1;
         gc.gridy=1;
         contentPane.add(ptTextField,gc);
         gc.gridx=0;
         gc.gridy=2;
         //gc.fill = GridBagConstraints.NONE;
         contentPane.add (q,gc);
         gc.gridx=1;
         gc.gridy=2;
         contentPane.add(qTextField,gc);

        nLabel = new JLabel("2. Compute n = pq" );
        nJLabel = new JLabel ("n=");
        nTextField = new JTextField (10);
        
        nComButton = new JButton("Com");
        nComButton.addActionListener(this);

        gc.gridx=0;
        gc.gridy=3;
        contentPane.add(nLabel,gc);
        gc.gridx=1;
        gc.gridy=3;
        contentPane.add(nComButton,gc);
        gc.gridx=0;
        gc.gridy=4;
        contentPane.add(nJLabel,gc);
        gc.gridx=1;
        gc.gridy=4;
        contentPane.add(nTextField,gc);
        
        eLabel = new JLabel("3. Set a public key e.    e=");
        eArea = new JTextField();
        gc.gridx=0;
        gc.gridy=5;
        contentPane.add(eLabel,gc);
        gc.gridx=1;
        gc.gridy=5;
        gc.fill = GridBagConstraints.HORIZONTAL;
        contentPane.add(eArea,gc);


        dLabel = new JLabel("4.Calculate the private key d");
        gc.gridx=0;
        gc.gridy=6;
        gc.fill=GridBagConstraints.NONE;
        contentPane.add(dLabel,gc);
       
        dLabel2 = new JLabel("d=");
        gc.gridx=0;
        gc.gridy=7;
        contentPane.add(dLabel2,gc);

        dField=new JTextField(10);

        gc.gridx=1;
        gc.gridy=7;
        contentPane.add(dField,gc);
        
        dCalButton = new JButton("Cal");
        dCalButton.addActionListener(this);
        gc.gridx=1;
        gc.gridy=6;
        contentPane.add(dCalButton,gc);


        mLabel = new JLabel("5. Input message m         m=");
        mField = new JTextField(10);
        gc.gridx=0;
        gc.gridy=8;
        contentPane.add(mLabel,gc);
        gc.gridx=1;
        gc.gridy=8;
        contentPane.add(mField,gc);

        cJLabel = new JLabel("6. Encrypt c=m^e mod n");
        cField = new JTextField(20);
        cJLabel2 = new JLabel("c=");
        encButton = new JButton("Enc");
        encButton.addActionListener(this);
        gc.gridx=0;
        gc.gridy=9;
        contentPane.add(cJLabel,gc);
        gc.gridx=1;
        gc.gridy=9;
        contentPane.add(encButton,gc);
        gc.gridx=2;
        gc.gridy=9;
        contentPane.add(cJLabel2,gc);
        gc.gridx=3;
        gc.gridy=9;
        contentPane.add(cField,gc);

        dJLabel = new JLabel("7. Decrypt m=c^d mod n");
        dField = new JTextField(20);
        dJLabel2 = new JLabel("m=");
        decButton = new JButton("Dec");
        decButton.addActionListener(this);
        gc.gridx=0;
        gc.gridy=10;
        contentPane.add(dJLabel,gc);
        gc.gridx=1;
        gc.gridy=10;
        contentPane.add(decButton,gc);
        gc.gridx=2;
        gc.gridy=10;
        contentPane.add(dJLabel2,gc);
        gc.gridx=3;
        gc.gridy=10;
        contentPane.add(dField,gc);
        



			
	}

	public void actionPerformed (ActionEvent e){
	/**
		NumberFormat formatter= NumberFormat.getNumberInstance ();
		formatter.setMaximumFractionDigits(2);
		formatter.setMinimumFractionDigits (1);
		
		double credit = Double.parseDouble(creditHours.getText());
		String letter = letterGrade.getText();
		double gradePoints=0.0;*/

		
		if (e.getSource() == primeNumberGen){
            status.setText ("Invalid grade - GPA not changed.");
            int num = 0;
            Random rand = new Random(); // generate a random number
            num = rand.nextInt(5000) +1000;

            while (!isPrime(num)) {          
                num = rand.nextInt(5000) +1000;
            }
            ptTextField.setText(num + "");
            num = rand.nextInt(5000) +1000;

            while (!isPrime(num)) {          
                num = rand.nextInt(5000) +1000;
            }

            qTextField.setText(num + "");
        }
        if (e.getSource()==nComButton){
            if (qTextField.getText().length()==0 || ptTextField.getText().length()==0){
                status.setText("Need to Generate p and q value");
            }
            else{
                double p  = Double.parseDouble(ptTextField.getText());
                double q  = Double.parseDouble(qTextField.getText());
                double n = p*q;
                nTextField.setText(n+"");
            }
            
        }
        if (e.getSource()==dCalButton){
            status.setText("cal clicked");
        }
        if (e.getSource() == encButton){
            status.setText("enc clicked");
        }
        if (e.getSource() == decButton){
            status.setText("dec clicked");
        }
       
		
		
		
		
		
	}

    public static boolean isPrime(int num){
        for(int i=2; i<num; i++) {
         if(num%i == 0)
         {
            return false;
         }
      }
      
      return true;
   }
    
	public static void main (String[] args) {
		new rsaEncDec ().setVisible (true);
	}

}







