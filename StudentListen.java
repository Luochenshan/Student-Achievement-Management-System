package myproject;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

			// �ж��Ƿ�������Ա�ѡ�񲢶�ȡѡ��
			String str = "";
			Component[] jcbs = jp1.getComponents();// ����ѡ�����ݴ�������
			for (Component component : jcbs) {
				JRadioButton jcb = (JRadioButton) component;
				if (jcb.isSelected()) {
					str += jcb.getText() + "";
				}
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

//����˵���ɼ����ύ��ť
class StudentListen_4 implements ActionListener {

	JButton jbutton_3;
	JButton jbutton_4;
	JTextField jtextfield[];
	int i;// ��ʾѧ��

	public StudentListen_4(JButton jbutton_3, JButton jbutton_4, JTextField jtextfield[], int i) {
		this.jbutton_3 = jbutton_3;
		this.jbutton_4 = jbutton_4;
		this.jtextfield = jtextfield;
		this.i = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		boolean flag = true;
//		����� �ύ ��ť
		if (e.getSource() == jbutton_3) {
			if (i == 4) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));// ȥ���ɼ�������Ŀո�
					// �жϳɼ��Ƿ��ں���Χ�ڣ�0��100��
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_java(Integer.parseInt(jtextfield[j].getText()));
					// ���ܷ�
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 5) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_physical(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 6) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j)
								.set_Discrete_Mathematics(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_English() > 0)
						sum += StudentInformation.all_student.get(j).get_English();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			} else if (i == 7) {
				for (int j = 0; j < StudentInformation.all_student.size(); j++) {
					jtextfield[j].setText(jtextfield[j].getText().replaceAll(" ", ""));
					if (Integer.parseInt(jtextfield[j].getText()) > 100
							|| Integer.parseInt(jtextfield[j].getText()) < 0) {
						flag = false;
						break;
					} else
						StudentInformation.all_student.get(j).set_English(Integer.parseInt(jtextfield[j].getText()));
					int sum = Integer.parseInt(jtextfield[j].getText());
					if (StudentInformation.all_student.get(j).get_java() > 0)
						sum += StudentInformation.all_student.get(j).get_java();
					if (StudentInformation.all_student.get(j).get_Discrete_Mathematics() > 0)
						sum += StudentInformation.all_student.get(j).get_Discrete_Mathematics();
					if (StudentInformation.all_student.get(j).get_physical() > 0)
						sum += StudentInformation.all_student.get(j).get_physical();
					StudentInformation.all_student.get(j).set_Total(sum);
				}
			}
			if (flag) {
				JOptionPane.showMessageDialog(null, "�ɹ���ӳɼ�������", "��ʾ", JOptionPane.PLAIN_MESSAGE);
			} else
				JOptionPane.showMessageDialog(null, "��������ȷ��ѧ���ɼ�", "��ʾ", JOptionPane.PLAIN_MESSAGE);
		} else {
//			����� ��� ��ť
			for (int j = 0; j < StudentInformation.all_student.size(); j++) {
				jtextfield[j].setText("");
			}
		}

	}

}