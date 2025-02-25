package controller.employee;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import controller.consmer.ConsmerLoginUI;
import service.impl.ProductServiceImpl;
import util.Clock;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class WorkStationUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static ProductServiceImpl productserviceimpl = new ProductServiceImpl();
	private JTextField id;
	private JTextField price;
	private JTextField productname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WorkStationUI frame = new WorkStationUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public WorkStationUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 205, 205));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBounds(10, 10, 416, 56);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("員工後臺管理");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(36, 5, 339, 41);
		panel.add(lblNewLabel);

		JTextArea output = new JTextArea();
		output.setBounds(228, 124, 182, 178);
		contentPane.add(output);
		
		//********************查看商品價格按鈕*********************
		
		JButton btnNewButton = new JButton("查看商品價格");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText(productserviceimpl.AllProduct());

			}
		});
		btnNewButton.setBounds(251, 322, 159, 23);
		contentPane.add(btnNewButton);

		JPanel JPanel = new JPanel();
		JPanel.setBounds(10, 124, 198, 231);
		contentPane.add(JPanel);
		JPanel.setLayout(null);

		// *******************更改按鈕*****************

		JButton btnNewButton_1 = new JButton("更改");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int ProductID = Integer.parseInt(id.getText());
				String Productname = productname.getText();
				int Price = Integer.parseInt(price.getText());

				productserviceimpl.updateProduct(ProductID, Productname, Price);

			}

		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setBounds(97, 198, 85, 23);
		JPanel.add(btnNewButton_1);

		JLabel lblNewLabel_1_3 = new JLabel("ID:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(10, 25, 71, 28);
		JPanel.add(lblNewLabel_1_3);

		id = new JTextField();
		id.setFont(new Font("新細明體", Font.BOLD, 12));
		id.setColumns(10);
		id.setBounds(87, 29, 96, 21);
		JPanel.add(id);

		price = new JTextField();
		price.setBounds(73, 146, 55, 21);
		JPanel.add(price);
		price.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("商品:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(24, 85, 55, 22);
		JPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("元");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(138, 142, 46, 28);
		JPanel.add(lblNewLabel_2);

		productname = new JTextField();
		productname.setBounds(86, 86, 96, 21);
		JPanel.add(productname);
		productname.setColumns(10);

		// ****************回到登入按鈕****************

		JButton btnNewButton_2 = new JButton("回到登入");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsmerLoginUI consmerlogin = new ConsmerLoginUI();
				consmerlogin.setVisible(true);
				dispose();

			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_2.setBounds(10, 73, 85, 23);
		contentPane.add(btnNewButton_2);

		// ********************時間**********************

		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(277, 388, 159, 25);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}
}
