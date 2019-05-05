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
public class GZGL extends JFrame implements ActionListener {

	JFrame f = new JFrame("职工工资管理");
	JButton b1 = new JButton("录入");
	JButton b2 = new JButton("修改");
	JButton b3 = new JButton("删除");
	JButton b4 = new JButton("查询所有");
	JButton b5 = new JButton("返回");
	JTextField tf1 = new JTextField(6);
	JTextField tf2 = new JTextField(4);
	JTextField tf3 = new JTextField(4);
	JTextField tf4 = new JTextField(4);
	JTextField tf5 = new JTextField(4);
	JTextField tf6 = new JTextField(4);
	JTextField tf7 = new JTextField(6);
	JTextField tf8 = new JTextField(6);
	JTextField tf9 = new JTextField(4);
	JTextField tf10= new JTextField(4);
	JTextField tf11= new JTextField(6);
	JTextField tf12= new JTextField(6);

	String[] cloum = { "职工号", "基本工资", "津贴", "奖金","保险","房贷","总工资"};
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
		p1.add(b4);
		p1.add(b5);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.gray);
		p2.add(scrollpane);
		@SuppressWarnings("unused")
		JPanel p3 = new JPanel();
		p.setLayout(new FlowLayout());
		p.add(new JLabel(""));
		p.add(new JLabel("职工号"));
		p.add(tf1);
		p.add(new JLabel("基本工资"));
		p.add(tf2);
		p.add(new JLabel("津贴"));
		p.add(tf3);
		p.add(new JLabel("奖金"));
		p.add(tf4);
		p.add(new JLabel("保险"));
		p.add(tf5);
		p.add(new JLabel("房贷"));
		p.add(tf6);
		p.add(new JLabel("总工资"));
		p.add(tf7);
		p.add(new JLabel("姓名"));
		p.add(tf8);
		p.add(new JLabel("性别"));
		p.add(tf9);
		p.add(new JLabel("年龄"));
		p.add(tf10);
		p.add(new JLabel("部门"));
		p.add(tf11);
		p.add(new JLabel("职业"));
		p.add(tf12);

		splitpane.add(p1, JSplitPane.TOP);
		splitpane.add(p2, JSplitPane.BOTTOM);
		splitpane.setDividerLocation(50);
		p.setBackground(Color.gray);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		f.setBounds(600, 200, 510, 635);
		f.setResizable(true);// 可以调整界面大小
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b1.equals(e.getSource())) { // 录入
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement();
				String insertStr = "INSERT INTO salary (worker_num,basic_pay,welfare,bonus,insurance,housing_fund,payment)VALUES('"+tf1.getText()+"','"+tf2.getText()+"','"+tf3.getText()+"','"+tf4.getText()+"','"+tf5.getText()+"','"+tf6.getText()+"','"+tf7.getText()+"');";

				sql.executeUpdate(insertStr);
				String insertStr1 = "INSERT INTO worker (num,name,sex,age,dep,occup,password)VALUES('"+tf1.getText()+"','"+tf8.getText()+"','"+tf9.getText()+"','"+tf10.getText()+"','"+tf11.getText()+"','"+tf12.getText()+"','"+tf1.getText()+"');";
				sql.executeUpdate(insertStr1);
				con.close();
				JOptionPane.showMessageDialog(this, "录入成功！");
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "录入失败！");
			}
		}
		if (b2.equals(e.getSource())) {// 修改
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement();
				String updateStr = "UPDATE salary SET basic_pay='"+tf2.getText()+"',welfare='"+tf3.getText()+"',bonus='"+tf4.getText()+"',insurance='"+tf5.getText()+"',housing_fund='"+tf6.getText()+"',payment='"+tf7.getText()+"'where worker_num='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				String updateStr1 = "UPDATE worker SET name='"+tf8.getText()+"',sex='"+tf9.getText()+"',age='"+tf10.getText()+"',dep='"+tf11.getText()+"',occup='"+tf12.getText()+"'where num='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr1);
				JOptionPane.showMessageDialog(this, "修改成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "信息不存在！");
			}
		}

		if (b3.equals(e.getSource())) {// 删除
			Connection con;
			Statement sql;
			//ResultSet rs;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				System.out.println("" + e1);
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM salary  where  worker_num='"+tf1.getText()+"';");
				sql.executeUpdate("DELETE FROM worker  where  num='"+tf1.getText()+"';");
				JOptionPane.showMessageDialog(this, "删除成功！");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "删除失败！");
			}

		}

		if (b4.equals(e.getSource())) {// 查询全部
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
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				if (b4.equals(e.getSource())) {

					for (int i = 0; i < 50; i++)
						for (int j = 0; j < 4; j++)
							table.setValueAt("", i, j);
					rs = sql.executeQuery("select * from salary");
					int k = -1;
					while (rs.next()) {

						++k;
						String no = rs.getString(1);
						String jb = rs.getString(2);
						String jt = rs.getString(3);
						String jj = rs.getString(4);
						String bx = rs.getString(5);
						String zf = rs.getString(6);
						String sum=	rs.getString(7);
						table.setValueAt(no, k, 0);
						table.setValueAt(jb, k, 1);
						table.setValueAt(jt, k, 2);
						table.setValueAt(jj, k, 3);
						table.setValueAt(bx, k, 4);
						table.setValueAt(zf, k, 5);
						table.setValueAt(sum,k, 6);

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
