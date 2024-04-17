package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {
    JRadioButton r1,r2,r3;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton submit,cancel;
    String formno;
    Signup3(String formno){
        this.formno=formno;
        setLayout(null);
        JLabel l1=new JLabel("Page 3:Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD,22));
        l1.setBounds(280,40,400,40);
        add(l1);

        JLabel acct=new JLabel("Account Type");
        acct.setFont(new Font("Raleway", Font.BOLD,22));
        acct.setBounds(100,140,200,40);
        add(acct);

        r1=new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD,16));
        r1.setBounds(100,180,150,20);
        r1.setBackground(Color.white);
        add(r1);

        r2=new JRadioButton("Current Account");
        r2.setFont(new Font("Raleway", Font.BOLD,16));
        r2.setBounds(450,180,150,20);
        r2.setBackground(Color.white);
        add(r2);

        r3=new JRadioButton("Fixed Deposit Account");
        r3.setFont(new Font("Raleway", Font.BOLD,16));
        r3.setBounds(100,220,200,20);
        r3.setBackground(Color.white);
        add(r3);

        ButtonGroup exo=new ButtonGroup();
        exo.add(r1);
        exo.add(r2);
        exo.add(r3);


        JLabel card=new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD,22));
        card.setBounds(100,280,200,30);
        add(card);

        JLabel no=new JLabel("XXXX-XXXX-XXXX-4184");
        no.setFont(new Font("Raleway", Font.BOLD,22));
        no.setBounds(300,280,300,30);
        add(no);

        JLabel no1=new JLabel("Your 16 Digit Card Number");
        no1.setFont(new Font("Raleway", Font.ITALIC,15));
        no1.setBounds(100,310,300,20);
        add(no1);

        JLabel pin=new JLabel("Pin:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,360,200,30);
        add(pin);

        JLabel pinn=new JLabel("XXXX");
        pinn.setFont(new Font("Raleway", Font.BOLD,22));
        pinn.setBounds(300,360,200,30);
        add(pinn);

        JLabel pik=new JLabel("Your 4 Digit Password");
        pik.setFont(new Font("Raleway",Font.ITALIC,15));
        pik.setBounds(100,390,300,20);
        add(pik);

        JLabel ser=new JLabel("Service required:");
        ser.setFont(new Font("Raleway", Font.BOLD,22));
        ser.setBounds(100,440,200,30);
        add(ser);

        c1=new JCheckBox("E-Banking");
        c1.setBounds(100,480,200,30);
        c1.setFont(new Font("Raleway",Font.BOLD,22));
        add(c1);

        c2=new JCheckBox("Debit Card");
        c2.setBounds(100,525,200,30);
        c2.setFont(new Font("Raleway",Font.BOLD,22));
        add(c2);


        c3=new JCheckBox("E-Statement");
        c3.setBounds(100,570,200,30);
        c3.setFont(new Font("Raleway",Font.BOLD,22));
        add(c3);

        c4=new JCheckBox("Mobile Banking");
        c4.setBounds(450,480,200,30);
        c4.setFont(new Font("Raleway",Font.BOLD,22));
        add(c4);

        c5=new JCheckBox("Email Alert");
        c5.setBounds(450,525,200,30);
        c5.setFont(new Font("Raleway",Font.BOLD,22));
        add(c5);

        c6=new JCheckBox("Sms Alert");
        c6.setBounds(450,570,200,30);
        c6.setFont(new Font("Raleway",Font.BOLD,22));
        add(c6);

        c7=new JCheckBox("I hereby declare that the above entered details are correct to the best of my knowledge");
        c7.setBounds(100,680,600,30);
        c7.setFont(new Font("Raleway",Font.ITALIC,12));
        add(c7);

        submit=new JButton("Submit");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setFont( new Font("Raleway",Font.BOLD,20));
        submit.setBounds(420,720,100,30);
        submit.addActionListener(this);
        add(submit);

        cancel=new JButton("Cancel");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setFont( new Font("Raleway",Font.BOLD,20));
        cancel.setBounds(530,720,100,30);
         cancel.addActionListener(this);
        add(cancel);

        getContentPane().setBackground(Color.white);

        setSize(850,820);
        setLocation(350,10);
        setVisible(true);



    }
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==submit)
        {
            String Acct = null;
            if (r1.isSelected()) {
                Acct = "Saving Account";
            } else if (r2.isSelected()) {
                Acct = "Current Account";
            } else {
                Acct = "Fixed Deposit account";
            }
            Random random = new Random();
            String Cardno = "" + Math.abs((random.nextLong() % 90000000L) + 5040936000000000L);
            String pinno = "" + Math.abs((random.nextLong() % 9000) + 1000L);
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "E-Banking";
            }
            if (c2.isSelected()) {
                facility = facility + "Debit Card";
            }
            if (c3.isSelected()) {
                facility = facility + "E-Statement";
            }
            if (c4.isSelected()) {
                facility = facility + "Mobile Banking";
            }
            if (c5.isSelected()) {
                facility = facility + "E-mail Alert";
            }

            if (c6.isSelected()) {
                facility = facility + "Sms Alert";
            }
            try {
                if (Acct.equals("")) {
                    JOptionPane.showMessageDialog(null, "Account type is Required");
                } else {
                    Conn conn = new Conn();
                    String query = "insert into signupthree values('" + formno + "', '" + Acct + "', '" + Cardno + "', '" + pinno + "', '" + facility + "')";
                    String query2= "insert into login values('"+formno+"', '"+Cardno+"', '"+pinno+"')";
                    conn.s.executeUpdate(query);
                    conn.s.executeUpdate(query2);


                    JOptionPane.showMessageDialog(null,"Card Number:"+Cardno+"\n Pin: "+pinno);
                }
                setVisible(false);
                new deposit(pinno).setVisible(false);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
        else if(cancel.isSelected()){
            setVisible(false);
            new Login().setVisible(true);
        }
    }

    public static void main(String[] args) {
        new Signup3("3355");
    }
}