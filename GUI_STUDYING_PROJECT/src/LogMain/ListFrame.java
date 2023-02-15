package LogMain;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

public class ListFrame extends JFrame {

	private JPanel panel;
	private JTable table;
	private JLabel lilabel;
	private JButton logout, point;
	private DefaultTableModel tModel;

	public ListFrame() {
		super("List");
		super.setResizable(true);
		setSize(1300, 800);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		panel = new JPanel(new BorderLayout());
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);

		lilabel = new JLabel("회원 리스트");
		lilabel.setFont(new Font("Serif", Font.BOLD, 50));
		lilabel.setHorizontalAlignment(SwingConstants.CENTER);
		lilabel.setPreferredSize(new Dimension(400, 80));
		panel.add(lilabel, BorderLayout.NORTH);

		ManagementDAO mdao = ManagementDAO.getInstance();
		List<ManagementDTO> list = mdao.managementList();

		String[] member = { "아이디", "성명", "전화번호", "잔여 포인트" };

		tModel = new DefaultTableModel(member, 0);

		for (int i = 0; i < list.size(); i++) {

			String id1 = list.get(i).getId();
//         String password = list.get(i).getPassword();
			String name = list.get(i).getName();
			String tel = list.get(i).getTel();
			String point = list.get(i).getPoint();

			Object[] data = { id1, name, tel, point };

			tModel.addRow(data);

		}

		table = new JTable(tModel);
		table.setFont(new Font("돋움", Font.PLAIN, 20));
		table.setRowHeight(30);

		JScrollPane scrollPane = new JScrollPane(table);
		panel.add(scrollPane, BorderLayout.CENTER);

		JPanel pan = new JPanel();
		pan.setLayout(new GridLayout(1, 1, 1, 1));
		logout = new JButton("로그아웃");
		point = new JButton("적립하기");
		pan.add(logout);
		pan.add(point);
		panel.add(pan, BorderLayout.SOUTH);

		logout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				dispose();
				new LoginT();
			}
		});

		point.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "적립되었습니다.");
				new Point();
				dispose();
			}

		});

		setVisible(true);

	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new ListFrame();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}