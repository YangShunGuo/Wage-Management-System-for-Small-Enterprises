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
	JFrame f = new JFrame("工资信息管理系统");
	JButton b1 = new JButton("职工工资管理");
	JButton b2 = new JButton("职工信息管理");
	JButton b3 = new JButton("返回");

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

		if (b3.equals(e.getSource())) {// 返回
			DL d = new DL();
			d.create();
			f.dispose();
		}

		if (b2.equals(e.getSource())) {// 员工信息管理
			YGGL yg = new YGGL();
			yg.create();
			f.dispose();
		}
		if (b1.equals(e.getSource())) {// 员工工资管理


			GZGL gz = new GZGL();
			gz.create();
			f.dispose();
		}
	}
}
