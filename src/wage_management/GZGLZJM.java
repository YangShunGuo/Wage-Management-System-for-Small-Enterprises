package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

class GZGLZJM extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JFrame f = new JFrame("������Ϣ����ϵͳ");
	JButton b1 = new JButton("ְ�����ʹ���");
	JButton b2 = new JButton("ְ����Ϣ����");
	JButton b3 = new JButton("����");

	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(b1);
		p.add(b2);
		p.add(b3);

		p.setBackground(Color.gray);
		p.setVisible(true);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(600, 400, 500, 200);
		f.setResizable(false);
		f.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {

		if (b3.equals(e.getSource())) {// ����
			DL d = new DL();
			d.create();
			f.dispose();
		}

		if (b2.equals(e.getSource())) {// Ա����Ϣ����
			YGGL yg = new YGGL();
			yg.create();
			f.dispose();
		}
		if (b1.equals(e.getSource())) {// Ա�����ʹ���


			GZGL gz = new GZGL();
			gz.create();
			f.dispose();
		}
	}
}
