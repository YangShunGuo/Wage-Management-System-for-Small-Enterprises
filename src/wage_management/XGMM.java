package wage_management;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

@SuppressWarnings("serial")
class XGMM extends DL implements ActionListener 
{
	JFrame frame = new JFrame("�����޸�");
	JLabel label1 = new JLabel("ԭ����");
	JLabel label2 = new JLabel("������");
	JButton Button1 = new JButton("ȷ��");
	JButton cancelButton = new JButton("����");
	JPasswordField password = new JPasswordField(9);
	JPasswordField newpassword = new JPasswordField(9);
	void create() 
	{
		JPanel p = (JPanel) frame.getContentPane();
		p.setLayout(new FlowLayout());
		p.add(label1);
		p.setSize(5, 5);
		p.setLocation(4, 8);
		p.add(password);
		p.setSize(100, 200);
		p.setLocation(600, 600);
		p.add(label2);
		p.setSize(50, 20);
		p.setLocation(40, 80);
		p.add(newpassword);
		p.setSize(100, 20);
		p.setLocation(80, 120);
		p.add(Button1);
		p.add(cancelButton);
		p.setBackground(Color.gray);
		p.setVisible(true);
		Button1.addActionListener(this);
		cancelButton.addActionListener(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setBounds(600, 300, 500, 220);
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) 
	{
		if (e.getSource()==Button1)
		{
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
				@SuppressWarnings("deprecation")
				String updateStr = "UPDATE  worker  SET password='"+newpassword.getText()+"'where num='"+t1+"';";
				sql.executeUpdate(updateStr);
				JOptionPane.showMessageDialog(this, "�޸ĳɹ���");
				con.close();
			} catch (SQLException e1) {
				JOptionPane.showMessageDialog(this, "������ԭ����������룡");
			}
		}
		if (e.getSource()==cancelButton) // ����
		{
			YGGLZJM dl=new YGGLZJM();
			dl.create();

			frame.dispose();
		}
	}
}
