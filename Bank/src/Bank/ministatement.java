package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class ministatement extends JFrame implements ActionListener {
    String pinnumber;
    JButton exit;
  public   ministatement(String pinnumber){
        this.pinnumber=pinnumber;
        setLayout(null);

        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
      try {
          Conn conn = new Conn();
          ResultSet rs = conn.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pinnumber + "' LIMIT 5");
          int c=0;
          while(rs.next()) {
              String text = rs.getString("date") + " " + rs.getString("type") + " " + rs.getString("amount") ;
              JLabel textt = new JLabel(text);
              textt.setForeground(Color.white);
              textt.setFont(new Font("System", Font.BOLD, 16));
              textt.setBounds(160, 300+c, 500, 30);
              image.add(textt);
              c+=40;
          }

      } catch (Exception e) {
          System.out.println(e);
      }

      exit =new JButton("Back");
        exit.setBounds(350,520,150,30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setVisible(true);
        setLocation(300,0);
    }

    public void actionPerformed(ActionEvent e) {
      setVisible(false);
      new Transactions(pinnumber).setVisible(true);

    }

    public static void main(String[] args) {
        new ministatement("");
    }
}
