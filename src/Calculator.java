import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame implements ActionListener {
    JTextField textField;
    JButton[] numberBtn=new JButton[10];
    JButton[] fncBtn=new JButton[8];
    JButton addB,subB,divB,mulB;
    JButton decB,equB,delB,clrB;
    JPanel panel;

    Font font=new Font("Ink Free",Font.BOLD,30);
    double num1=0,num2=0,res=0;
    char operator;

    Calculator()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Calculator");
        this.setSize(420,550);
        this.setLayout(null);

        textField=new JTextField();
        textField.setBounds(50,25,300,70);
        textField.setFont(font);
        textField.setEditable(false);

        addB=new JButton("+");
        subB=new JButton("-");
        mulB=new JButton("*");
        divB=new JButton("/");
        decB=new JButton(".");
        equB=new JButton("=");
        delB=new JButton("DEL");
        clrB=new JButton("CLR");

        fncBtn[0]=addB;
        fncBtn[1]=subB;
        fncBtn[2]=mulB;
        fncBtn[3]=divB;
        fncBtn[4]=decB;
        fncBtn[5]=equB;
        fncBtn[6]=delB;
        fncBtn[7]=clrB;

        for(int i=0;i<8;i++)
        {
            fncBtn[i].addActionListener(this);
            fncBtn[i].setFocusable(false);
            fncBtn[i].setFont(font);
        }

        for(int i=0;i<10;i++)
        {
            numberBtn[i]=new JButton(Integer.toString(i));
            numberBtn[i].addActionListener(this);
            numberBtn[i].setFocusable(false);
            numberBtn[i].setFont(font);
        }

        delB.setBounds(50,110,100,40);
        clrB.setBounds(160,110,100,40);

        panel=new JPanel();
        panel.setBounds(50,170,300,320);
        panel.setBackground(Color.lightGray);
        panel.setLayout(new GridLayout(4,4,3,3));

        panel.add(numberBtn[7]);
        panel.add(numberBtn[8]);
        panel.add(numberBtn[9]);

        panel.add(mulB);

        panel.add(numberBtn[4]);
        panel.add(numberBtn[5]);
        panel.add(numberBtn[6]);
        panel.add(subB);

        panel.add(numberBtn[1]);
        panel.add(numberBtn[2]);
        panel.add(numberBtn[3]);
        panel.add(addB);

        panel.add(numberBtn[0]);
        panel.add(divB);
        panel.add(decB);
        panel.add(equB);

        this.add(delB);
        this.add(clrB);
        this.add(panel);
        this.add(textField);
        this.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<10;i++)
        {
            if(e.getSource()==numberBtn[i])
            {
                textField.setText(textField.getText().concat(Integer.toString(i)));
            }
        }
        if(e.getSource()==decB)
        {
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addB)
        {
            num1=Double.parseDouble(textField.getText());
            operator='+';
            textField.setText("");
        }
        if(e.getSource()==subB)
        {
            num1=Double.parseDouble(textField.getText());
            operator='-';
            textField.setText("");
        }
        if(e.getSource()==mulB)
        {
            num1=Double.parseDouble(textField.getText());
            operator='*';
            textField.setText("");
        }
        if(e.getSource()==divB)
        {
            num1=Double.parseDouble(textField.getText());
            operator='/';
            textField.setText("");
        }
        if(e.getSource()==equB)
        {
            num2=Double.parseDouble(textField.getText());
            if(operator=='+')
            {
                res=num1+num2;
                textField.setText("= ");
                textField.setText(textField.getText().concat(Double.toString(res)));
            }
            if(operator=='-')
            {
                res=num1-num2;
                textField.setText("= ");
                textField.setText(textField.getText().concat(Double.toString(res)));
            }
            if(operator=='*')
            {
                res=num1*num2;
                textField.setText("= ");
                textField.setText(textField.getText().concat(Double.toString(res)));
            }
            if(operator=='/')
            {
                if(num2==0)
                {
                    textField.setText("Stupid! Just put different second number");
                }
                else {
                    res=num1/num2;
                    textField.setText("= ");
                    textField.setText(textField.getText().concat(Double.toString(res)));
                }
            }
        }
        if(e.getSource()==clrB)
        {
            textField.setText("");
        }
        if(e.getSource()==delB)
        {
            String tmp=textField.getText();
            textField.setText("");
            for(int i=0;i<tmp.length()-1;i++)
            {
                textField.setText(textField.getText()+tmp.charAt(i));
            }
        }
    }
}
