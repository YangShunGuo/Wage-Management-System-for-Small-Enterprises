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
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class YGGL extends JFrame implements ActionListener {

	JFrame f = new JFrame("职工信息管理");
	JButton b2 = new JButton("修改职工信息");
	JButton b3 = new JButton("删除职工信息");
	JButton b4 = new JButton("查询所有职工信息");
	JButton b5 = new JButton("返回");
	JTextField tf1 = new JTextField(8);
	JTextField tf2 = new JTextField(8);
	JTextField tf3 = new JTextField(6);
	JTextField tf4 = new JTextField(6);
	JTextField tf5 = new JTextField(6);
	JTextField tf6 = new JTextField(6);
	String[] cloum = { "职工号", "姓名", "性别", "年龄","部门","职业"};
	Object[][] row = new Object[50][6];
	JTable table = new JTable(row, cloum);
	JScrollPane scrollpane = new JScrollPane(table);
	JSplitPane splitpane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
	void create() {
		JPanel p = (JPanel) f.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(scrollpane);
		p.add(splitpane);
		JPanel p1 = new JPanel();
		p1.add(b2);
		p1.add(b3);
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.gray);
		p2.add(scrollpane);
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("职工号"));
		p.add(tf1);
		p.add(new JLabel("姓名"));
		p.add(tf2);
		p.add(new JLabel("性别"));
		p.add(tf3);
		p.add(new JLabel("年龄"));
		p.add(tf4);
		p.add(new JLabel("部门"));
		p.add(tf5);
		p.add(new JLabel("职业"));
		p.add(tf6);
		splitpane.add(p1, JSplitPane.TOP);
		splitpane.add(p2, JSplitPane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.gray);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(600, 200, 500, 605);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b2.equals(e.getSource())) {// 修改员工信息
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "连接数据库失败！");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement();
				String updateStr = "UPDATE  worker  SET name='"+tf2.getText()+"',sex='"+tf3.getText()+"',age='"+tf4.getText()+"',dep='"+tf5.getText()+"',occup='"+tf6.getText()+"'where num='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				JOptionPane.showMessageDialog(this, "修改成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "修改失败！");
			}
		}

		if (b3.equals(e.getSource())) {// 删除员工信息
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "连接数据库失败！");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM worker  where  num='"+tf1.getText()+"';");
				sql.executeUpdate("DELETE FROM salary  where  worker_num='"+tf1.getText()+"';");
				JOptionPane.showMessageDialog(this, "删除成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}

		}

		if (b4.equals(e.getSource())) {// 查询全部员工信息
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "连接数据库失败！");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				if (b4.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 4; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select * from worker;");
					int k = -1;
					while (rs.next()) {

						++k;
						String no = rs.getString(1);
						String xm = rs.getString(2);
						String xb = rs.getString(3);
						String nl = rs.getString(4);
						String bm = rs.getString(5);
						String zy = rs.getString(6);
						table.setValueAt(no, k, 0);
						table.setValueAt(xm, k, 1);
						table.setValueAt(xb, k, 2);
						table.setValueAt(nl, k, 3);
						table.setValueAt(bm, k, 4);
						table.setValueAt(zy, k, 5);

					}
				}
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "查询失败！");
			}
		}
		if (b5.equals(e.getSource())) {// 返回
			GZGLZJM gl=new GZGLZJM();
			gl.create();
			f.dispose();

		}
	}
}
