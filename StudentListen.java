package myproject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class StudentListen implements ActionListener {

	JPanel jp1;
	JButton jbutton_1;
	JButton jbutton_2;
	JTextField jtextfield[];

	public StudentListen(JPanel jp1, JButton jbutton_1, JButton jbutton_2, JTextField jtextfield[]) {
		this.jp1 = jp1;
		this.jbutton_1 = jbutton_1;
		this.jbutton_2 = jbutton_2;
		this.jtextfield = jtextfield;
	}

	// ����� ���ѧ�����ύ ��ť
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		������ύ��ť
		if (e.getSource() == jbutton_1) {

			// �ж�ѧ�������Ƿ�Ϊ��
			if (jtextfield[1].getText().trim().equals("")) {
				JOptionPane.showMessageDialog(null, "������ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			} else if (jtextfield[1].getText().matches("\\d+")) {
				JOptionPane.showMessageDialog(null, "��������ȷ��ѧ������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			// �ж��Ƿ�������Ա�ѡ�񲢶�ȡѡ��
			String str = "";
			Component[] jcbs = jp1.getComponents();// ����ѡ�����ݴ�������
			for (Component component : jcbs) {
				JRadioButton jcb = (JRadioButton) component;
				if (jcb.isSelected()) {
					str += jcb.getText() + "";
				}
			}
			if (str.equals("")) {
				JOptionPane.showMessageDialog(null, "��ѡ��ѧ���Ա�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				return;
			}

			// �Գ������ڽ��������ʽ���Ƿ���ڽ������ڣ��Ƿ�Ϸ������ж�
			Date dateofbirth = null;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			try {
				dateFormat.setLenient(false);
				dateofbirth = dateFormat.parse(jtextfield[3].getText());
				Date today = new Date();
				if (dateofbirth.after(today)) {
					JOptionPane.showMessageDialog(null, "�������ڲ����ڽ���֮����������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ",
							JOptionPane.PLAIN_MESSAGE);
					return;
				}
			} catch (Exception e1) {
				JOptionPane.showMessageDialog(null, "��������ȷ�����ڸ�ʽ��yyyy/mm/dd��", "��ʾ", JOptionPane.PLAIN_MESSAGE);
				e1.printStackTrace();
				return;
			}

			StudentInformation student = new StudentInformation(Integer.parseInt(jtextfield[0].getText()),
					jtextfield[1].getText(), str, jtextfield[3].getText(), -1, -1, -1, -1, -1);
//				��ѧ����������ܶ�����
			StudentInformation.all_student.add(student);
			JOptionPane.showMessageDialog(null, "���ѧ���ɹ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			StudentInformation.ID++;
		}
		StudentUI.init_2();

	}
}
