package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pinchange extends JFrame implements ActionListener{
    String pinnumber;
    JLabel pin,rpin;
    JPasswordField  pint,rpint;
    JButton exit,change;
     Pinchange(String pinnumber){
        this.pinnumber=pinnumber;
         setLayout(null);

         ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
         Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
         ImageIcon i3=new ImageIcon(i2);
         JLabel image = new JLabel(i3);
         image.setBounds(0,0,900,900);
         add(image);

         JLabel text =new JLabel("Are you sure want to change your pin");
         text.setBounds(215,300,700,35);
         text.setForeground(Color.white);
         text.setFont(new Font("System",Font.BOLD,16));
         image.add(text);

         pin=new JLabel("New Pin");
         pin.setForeground(Color.white);
         pin.setFont(new Font("System",Font.BOLD,16));
         pin.setBounds(165,350,150,25);
         image.add(pin);

         pint=new JPasswordField();
         pint.setFont(new Font("Raleway",Font.BOLD,25));
         pint.setBounds(320,350,180,25);
         image.add(pint);

         rpin=new JLabel("Rewrite new Pin");
         rpin.setForeground(Color.white);
         rpin.setFont(new Font("System",Font.BOLD,16));
         rpin.setBounds(165,380,150,25);
         image.add(rpin);

         rpint=new JPasswordField();
         rpint.setFont(new Font("Raleway",Font.BOLD,25));
         rpint.setBounds(320,380,180,25);
         image.add(rpint);

         change=new JButton("Change");
         change.setBounds(350,490,150,30);
         change.addActionListener(this);
         image.add(change);

         exit =new JButton("Back");
         exit.setBounds(350,520,150,30);
         exit.addActionListener(this);
         image.add(exit);

         setSize(900,900);
         setLocation(300,0);
         setUndecorated(true);
         setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit)
        {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
        else {
                try{
                    String npin=pint.getText();
                    String rpin=rpint.getText();
                    if(!npin.equals(rpin))
                    {
                        JOptionPane.showMessageDialog(null,"Entered pin doesn't match");
                    }
                    else if(npin.equals("")){
                        JOptionPane.showMessageDialog(null,"Please enter Pin");
                    }
                    else{
                            Conn conn=new Conn();
                            String q1="update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'" ;
                            String q2="update login set pinno = '"+rpin+"' where pinno ='"+pinnumber+"'" ;
                            String q3="update signupthree set pinno = '"+rpin+"' where pinno ='"+pinnumber+"'" ;
                            conn.s.executeUpdate(q1);
                            conn.s.executeUpdate(q2);
                            conn.s.executeUpdate(q3);
                            JOptionPane.showMessageDialog(null,"Pin changed Successfully");
                            setVisible(false);
                            new Transactions(rpin).setVisible(true);
                    }

                }
                catch (Exception e){
                    System.out.println(e);
                }
        }
    }

    public static void main(String[] args) {
        new Pinchange("");
    }
}
