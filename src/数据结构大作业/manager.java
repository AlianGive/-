package ���ݽṹ����ҵ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.lang.reflect.Field;

import javax.swing.*;
public class manager extends JFrame{
	JFrame MainWindow;
	JFrame DropWindow;
	JFrame AddWindow;
	JFrame ChangeWindow;
	JLabel label;
	JButton Drop;
	JButton Add;
	JButton Change;
	JButton Show;
	JButton BackDenglu;
	JButton BackManager;
	JButton ChangeBackmanager;
	JButton button8;
	JPanel panel;
	//����Ա��������
	public manager() {
		MainWindow=new JFrame("����Ա����");
		MainWindow.setLayout(new FlowLayout());
		label=new JLabel("��ѡ�����");
		Drop=new JButton("ɾ����Ʒ");
		Drop.addActionListener(new DropActionListener());
		Add=new JButton("���Ӳ�Ʒ");
		Add.addActionListener(new AddActionListener());
		Change=new JButton("�޸Ĳ�Ʒ");
		Change.addActionListener(new ChangeActionListener());
		Show=new JButton("�鿴��Ʒ");
		Show.addActionListener(new ShowActionListener());
		BackDenglu=new JButton("����");
		MainWindow.add(label);
		MainWindow.add(Drop);
		MainWindow.add(Add);
		MainWindow.add(Change);
		MainWindow.add(Show);
		MainWindow.add(BackDenglu);
		BackDenglu.addActionListener(new BackDengluActionListener());
		MainWindow.setBounds(100, 100, 1000, 800);
		MainWindow.setVisible(true);
		
	}
	//ɾ����Ʒ
	class DropActionListener implements ActionListener {
		JRadioButton radio1;
		JRadioButton radio2;
		JTextField drop;
		public void actionPerformed(ActionEvent e) { 
				DropWindow=new JFrame();
				DropWindow.setLayout(new FlowLayout());
				DropWindow.setBounds(100, 100, 1000, 800);
				DropWindow.setVisible(true);
				radio1=new JRadioButton("һ��");
				radio1.addActionListener(new radio1ActionListener());
				radio2=new JRadioButton("����");
				radio2.addActionListener(new radio2ActionListener());
				JLabel label=new JLabel("��������Ҫɾ���Ĳ���");
				drop=new JTextField(15);
				drop.addActionListener(new dropActionListener());
				BackManager=new JButton("���ع���Ա��������");
				BackManager.addActionListener(new BackManagerActionListener());
				DropWindow.add(radio1);
				DropWindow.add(radio2);
				DropWindow.add(label);
				DropWindow.add(drop);
				DropWindow.add(BackManager);
				MainWindow.setVisible(false); 
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
		class dropActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(radio1.isSelected()) {
				try {
				Dishes dis=new Dishes();				
				SinglyList<Dishes> list;
				list = new SinglyList(dis.getmenu1());
				File file=new File("D:\\����һ�˵�.txt");
				FileOutputStream outone=new FileOutputStream(file);
				OutputStreamWriter outtwo = new OutputStreamWriter(outone,"UTF-8");
				BufferedWriter inthree=new BufferedWriter(outtwo);
				for(int i=0;i<list.size();i++) {
				if(drop.getText().equals(list.get(i).name)) {
					System.out.println(list.remove(i).name);
					for(int j=0;j<100&&list.head.next!=null;j++) {
						inthree.write(list.head.next.data.name+","+list.head.next.data.taste+","+list.head.next.data.prize);
						inthree.write("\n");
						list.head=list.head.next;
						}
					JOptionPane.showMessageDialog(null, "ɾ���ɹ�","�ɹ�", getDefaultCloseOperation());
					break;
				}
				else
					System.out.println("ɾ��ʧ��");
				}
				JOptionPane.showMessageDialog(null, "ɾ��ʧ��","ʧ��", getDefaultCloseOperation());
				inthree.close();
				}
				 catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else {
					try {
						Dishes dis=new Dishes();				
						SinglyList<Dishes> list;
						list = new SinglyList(dis.getmenu2());
						File file=new File("D:\\���ö��˵�.txt");
						FileOutputStream outone=new FileOutputStream(file);
						OutputStreamWriter outtwo = new OutputStreamWriter(outone,"UTF-8");
						BufferedWriter inthree=new BufferedWriter(outtwo);
						for(int i=0;i<list.size();i++) {
							if(drop.getText().equals(list.get(i).name)) {
								System.out.println(list.remove(i).name);
								for(int j=0;j<100&&list.head.next!=null;j++) {
									inthree.write(list.head.next.data.name+","+list.head.next.data.taste+","+list.head.next.data.prize);
									inthree.write("\n");
									list.head=list.head.next;
									}
								JOptionPane.showMessageDialog(null, "ɾ���ɹ�","�ɹ�", getDefaultCloseOperation());
								break;
							}
							else
								System.out.println("ɾ��ʧ��");
							}
					JOptionPane.showMessageDialog(null, "ɾ��ʧ��","ʧ��", getDefaultCloseOperation());
					inthree.close();
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
							}
						}
				}
			}
	}
	//�޸Ĳ�Ʒ
	class ChangeActionListener implements ActionListener {
		JLabel label1;
		JLabel label2;
		JLabel label3;
		JLabel label4;
		JTextField drop1;
		JTextField drop2;
		JTextField drop3;
		JTextField drop4;
		JRadioButton radio1;
		JRadioButton radio2;
		JButton confirm;
		JPanel panel1;
		JPanel panel2;
		JTable table;
		public void actionPerformed(ActionEvent e) {
			ChangeWindow=new JFrame();
			ChangeWindow.setLayout(new BorderLayout());
			ChangeWindow.setBounds(100, 100, 1000, 800);
			ChangeWindow.setVisible(true);
			panel1=new JPanel(new FlowLayout());
			radio1=new JRadioButton("һ��");
			radio1.addActionListener(new radio1ActionListener());
			radio2=new JRadioButton("����");
			radio2.addActionListener(new radio2ActionListener());
			label1=new JLabel("����������Ҫ�޸ĵĲ���");
			label2=new JLabel("�������޸�Ϊ");
			label3=new JLabel("�������޸ĺ�Ŀ�ζ");
			label4=new JLabel("�������޸ĺ�ļ۸�");
			drop1=new JTextField(8);
			drop2=new JTextField(8);
			drop3=new JTextField(8);
			drop4=new JTextField(8);
			confirm=new JButton("ȷ���޸�");
			confirm.addActionListener(new confirmActionListener());
			ChangeBackmanager=new JButton("���ع���Ա��������");
			ChangeBackmanager.addActionListener(new ChangeBackmanagerActionListener());
			panel1.add(radio1);
			panel1.add(radio2);
			panel1.add(label1);
			panel1.add(drop1);
			panel1.add(label2);
			panel1.add(drop2);
			panel1.add(label3);
			panel1.add(drop3);
			panel1.add(label4);
			panel1.add(drop4);
			panel1.add(confirm);
			panel1.add(ChangeBackmanager);
			MainWindow.setVisible(false);
			panel1.setPreferredSize(new Dimension(150,80));
			ChangeWindow.add(panel1,BorderLayout.NORTH);
		
				}
			class radio1ActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					if(radio1.isSelected()) {
						 radio2.setSelected(false);
					}
				}
			}
			class radio2ActionListener implements ActionListener {
				public void actionPerformed(ActionEvent e) {
					if(radio2.isSelected()) {
						radio1.setSelected(false);
					}
				}
			}
			class confirmActionListener implements ActionListener {
				String str1;
				String str2;
				String str3;
				String str4;
				public void actionPerformed(ActionEvent e) {
					try {
					if(radio1.isSelected()) {
					str1=drop1.getText();
					str2=drop2.getText();
					str3=drop3.getText();
					str4=drop4.getText();
					Dishes dis=new Dishes();				
					SinglyList<Dishes> list;
					list = new SinglyList(dis.getmenu1());
					File file=new File("D:\\����һ�˵�.txt");
					FileOutputStream outone=new FileOutputStream(file);
					OutputStreamWriter outtwo = new OutputStreamWriter(outone,"UTF-8");
					BufferedWriter inthree=new BufferedWriter(outtwo);
					for(int i=0;i<list.size();i++) {
					if(str1.equals(list.get(i).name)){
						list.get(i).name=str2;
						list.get(i).taste=str3;
						list.get(i).prize=str4;
						break;
								} 
					else
						System.out.println("����ʧ��");
							}
					 Node<Dishes> p=list.head;
					for(int j=0;j<list.size()&&list.head.next!=null;j++) {
						inthree.write(p.next.data.name+","+p.next.data.taste+","+p.next.data.prize);
						inthree.write("\n");
						 p=p.next;
						}
					inthree.close();
					System.out.println("�޸ĳɹ�");
						}
					}
					catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					}
				}
			}
//��Ӳ�Ʒ		
	class AddActionListener implements ActionListener {
		JLabel label1;
		JLabel label2;
		JLabel label3;
		JTextField field1;
		JTextField field2;
		JTextField field3;
		JRadioButton radio1;
		JRadioButton radio2;
		JTextField drop;
		JButton confirm;
		public void actionPerformed(ActionEvent e) {
			radio1=new JRadioButton("һ��");
			radio1.addActionListener(new radio1ActionListener());
			radio2=new JRadioButton("����");
			radio2.addActionListener(new radio2ActionListener());
			label1=new JLabel("���������");
			label2=new JLabel("�������ζ");
			label3=new JLabel("������۸�");
			field1=new JTextField(15);
			field2=new JTextField(15);
			field3=new JTextField(15);
			confirm=new JButton("ȷ��");
			confirm.addActionListener(new confirmActionListener());
			ChangeBackmanager=new JButton("���ع���Ա��������");
			ChangeBackmanager.addActionListener(new AddBackmanagerActionListener());
			AddWindow=new JFrame();
			AddWindow.setLayout(new FlowLayout());
			AddWindow.setBounds(100, 100, 1000, 800);
			AddWindow.setVisible(true);
			AddWindow.add(radio1);
			AddWindow.add(radio2);
			AddWindow.add(label1);
			AddWindow.add(field1);
			AddWindow.add(label2);
			AddWindow.add(field2);
			AddWindow.add(label3);
			AddWindow.add(field3);
			AddWindow.add(confirm);
			AddWindow.add(ChangeBackmanager);
			MainWindow.setVisible(false);
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
		class confirmActionListener implements ActionListener {
			String str;
			String str1;
			String str2;
			String str3;
			public void actionPerformed(ActionEvent e) {
				if(radio1.isSelected()) {
				str1 = field1.getText();
				str2 = field2.getText();
				str3 = field3.getText();
				if(str1!=null&&str2!=null&&str3!=null) {
					try {
				str=str1+","+str2+","+str3;
				File file=new File("D:\\����һ�˵�.txt");
				FileOutputStream out = new FileOutputStream(file,true);
		        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
		        bw.write("\n");
		        bw.write(str);
		        JOptionPane.showMessageDialog(null, "��ӳɹ�","�ɹ�", getDefaultCloseOperation());
				System.out.println("��ӳɹ�");
				bw.close();
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				else 
					JOptionPane.showMessageDialog(null, "��ʧ��","ʧ��", getDefaultCloseOperation());
				}
				else {
					try {
						if(str1!=null&&str2!=null&&str3!=null) {
						str1 = field1.getText();
						str2 = field2.getText();
						str3 = field3.getText();
						str=str1+","+str2+","+str3;
						File file=new File("D:\\���ö��˵�.txt");
						FileOutputStream out = new FileOutputStream(file,true);
				        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(out,"UTF-8"));
				        bw.write("\n");
				        bw.write(str);
				        JOptionPane.showMessageDialog(null, "��ӳɹ�","�ɹ�", getDefaultCloseOperation());
						System.out.println("��ӳɹ�");
						bw.flush();
						}
						else 
							JOptionPane.showMessageDialog(null, "���ʧ��","ʧ��", getDefaultCloseOperation());
				}
				catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}

	}
	}
	class ShowActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			new student();
		}
	}
	class BackDengluActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
				new Denglu();
				MainWindow.setVisible(false);
		}
	}
	class BackManagerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			new manager();
			DropWindow.setVisible(false);
		}
	}
	class AddBackmanagerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			new manager();
			AddWindow.setVisible(false);
		}
	}
	class ChangeBackmanagerActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) { 
			new manager();
			ChangeWindow.setVisible(false);
		}
	}
}
	
	
	

