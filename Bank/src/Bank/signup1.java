package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class signup1 extends JFrame implements ActionListener {

    long random;
    JDateChooser dc;
    JTextField namef,fnamef,phonef,emaf,addf,cityf,statef,pinf;
    JRadioButton male,fmale,mari,nmari,other;
    JButton next;
    signup1() {
        Random ran=new Random();
        random= Math.abs(ran.nextLong() %9000L)+1000L;

        setLayout(null);

        JLabel formno =new JLabel("Application Form No:"+random);
        formno.setFont(new Font("Raleway", Font.BOLD,38));
        formno.setBounds(140,20,600,40);
        add(formno);

        JLabel pd= new JLabel("Page1:Personal Details");
        pd.setFont(new Font("Raleway", Font.BOLD,22));
        pd.setBounds(290,80,400,30);
        add(pd);

        JLabel name= new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD,22));
        name.setBounds(100,140,100,30);
        add(name);

        namef=new JTextField();
        namef.setFont(new Font("Raleway",Font.BOLD,30));
        namef.setBounds(300,140,400,40);
        add(namef);

        JLabel fname= new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD,22));
        fname.setBounds(100,190,200,30);
        add(fname);

        fnamef=new JTextField();
        fnamef.setFont(new Font("Raleway",Font.BOLD,30));
        fnamef.setBounds(300,190,400,40);
        add(fnamef);

        JLabel phone= new JLabel("Phone NO");
        phone.setFont(new Font("Raleway", Font.BOLD,22));
        phone.setBounds(100,240,200,30);
        add(phone);

        phonef=new JTextField();
        phonef.setFont(new Font("Raleway",Font.BOLD,30));
        phonef.setBounds(300,240,400,30);
        add(phonef);

        JLabel dob= new JLabel("Date of birth:");
        dob.setFont(new Font("Raleway", Font.BOLD,22));
        dob.setBounds(100,290,200,30);
        add(dob);

        dc= new JDateChooser();
        dc.setBounds(300,290,200,30);
        add(dc);

        JLabel gen= new JLabel("Gender:");
        gen.setFont(new Font("Raleway", Font.BOLD,22));
        gen.setBounds(100,340,100,30);
        add(gen);

        male =new JRadioButton("Male");
        male.setBounds(300,340,60,30);
        male.setBackground(Color.white);
        add(male);

        fmale =new JRadioButton("Female");
        fmale.setBounds(450,340,120,30);
        fmale.setBackground(Color.white);
        add(fmale);

        ButtonGroup gend=new ButtonGroup();
        gend.add(male);
        gend.add(fmale);

        JLabel ema= new JLabel("Email Address:");
        ema.setFont(new Font("Raleway", Font.BOLD,22));
        ema.setBounds(100,390,200,30);
        add(ema);

        emaf=new JTextField();
        emaf.setFont(new Font("Raleway",Font.BOLD,30));
        emaf.setBounds(300,390,400,40);
        add(emaf);


        JLabel mar= new JLabel("Maratial Status:");
        mar.setFont(new Font("Raleway", Font.BOLD,22));
        mar.setBounds(100,440,200,30);
        add(mar);

        mari =new JRadioButton("Married");
        mari.setBounds(300,440,120,30);
        mari.setBackground(Color.white);
        add(mari);

        nmari =new JRadioButton("Not Married");
        nmari.setBounds(450,440,120,30);
        nmari.setBackground(Color.white);
        add(nmari);

        other =new JRadioButton("Other");
        other.setBounds(600,440,120,30);
        other.setBackground(Color.white);
        add(other);

        ButtonGroup marr=new ButtonGroup();
        marr.add(mari);
        marr.add(nmari);
        marr.add(other);


        JLabel adde= new JLabel("Address:");
        adde.setFont(new Font("Raleway", Font.BOLD,22));
        adde.setBounds(100,490,100,30);
        add(adde);

        addf=new JTextField();
        addf.setFont(new Font("Raleway",Font.BOLD,30));
        addf.setBounds(300,490,400,40);
        add(addf);

        JLabel city= new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD,22));
        city.setBounds(100,540,100,30);
        add(city);

        cityf=new JTextField();
        cityf.setFont(new Font("Raleway",Font.BOLD,30));
        cityf.setBounds(300,540,400,40);
        add(cityf);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD,22));
        state.setBounds(100,590,100,30);
        add(state);

        statef=new JTextField();
        statef.setFont(new Font("Raleway",Font.BOLD,30));
        statef.setBounds(300,590,400,40);
        add(statef);

        JLabel pin= new JLabel("Pin Code:");
        pin.setFont(new Font("Raleway", Font.BOLD,22));
        pin.setBounds(100,640,200,30);
        add(pin);

        pinf=new JTextField();
        pinf.setFont(new Font("Raleway",Font.BOLD,30));
        pinf.setBounds(300,640,400,30);
        add(pinf);

        next=new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.white);
        next.addActionListener(this);
        next.setFont(new Font("Raleway",Font.BOLD,30));
        next.setBounds(580,690,120,40);
        add(next);

        getContentPane().setBackground(Color.white);

        setSize(850, 800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae)// since actionlistner class is abstract class so we have to override its function
    {
        String formno=""+random;
        String name=namef.getText();
        String fname=fnamef.getText();
        String dob= ((JTextField) dc.getDateEditor().getUiComponent()).getText();
        String phone=phonef.getText();
        String gender=null;
        if(male.isSelected())
        {
            gender="Male";
        }
        else
        {
            gender="female";
        }
        String email=emaf.getText();
        String maritial=null;
        if(mari.isSelected())
        {
            maritial="Married";
        }
        else if (nmari.isSelected())
        {
            maritial="Unmarried";
        }
        else {
            maritial="Other";
        }
        String add=addf.getText();
        String city=cityf.getText();
        String state=statef.getText();
        String pin=pinf.getText();

        try{
            if(name.equals("") || city.equals("")|| fname.equals("")|| add.equals("")|| email.equals("")|| phone.equals("")|| state.equals("")|| pin.equals("")|| dob.equals("")|| gender.equals("")|| maritial.equals(""))
            {
                JOptionPane.showMessageDialog(null,"Enter Complete Information");
            }
            else {
                Conn c=new Conn();
                String query ="insert into signup values(' "+formno+"',' "+name+"',' "+fname+"',' "+phone+"',' "+dob+"',' "+email+"',' "+gender+"',' "+maritial+"',' "+add+"',' "+city+"',' "+state+"',' "+pin+"')";
                c.s.executeUpdate(query);
            }

            setVisible(false);
             new Signup2(formno).setVisible(true);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new signup1();
    }



}
