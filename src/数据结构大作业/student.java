package ���ݽṹ����ҵ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javax.swing.*;
public class student extends JFrame {
	JFrame Studentwindow;
	JFrame Menu1window;
	JFrame Menu2window;
	JRadioButton radio1;
	JRadioButton radio2;
	JButton Confirm;
	JButton BackManager;
	JButton BackStudentmenu1;
	JButton BackStudentmenu2;
	JButton Recording1;
	JButton Recording2;
	JButton Random1;
	JButton Random2;
	JButton Random3;
	JButton Random4;
	JTextField field1;
	JTextField field2;
	JPanel panel1;
	JPanel panel2;
	//ѧ��ϵͳҳ��
	public student() {
		Studentwindow=new JFrame();
		Studentwindow.setBounds(100, 100, 1000, 800);
		Studentwindow.setVisible(true);
		Studentwindow.setLayout(new FlowLayout());
		radio1=new JRadioButton("һ��");
		radio2=new JRadioButton("����");
		Confirm=new JButton("ȷ��");
		Confirm.addActionListener(new ConfirmActionListener());
		Studentwindow.add(radio2);
		BackManager=new JButton("����");
		BackManager.addActionListener(new BackManagerActionListener());
		Studentwindow.add(radio1);
		radio1.addActionListener(new radio1ActionListener());
		Studentwindow.add(radio2);
		radio2.addActionListener(new radio2ActionListener());
		Studentwindow.add(Confirm);
		Studentwindow.add(BackManager);
		
	}
	class radio1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(radio1.isSelected()) {
				 radio2.setSelected(false);
			}
			else {
				radio2.setSelected(true);
			}
		}
	}
	class radio2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(radio2.isSelected()) {
				 radio1.setSelected(false);
			}
			else {
				radio1.setSelected(true);
			}
		}
	}
	//һ���˵�
	class ConfirmActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if(radio1.isSelected()) {
				try {
				Menu1window=new JFrame();
				Menu1window.setLayout(new BorderLayout());
				Menu1window.setBounds(100, 100, 1000, 800);
				Menu1window.setVisible(true);
				BackStudentmenu1=new JButton("����");
				BackStudentmenu1.addActionListener(new BackStudentmenu1ActionListener());
				panel1=new JPanel();
				panel2=new JPanel();
				panel2.setLayout(new BorderLayout());
				JLabel label=new JLabel("��������Ҫ��ѯ�Ĳ�Ʒ:");
				field1=new JTextField(15);
				field1.addActionListener(new field1ActionListener());
				Random1=new JButton("���");
				Random1.addActionListener(new Random1ActionListener());
				Recording1=new JButton("�鿴������¼");
				Recording1.addActionListener(new Recording1ActionListener());
				Dishes dis=new Dishes();				
				SinglyList<Dishes> list1;
				list1 = new SinglyList(dis.getmenu1());
				Dishes m[]=dis.getmenu1();
		    	list1.quickSort(m);
		    	SinglyList<Dishes> list2;
		    	list2 = new SinglyList(m);
				Object[] title= {"��Ʒ����","��ζ","�۸�"}; 
				String[][] menu = new String[list2.size()][3];
				for(int i=0;i<100&&list2.head.next!=null;i++) {
				menu[i][0]= list2.head.next.data.name;
				menu[i][1]=list2.head.next.data.taste;
				menu[i][2]=list2.head.next.data.prize;
				list2.head=list2.head.next;
				}
				JTable table=new JTable(menu,title);
				panel2.add(table.getTableHeader(),BorderLayout.NORTH);
				panel2.add(table,BorderLayout.CENTER);
				panel2.add(table);
				panel1.add(label);
				panel1.add(field1);
				panel1.add(Random1);
				panel1.add(Recording1);
				panel1.add(BackStudentmenu1);
				Menu1window.add(panel1,BorderLayout.NORTH);
				Menu1window.add(panel2,BorderLayout.CENTER);
				Studentwindow.setVisible(false );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			//�����˵�
			else {
				try {
				Menu2window=new JFrame();
				Menu2window.setLayout(new BorderLayout());
				Menu2window.setBounds(100, 100, 1000, 800);
				Menu2window.setVisible(true);
				BackStudentmenu2=new JButton("����");
				BackStudentmenu2.addActionListener(new BackStudentmenu2ActionListener());
				panel1=new JPanel();
				panel2=new JPanel();
				panel2.setLayout(new BorderLayout());
				JLabel label=new JLabel("��������Ҫ��ѯ�Ĳ�Ʒ:");
				field2=new JTextField(15);
				field2.addActionListener(new field2ActionListener());
				Random2=new JButton("���");
				Random2.addActionListener(new Random2ActionListener());
				Recording2=new JButton("�鿴������¼");
				Recording2.addActionListener(new Recording2ActionListener());
				Dishes dis=new Dishes();				
				SinglyList<Dishes> list1;
				list1 = new SinglyList(dis.getmenu2());
				Dishes m[]=dis.getmenu2();
		    	list1.quickSort(m);
		    	SinglyList<Dishes> list2;
		    	list2 = new SinglyList(m);
				Object[] title= {"��Ʒ����","��ζ","�۸�"}; 
				String[][] menu = new String[list2.size()][3];
				for(int i=0;i<100&&list2.head.next!=null;i++) {
				menu[i][0]= list2.head.next.data.name;
				menu[i][1]=list2.head.next.data.taste;
				menu[i][2]=list2.head.next.data.prize;
				list2.head=list2.head.next;
				}
				JTable table=new JTable(menu,title);
				panel2.add(table.getTableHeader(),BorderLayout.NORTH);
				panel2.add(table,BorderLayout.CENTER);
				panel2.add(table);
				panel1.add(label);
				panel1.add(field2);
				panel1.add(Random2);
				panel1.add(Recording2);
				panel1.add(BackStudentmenu2);
				Menu2window.add(panel1,BorderLayout.NORTH);
				Menu2window.add(panel2,BorderLayout.CENTER);
				Studentwindow.setVisible(false );
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
	}
	//����һ���
	class Random1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
			Dishes dis=new Dishes();				
				Dishes m[]=dis.getmenu1();
				Random r=new Random();
				int i=r.nextInt(m.length);
				String str=m[i].name;
				JOptionPane.showMessageDialog(null, str,"�����Ʒ", getDefaultCloseOperation());
				//random.choice(m);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	//���ö����
	class Random2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
				Dishes dis=new Dishes();				
				Dishes m[]=dis.getmenu2();
				Random r=new Random();
				int i=r.nextInt(m.length);
				String str=m[i].name;
				JOptionPane.showMessageDialog(null, str,"�����Ʒ", getDefaultCloseOperation());
				//random.choice(m);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	class BackManagerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new Denglu();	
			Studentwindow.setVisible(false); 
		}
	}
	class BackStudentmenu1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new student();
			Menu1window.setVisible(false);
		}
	}
	class BackStudentmenu2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new student();
			Menu2window.setVisible(false);
		}
	}
	//¼�뷹��һ������¼,��������
	class field1ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
			String str1=field1.getText();
			Date date=new Date();
	    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd :hh:mm:ss");
	    	String str2=dateFormat.format(date);
			File file=new File("D:\\����һ������¼.txt");
			FileOutputStream out=new FileOutputStream(file,true);
			PrintWriter pw=new PrintWriter(out);
			pw.println(str2+"-"+str1);
			pw.flush();
			Dishes dis=new Dishes();				
			SinglyList<Dishes> list;
			list = new SinglyList(dis.getmenu1());
			for(int i=0;i<list.size();i++) {
			if(str1.equals(list.get(i).name)) {
		    JFrame window=new JFrame();
		    Object[] title= {"��Ʒ����","��ζ","�۸�"}; 
		    String[][]select= {{list.get(i).name,list.get(i).taste,list.get(i).prize}};
		    JTable table=new JTable(select,title);
		    window.setLayout(new BorderLayout());
			window.setBounds(100, 100, 1000, 800);
			window.setVisible(true);
			window.add(table.getTableHeader(),BorderLayout.NORTH);
			window.add(table,BorderLayout.CENTER);
			window.setDefaultCloseOperation(HIDE_ON_CLOSE);
					}
			else {
				
			}
				
				}	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	//¼�뷹�ö�������¼,��������
	class field2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			try {
			String str1=field2.getText();
			Date date=new Date();
	    	SimpleDateFormat dateFormat=new SimpleDateFormat("yyy-MM-dd :hh:mm:ss");
	    	String str2=dateFormat.format(date);
			File file=new File("D:\\���ö�������¼.txt");
			FileOutputStream out=new FileOutputStream(file,true);
			PrintWriter pw=new PrintWriter(out);
			pw.println(str2+"-"+str1);
			pw.flush();
			Dishes dis=new Dishes();				
			SinglyList<Dishes> list;
			list = new SinglyList(dis.getmenu2());
			for(int i=0;i<list.size();i++) {
			if(str1.equals(list.get(i).name)) {
		    JFrame window=new JFrame();
		    Object[] title= {"��Ʒ����","��ζ","�۸�"}; 
		    String[][]select= {{list.get(i).name,list.get(i).taste,list.get(i).prize}};
		    JTable table=new JTable(select,title);
		    window.setLayout(new BorderLayout());
			window.setBounds(100, 100, 1000, 800);
			window.setVisible(true);
			window.add(table.getTableHeader(),BorderLayout.NORTH);
			window.add(table,BorderLayout.CENTER);
			window.setDefaultCloseOperation(HIDE_ON_CLOSE);
					}
			else {
				
			}
				
				}	
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
	}
	class Recording1ActionListener implements ActionListener  {
		JFrame record;
		JTextArea text;
		JPanel panel;
		String str;
		public void actionPerformed(ActionEvent e) {
			record=new JFrame();
			record.setLayout(new BorderLayout());
			record.setBounds(100, 100, 1000, 800);
			record.setVisible(true);
			panel=new JPanel(new FlowLayout());
			text=new JTextArea();
			panel.setPreferredSize(new Dimension(50,50));
			record.add(panel,BorderLayout.NORTH);
			record.add(text,BorderLayout.CENTER);
			try {
			File file=new File("D:\\����һ������¼.txt");
			FileInputStream inone=new FileInputStream(file);
			InputStreamReader intwo;
			intwo = new InputStreamReader(inone);
			BufferedReader inthree=new BufferedReader(intwo);
			while((str=inthree.readLine())!=null) {
				text.append(str);
				text.append("\n");
			}
			inthree.close();
			
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();	
			}
		}
	}
	class Recording2ActionListener implements ActionListener  {
		JFrame record;
		JTextArea text;
		JPanel panel;
		String str;
		public void actionPerformed(ActionEvent e) {
			record=new JFrame();
			record.setLayout(new BorderLayout());
			record.setBounds(100, 100, 1000, 800);
			record.setVisible(true);
			panel=new JPanel(new FlowLayout());	
			text=new JTextArea();
			panel.setPreferredSize(new Dimension(50,50));
			record.add(panel,BorderLayout.NORTH);
			record.add(text,BorderLayout.CENTER);
			try {
			File file=new File("D:\\���ö�������¼.txt");
			FileInputStream inone=new FileInputStream(file);
			InputStreamReader intwo;
			intwo = new InputStreamReader(inone);
			BufferedReader inthree=new BufferedReader(intwo);
			while((str=inthree.readLine())!=null) {
				text.append(str);
				text.append("\n");
			}
			inthree.close();
			
			}
			catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();	
			}
		}
	}
	
}
