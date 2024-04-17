package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;

public class Login extends JFrame implements  ActionListener {

    JButton login,signup,clear;//globally defining  this button for use them outside the constructor
    JTextField cardf;
    JPasswordField pinf;
    Login(){
        setLayout(null);
        ImageIcon ig= new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg")); //it is used load the image
        Image i2=ig.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT); //it is used to resize the image
        ImageIcon i3=new ImageIcon(i2); //converting image to icon again since label doesn't take images
        JLabel label=new JLabel(i3);
        label.setBounds(70,10,100,100);
        add(label);

        JLabel text=new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD,38));
        text.setBounds(200,40,400,40);
        add(text);

        JLabel cardno=new JLabel("Card no");
        cardno.setFont(new Font("Raleway",Font.BOLD,28));
        cardno.setBounds(120,150,150,30);
        add(cardno);

        cardf=new JTextField();
        cardf.setBounds(300,150,250,30);
        add(cardf);

        JLabel pin=new JLabel("Pin");
        pin.setFont(new Font("Raleway",Font.BOLD,28));
        pin.setBounds(120,220,250,30);
        add(pin);

        pinf=new JPasswordField();
        pinf.setBounds(300,220,250,30);
        add(pinf);

        getContentPane().setBackground(Color.white);
        setTitle("AUTOMATED TELLER MACHINE");
        setSize(800,480); //it is used to set the size of the window
        setVisible(true); //default the visibility is set to false

        login=new JButton("Sign In");
        login.setBounds(300,280,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);


        clear=new JButton("Clear");
        clear.setBounds(450,280,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.white);
        clear.addActionListener(this);
        add(clear);

        signup=new JButton("Sign Up");
        signup.setBounds(300,330,250,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.white);
        signup.addActionListener(this);
        add(signup);

    }
    public void actionPerformed(ActionEvent ae)// since actionlistner class is abstract class so we have to override its function
    {
        if(ae.getSource()==clear)
        {
            cardf.setText("");
            pinf.setText("");
        }
        else if (ae.getSource()==signup) {
                setVisible(false);
                new signup1().setVisible(true);
        }
        else{
            Conn conn =new Conn();
            String card=cardf.getText();
            String pin=pinf.getText();
            String query="Select * from login where CardNo ='"+card+"' and pinno = '"+pin+"'";
            try {
                ResultSet rs=conn.s.executeQuery(query);
                if(rs.next())
                {
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
                else{
                    JOptionPane.showMessageDialog(null,"Incorrect Pin or password");
                }
            }
            catch (Exception e){
                System.out.println(e);
            }
        }

    }
        public static void main(String[] args) {
        new Login();
    }
    }
