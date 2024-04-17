package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.sql.ResultSet;

public class Fastcash extends JFrame implements ActionListener {
    JButton exit,f100,f500,f1000,f2000,f10000,f5000;
    String pinnumber;
    Fastcash(String pinnumber)
    {
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);


        JLabel text =new JLabel("Enter Withdraw amount");
        text.setBounds(215,300,700,35);
        text.setForeground(Color.white);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);

        f100=new JButton("Rs 100");
        f100.setBounds(170,415,150,30);
        f100.addActionListener(this);
        image.add(f100);

        f500 =new JButton("Rs 500");
        f500.setBounds(350,415,150,30);
        f500.addActionListener(this);
        image.add(f500);

        f1000 =new JButton("Rs 1000");
        f1000.setBounds(170,450,150,30);
        f1000.addActionListener(this);
        image.add(f1000);

        f2000 =new JButton("Rs 2000");
        f2000.setBounds(350,450,150,30);
        f2000.addActionListener(this);
        image.add(f2000);

        f5000 =new JButton("Rs 5000");
        f5000.setBounds(170,485,150,30);
        f5000.addActionListener(this);
        image.add(f5000);

        f10000=new JButton("Rs 10000");
        f10000.setBounds(350,485,150,30);
        f10000.addActionListener(this);
        image.add(f10000);

        exit =new JButton("Back");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);


    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
                String amount=((JButton)ae.getSource()).getText().substring(3);
                Conn c= new Conn();
                try{
                    ResultSet rs=c.s.executeQuery("Select * from bank where pin = '"+pinnumber+"'");
                    int balance=0;
                    while(rs.next()){
                        if(rs.getString("type").equals("Deposit")){
                            balance+=Integer.parseInt(rs.getString("amount"));
                        }
                        else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if(ae.getSource()!= exit && balance<Integer.parseInt(amount)){
                        JOptionPane.showMessageDialog(null,"Insufficent Balance");
                        return;
                    }
                    Date date=new Date();
                    String query = "insert into bank values ('" + pinnumber + "', '" + date + "', 'Withdraw', '" + amount+ "')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "Rs" + amount + "Withdraw Succesfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }
                catch (Exception e)
                {
                    System.out.println(e);
                }
        }
    }
    public static void main(String[] args) {
        new Fastcash("");

    }
}
