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

	JFrame f = new JFrame("ְ����Ϣ����");
	JButton b2 = new JButton("�޸�ְ����Ϣ");
	JButton b3 = new JButton("ɾ��ְ����Ϣ");
	JButton b4 = new JButton("��ѯ����ְ����Ϣ");
	JButton b5 = new JButton("����");
	JTextField tf1 = new JTextField(8);
	JTextField tf2 = new JTextField(8);
	JTextField tf3 = new JTextField(6);
	JTextField tf4 = new JTextField(6);
	JTextField tf5 = new JTextField(6);
	JTextField tf6 = new JTextField(6);
	String[] cloum = { "ְ����", "����", "�Ա�", "����","����","ְҵ"};
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
		p.add(new JLabel("ְ����"));
		p.add(tf1);
		p.add(new JLabel("����"));
		p.add(tf2);
		p.add(new JLabel("�Ա�"));
		p.add(tf3);
		p.add(new JLabel("����"));
		p.add(tf4);
		p.add(new JLabel("����"));
		p.add(tf5);
		p.add(new JLabel("ְҵ"));
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
		f.setResizable(true);// ���Ե��������С
		f.setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		if (b2.equals(e.getSource())) {// �޸�Ա����Ϣ
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement();
				String updateStr = "UPDATE  worker  SET name='"+tf2.getText()+"',sex='"+tf3.getText()+"',age='"+tf4.getText()+"',dep='"+tf5.getText()+"',occup='"+tf6.getText()+"'where num='"+tf1.getText()+"';";
				sql.executeUpdate(updateStr);
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "�޸�ʧ�ܣ�");
			}
		}

		if (b3.equals(e.getSource())) {// ɾ��Ա����Ϣ
			Connection con;
			Statement sql;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
			}
			try {
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/wage_management?useSSL=false","root","123456");
				sql = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
				sql.executeUpdate("DELETE FROM worker  where  num='"+tf1.getText()+"';");
				sql.executeUpdate("DELETE FROM salary  where  worker_num='"+tf1.getText()+"';");
				JOptionPane.showMessageDialog(this, "ɾ���ɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "ɾ��ʧ�ܣ�");
			}

		}

		if (b4.equals(e.getSource())) {// ��ѯȫ��Ա����Ϣ
			Connection con;
			Statement sql;
			ResultSet rs;
			try {
				Class.forName("org.gjt.mm.mysql.Driver");
			} catch (ClassNotFoundException e1) {
				JOptionPane.showMessageDialog(this, "�������ݿ�ʧ�ܣ�");
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
				JOptionPane.showMessageDialog(this, "��ѯʧ�ܣ�");
			}
		}
		if (b5.equals(e.getSource())) {// ����
			GZGLZJM gl=new GZGLZJM();
			gl.create();
			f.dispose();

		}
	}
}
