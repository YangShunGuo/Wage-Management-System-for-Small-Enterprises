package wage_management;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

class DB extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame("��ӭ������ҵ���ʹ���ϵͳ");
	JLabel label = new JLabel("", JLabel.CENTER);
	JButton button1 = new JButton("����ϵͳ");
	JButton button2 = new JButton("�˳�ϵͳ");

	void Create() {
		JPanel pcontentPane = (JPanel) frame.getContentPane();
		pcontentPane.add(label);
		pcontentPane.setLayout(new FlowLayout());
		pcontentPane.add(button1);
		pcontentPane.add(button2);
		pcontentPane.setBackground(Color.gray);
		pcontentPane.setVisible(true);
		button1.addActionListener(this);
		button2.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(600, 400, 550, 180);
		frame.setResizable(false);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		DB dome = new DB();
		dome.Create();
	}

	public void actionPerformed(ActionEvent e) {
		if (button1.equals(e.getSource())) {
			DL dl = new DL();
			dl.create();
			frame.dispose();

		}
		if (button2.equals(e.getSource())) {// �˳�
			System.exit(0);

		}
	}
}
