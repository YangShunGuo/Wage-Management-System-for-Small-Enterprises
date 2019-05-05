package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
@SuppressWarnings("serial")
public class YGGLZJM extends DL implements ActionListener {

	JFrame f = new JFrame("个人工资信息");

	JButton b1 = new JButton("查询个人工资");
	JButton b2 = new JButton("修改密码");
	JButton b3 = new JButton("返回");

	String[] cloum = {"职工号", "基本工资", "津贴", "奖金","保险","房贷","总工资"};
	Object[][] row = new Object[50][7];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();

		p1.add(b1);
		p1.add(b2);

		p1.add(b3);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.cyan);
		p2.add(scrollpane);
		@SuppressWarnings("unused")
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());

		splitpane.add(p1, JSplitPane.TOP);
		splitpane.add(p2, JSplitPane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.gray);

		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		f.setBounds(600, 200, 500, 550);
		f.setResizable(false);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {

		if (b1.equals(e.getSource())) {// 查询个人工资
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				if (b1.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 4; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select * from  salary where salary.worker_num ='"+t1+"' ");
					int k = -1;
					while (rs.next()) {

						++k;
						String no = rs.getString(1);
						String jb = rs.getString(2);
						String jt = rs.getString(3);
						String jj = rs.getString(4);
						String bx = rs.getString(5);
						String zf = rs.getString(6);
						String gz = rs.getString(7);
						table.setValueAt(no, k, 0);
						table.setValueAt(jb, k, 1);
						table.setValueAt(jt, k, 2);
						table.setValueAt(jj, k, 3);
						table.setValueAt(bx, k, 4);
						table.setValueAt(zf, k, 5);
						table.setValueAt(gz, k, 6);

					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}
		if (b2.equals(e.getSource())) 
		{// 修改密码

			XGMM xgmm=new XGMM();
			xgmm.create();

		}
		if (b3.equals(e.getSource())) {// 返回
			DL dl=new DL();
			dl.create();
			f.dispose();

		}
	}
}
