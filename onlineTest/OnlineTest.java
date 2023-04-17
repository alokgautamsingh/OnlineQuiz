import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
	{
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,600,70);
		l.setFont(new Font("plain",Font.PLAIN,20));
		jb[0].setBounds(50,80,200,50);
		jb[1].setBounds(50,110,200,50);
		jb[2].setBounds(50,140,200,50);
		jb[3].setBounds(50,170,200,50);
		b1.setBounds(100,240,200,50);
		b2.setBounds(270,240,200,50);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(800,600);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,200,50);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
		}
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"your test is over youcorrect ans = " +count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: Which one among is our java teacher");
			jb[0].setText("suhaas sir");jb[1].setText("Nandini bm");jb[2].setText("darshan sir");jb[3].setText("devki mam");	
		}
		if(current==1)
		{
			l.setText("Que2: What is our college name");
			jb[0].setText("iit bombay");jb[1].setText("nie");jb[2].setText("nit");jb[3].setText("dtu");
		}
		if(current==2)
		{
			l.setText("Que3: where is nie located");
			jb[0].setText("bihar");jb[1].setText("delhi");jb[2].setText("mysore");jb[3].setText("usa");
		}
		if(current==3)
		{
			l.setText("Que4: when is 2nd internal");
			jb[0].setText("13");jb[1].setText("23");jb[2].setText("5");jb[3].setText("9");
		}
		if(current==4)
		{
			l.setText("Que5: Which institute is best for reserach");
			jb[0].setText("iisc");jb[1].setText("iit");jb[2].setText("nie");jb[3].setText("isro");
		}
		if(current==5)
		{
			l.setText("Que6: Which one is odd among them");
			jb[0].setText("apple");jb[1].setText("microsoft");jb[2].setText("l&t");jb[3].setText("google");
		}
		if(current==6)
		{
			l.setText("Que7: who is prime minister of india ");
			jb[0].setText("narendra modi");jb[1].setText("amit shah");jb[2].setText("kovind");jb[3].setText("Bhagat singh");
		}
		if(current==7)
		{
			l.setText("Que8: which is capital of india");
			jb[0].setText("usa");jb[1].setText("delhi");jb[2].setText("patna");jb[3].setText("bangalore");		
		}
		if(current==8)
		{
			l.setText("Que9: which is capital of karnataka");
			jb[0].setText("Bangalore");jb[1].setText("assam");jb[2].setText("delhi");jb[3].setText("kerala");
		}
		if(current==9)
		{
			l.setText("Que10: Which one among these is not in mysore");
			jb[0].setText("mysore palace");jb[1].setText("chamundi hills");jb[2].setText("tajmahal");jb[3].setText("vrindawan garden");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[0].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[2].isSelected());
		if(current==3)
			return(jb[0].isSelected());
		if(current==4)
			return(jb[3].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[0].isSelected());
		if(current==7)
			return(jb[1].isSelected());
		if(current==8)
			return(jb[0].isSelected());
		if(current==9)
			return(jb[2].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of basics");
	}


}
