package myproject;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;

public class StudentUI {

//	��������
	public static JFrame jframe_1 = new JFrame("ѧ���ɼ�����ϵͳ");
//	�������
	public static JPanel jpanel_1 = new JPanel(new ModifiedFlowLayout());// ����
	public static JPanel jpanel_2 = new JPanel(null);// �ղ���
//	�����ı���������ʾ��Ϣ
	public static JTextArea j_1 = new JTextArea();

	public static void main(String[] args) {

//		ʵ����
		StudentUI ui = new StudentUI();
//		���÷���
		ui.init_1();
	}

//	������
	public void init_1() {

//		���ڴ�С
		jframe_1.setSize(850, 500);
//		�ղ���
		jframe_1.setLayout(null);
//		���ڲ��ɵ���
		jframe_1.setResizable(false);
//		�رմ������˳�����
		jframe_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		�˵���
		JMenuBar bar = new JMenuBar();
//		һ���˵�
		JMenu men_1 = new JMenu("��������");
		JMenu men_2 = new JMenu("����");
//		�Ӳ˵�
		JMenuItem item_1 = new JMenuItem("���ѧ��");
		JMenuItem item_2 = new JMenuItem("����ɼ�");

//		��������
		Font font = new Font("����", Font.PLAIN, 15);
		item_2.setFont(font);

//		���ò˵�����
		men_1.setFont(font);
		men_2.setFont(font);
		item_1.setFont(font);

//		����
		men_1.add(item_1);
		men_1.add(item_2);

		bar.add(men_1);
		bar.add(men_2);
		jframe_1.setJMenuBar(bar);

//		�������λ�á���С����ɫ
		jpanel_1.setBounds(0, 0, 200, 500);
		jpanel_2.setBounds(210, 0, 640, 500);
		jpanel_1.setBackground(Color.LIGHT_GRAY);
		jpanel_2.setBackground(Color.LIGHT_GRAY);
		jframe_1.add(jpanel_1);
		jframe_1.add(jpanel_2);

		// �����ı������ܱ༭
		j_1.setEditable(false);
		// ��j1��Ϊ�ɹ������sp����ʾ����
		JScrollPane sp = new JScrollPane(j_1);
		sp.setSize(625, 440);
		StudentUI.jpanel_2.add(sp);

		JScrollPane scrollPane = new JScrollPane(jpanel_1, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setSize(200, 440);
		jframe_1.add(scrollPane);

//		���ھ���
		jframe_1.setLocationRelativeTo(null);
//		������ʾ
		jframe_1.setVisible(true);

//		ע�� ���ѧ�� ��ť�ļ���
		item_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				���÷���
				StudentUI.init_2();
			}
		});

		// ����ɼ� ��ť����
		item_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String[] options = { "��ɢ��ѧ", "Java", "����", "Ӣ��" };
				String s = (String) JOptionPane.showInputDialog(null, "���������ѡ�", "��ʾ", JOptionPane.QUESTION_MESSAGE,
						null, options, null);
				if (s != null) {
					int i = 0;
					if (s.equals("Java")) {
						i = 4;
					} else if (s.equals("����")) {
						i = 5;
					} else if (s.equals("��ɢ��ѧ")) {
						i = 6;
					} else if (s.equals("Ӣ��")) {
						i = 7;
					}
					StudentUI.init_3(i);
				}
			}
		});
	}

//	���ѧ������
	public static void init_2() {
//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();

//		ѧ����
		String s[] = new String[4];
		s[0] = "ѧ       �ţ�";
		s[1] = "��       ����";
		s[2] = "��       ��";
		s[3] = "�������ڣ���yyyy/mm/dd��";

//		��ǩ
		JLabel jlabel[] = new JLabel[4];
//		�ı���
		JTextField jtextfield[] = new JTextField[4];
		JPanel jp1 = new JPanel();

		JLabel jlabel1 = new JLabel("���ѧ��                                        ");
		StudentUI.jpanel_1.add(jlabel1);

//		ʵ����
		for (int i = 0; i < 4; i++) {
			jlabel[i] = new JLabel(s[i]);
			StudentUI.jpanel_1.add(jlabel[i]);
			if (i == 2) {
				JRadioButton radioButton1 = new JRadioButton("��");
				JRadioButton radioButton2 = new JRadioButton("Ů");
				ButtonGroup bg = new ButtonGroup();
				bg.add(radioButton1);
				bg.add(radioButton2);
				jp1 = new JPanel(new GridLayout(1, 2));// һ������
				jp1.add(radioButton1);
				jp1.add(radioButton2);
				StudentUI.jpanel_1.add(jp1);
			} else {
				jtextfield[i] = new JTextField(12);
				StudentUI.jpanel_1.add(jtextfield[i]);
			}
		}

		// ѧ���Զ�����
		jtextfield[0].setText(String.valueOf(StudentInformation.ID));
		jtextfield[0].setEditable(false);

//		��ť
		JButton jbutton_1 = new JButton("�ύ");
		JButton jbutton_2 = new JButton("���");
//		���밴ť
		StudentUI.jpanel_1.add(jbutton_1);
		StudentUI.jpanel_1.add(jbutton_2);
//		ע�����
		StudentListen e_1 = new StudentListen(jp1, jbutton_1, jbutton_2, jtextfield);
		jbutton_1.addActionListener(e_1);
		jbutton_2.addActionListener(e_1);
	}

	// ����ɼ�����
	public static void init_3(int i) {

//		������
		StudentUI.jpanel_1.removeAll();
//		ˢ�����
		StudentUI.jpanel_1.updateUI();

		int num = StudentInformation.all_student.size();
//		�ı���
		JTextField jtextfield[] = new JTextField[num];

		if (i == 4) {
			JLabel jlabel1 = new JLabel("����java�ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 5) {
			JLabel jlabel1 = new JLabel("���������ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 6) {
			JLabel jlabel1 = new JLabel("������ɢ�ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		} else if (i == 7) {
			JLabel jlabel1 = new JLabel("����Ӣ��ɼ�                                ");
			StudentUI.jpanel_1.add(jlabel1);
		}
//		ʵ����
		for (int j = 0; j < num; j++) {
			jtextfield[j] = new JTextField(12);
			jpanel_1.add(jtextfield[j]);
		}

//		��ť
		JButton jbutton_3 = new JButton("�ύ");
		JButton jbutton_4 = new JButton("���");
//		���밴ť
		jpanel_1.add(jbutton_3);
		jpanel_1.add(jbutton_4);

//		ע�����
		StudentListen_4 e_4 = new StudentListen_4(jbutton_3, jbutton_4, jtextfield, i);
		jbutton_3.addActionListener(e_4);
		jbutton_4.addActionListener(e_4);

	}

}