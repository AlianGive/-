package ���ݽṹ����ҵ;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
//��¼����
public class Denglu extends JFrame {
	public static void main(String args[]) {
		new Denglu();
	}
	JFrame window;
	JLabel Label1;
	JLabel Label2;
	JLabel Label3;
	JButton Button1;
	JButton Button2;
	JButton button;
	JPanel panel1;
	JPanel panel2;
	public Denglu(){	
		window=new JFrame("��¼����");
		window.setLayout(new BorderLayout());
		window.setBounds(100, 100, 1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		panel1=new JPanel();
		Label3=new JLabel("��ӭ����ѡ��ϵͳ");
		Label3.setFont(new Font("����",Font.PLAIN,40));
		panel1.add(Label3);
		panel1.setPreferredSize(new Dimension(30,60));
		window.add(panel1,BorderLayout.NORTH);
		panel2=new JPanel();
		Button1=new JButton("����Ա��¼");
		Button1.addActionListener(new Button1ActionListener());
		Button2=new JButton("ѧ����¼");
		Button2.addActionListener(new Button2ActionListener());
		panel2.add(Button1);
		panel2.add(Button2);
		window.add(panel2,BorderLayout.CENTER);
		window.setVisible(true);
	}
	class Button1ActionListener implements ActionListener {
		JTextField Text1;
		JTextField Text2;
		JFrame mnaDenglu;
		JLabel label1;
		JLabel label2;
		JButton sure;
		JPanel panel;
		public void actionPerformed(ActionEvent e) {
			mnaDenglu=new JFrame("����Ա��¼����");
			mnaDenglu.setLayout(new BorderLayout());
			mnaDenglu.setBounds(100, 100, 1000, 800);
			mnaDenglu.setVisible(true);
			mnaDenglu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			panel=new JPanel();
			panel.setLayout(new FlowLayout());
			label1=new JLabel("�˺�:");
			label2=new JLabel("����:");
			Text1=new JTextField(15);
			Text2=new JTextField(15);
			sure=new JButton("ȷ��");
			sure.addActionListener(new sureActionListener());
			panel.add(label1);
			panel.add(Text1);
			panel.add(label2);
			panel.add(Text2);
			panel.add(sure);
			mnaDenglu.add(panel,BorderLayout.NORTH);
			window.setVisible(false);
			
		}
		class sureActionListener implements ActionListener {
			public void actionPerformed(ActionEvent e) {
				if(Text1.getText().equals("zwy") &&Text2.getText().equals("123") ) {
					new manager();
					mnaDenglu.setVisible(false);
				}
				else {
					JOptionPane.showMessageDialog(null, "������˺Ŵ���,����������","����", getDefaultCloseOperation());
				}
					
			}
		}
	}
	class Button2ActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			new student();
			window.setVisible(false);
		}
	}
}