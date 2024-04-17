package Bank;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import com.toedter.calendar.JDateChooser;

public class Signup2 extends JFrame implements ActionListener {

    String form1;
    JComboBox relf,catf,incf,quaf,occf;
    JTextField adhf,panf;
    JRadioButton yes,no,yes1,no1;
    JButton next;
    Signup2(String form) {
        this.form1=form;
        setLayout(null);

        JLabel pd= new JLabel("Page2:Additional Details");
        pd.setFont(new Font("Raleway", Font.BOLD,22));
        pd.setBounds(290,80,400,30);
        add(pd);

        JLabel rel= new JLabel("Religion:");
        rel.setFont(new Font("Raleway", Font.BOLD,22));
        rel.setBounds(100,140,100,30);
        add(rel);

        String val[]={"Hindu","Sikh","Christan","Other"};
        relf =new JComboBox(val);
        relf.setBackground(Color.white);
        relf.setBounds(300,140,400,40);
        add(relf);

        JLabel cat= new JLabel("Category:");
        cat.setFont(new Font("Raleway", Font.BOLD,22));
        cat.setBounds(100,190,200,30);
        add(cat);

        String val2[]={"Genral","OBC","SC","ST"};
        catf =new JComboBox(val2);
        catf.setBackground(Color.white);
        catf.setBounds(300,190,400,40);
        add(catf);

        JLabel inc= new JLabel("Income:");
        inc.setFont(new Font("Raleway", Font.BOLD,22));
        inc.setBounds(100,240,200,40);
        add(inc);

        String val3[]={"NULL","0-300000","300000-750000","750000-1200000","1200000+"};
        incf =new JComboBox(val3);
        incf.setBackground(Color.white);
        incf.setBounds(300,240,400,40);
        add(incf);

        JLabel edu= new JLabel("Educational");
        edu.setFont(new Font("Raleway", Font.BOLD,22));
        edu.setBounds(100,290,200,30);
        add(edu);

        JLabel qua= new JLabel("Qualification:");
        qua.setFont(new Font("Raleway", Font.BOLD,22));
        qua.setBounds(100,325,200,30);
        add(qua);

        String val4[]={"Non Graduation","Graduation","Post Graduation","Doctorate","Other"};
        quaf =new JComboBox(val4);
        quaf.setBackground(Color.white);
        quaf.setBounds(300,300,400,40);
        add(quaf);

        JLabel occ= new JLabel("Occupation:");
        occ.setFont(new Font("Raleway", Font.BOLD,22));
        occ.setBounds(100,390,200,30);
        add(occ);


        String val5[]={"Salary Based","Self Employed","Business Man","Student","Other"};
        occf =new JComboBox(val5);
        occf.setBackground(Color.white);
        occf.setBounds(300,390,400,40);
        add(occf);



        JLabel pan= new JLabel("Pan Number:");
        pan.setFont(new Font("Raleway", Font.BOLD,22));
        pan.setBounds(100,440,200,30);
        add(pan);

        panf=new JTextField();
        panf.setFont(new Font("Raleway",Font.BOLD,30));
        panf.setBounds(300,440,400,40);
        add(panf);

        JLabel adh= new JLabel("Aadhar No.:");
        adh.setFont(new Font("Raleway", Font.BOLD,22));
        adh.setBounds(100,490,200,30);
        add(adh);

        adhf=new JTextField();
        adhf.setFont(new Font("Raleway",Font.BOLD,30));
        adhf.setBounds(300,490,400,40);
        add(adhf);



        JLabel sen= new JLabel("Senior Citezen:");
        sen.setFont(new Font("Raleway", Font.BOLD,22));
        sen.setBounds(100,540,200,30);
        add(sen);

        yes =new JRadioButton("Yes");
        yes.setBounds(300,540,120,30);
        yes.setBackground(Color.white);
        add(yes);

        no =new JRadioButton("No");
        no.setBounds(450,540,120,40);
        no.setBackground(Color.white);
        add(no);

        ButtonGroup exx=new ButtonGroup();
        exx.add(yes);
        exx.add(no);

        JLabel ex= new JLabel("Existing Account:");
        ex.setFont(new Font("Raleway", Font.BOLD,22));
        ex.setBounds(100,590,200,40);
        add(ex);

        yes1 =new JRadioButton("Yes");
        yes1.setBounds(300,590,120,40);
        yes1.setBackground(Color.white);
        add(yes1);

        no1 =new JRadioButton("No");;
        no1.setBounds(450,590,120,40);
        no1.setBackground(Color.white);
        add(no1);

        ButtonGroup exo=new ButtonGroup();
        exo.add(yes1);
        exo.add(no1);


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
        String formno=form1;
        String religion=(String)relf.getSelectedItem();
        String category=(String)catf.getSelectedItem();
        String income= (String)incf.getSelectedItem();
        String qualification= (String)quaf.getSelectedItem();
        String occupation=(String)occf.getSelectedItem();
        String pan=panf.getText();
        String adhar=adhf.getText();
        String Scitizen=null;
        if(yes.isSelected())
        {
            Scitizen="Yes";
        }
        else
        {
            Scitizen="No";
        }
        String Exist=null;
        if(yes1.isSelected()) {
            Exist = "Yes";
        }
        else {
            Exist="No";
        }
        try{
                Conn c=new Conn();
                String query ="insert into signuptwo values(' "+formno+"',' "+religion+"',' "+category+"',' "+occupation+"',' "+income+"',' "+qualification+"',' "+pan+"',' "+adhar+"',' "+Scitizen+"',' "+Exist+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno);
        }
        catch (Exception e){
            System.out.println(e);
        }

    }

    public static void main(String[] args) {
        new Signup2("");
    }



}
