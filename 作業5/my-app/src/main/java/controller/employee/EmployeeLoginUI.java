package controller.employee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.consmer.ConsmerLoginUI;
import util.Clock;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class EmployeeLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeLoginUI frame = new EmployeeLoginUI();
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
	public EmployeeLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(10, 10, 426, 65);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("八辣好吃水果店");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(21, 5, 383, 60);
		panel.add(lblNewLabel);
		
		//***************返回按鈕*************
		
		JButton btnNewButton_2 = new JButton("返回");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsmerLoginUI consmerlogin = new ConsmerLoginUI();
				consmerlogin.setVisible(true);
				dispose();

			}
		});
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(10, 10, 64, 28);
		panel.add(btnNewButton_2);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 99, 391, 263);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("員工登入");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(107, 5, 181, 46);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2.setBounds(83, 73, 56, 20);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("密碼:");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_2_1.setBounds(82, 146, 46, 20);
		panel_1.add(lblNewLabel_2_1);

		textField = new JTextField();
		textField.setBounds(165, 73, 96, 21);
		panel_1.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(165, 145, 96, 21);
		panel_1.add(textField_1);

		// ******************確定按鈕********************

		JButton btnNewButton = new JButton("確定");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkStationUI workstation = new WorkStationUI();
				workstation.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(262, 199, 85, 30);
		panel_1.add(btnNewButton);

		// *****************註冊按鈕*****************

		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddEmployeeUI addemployee = new AddEmployeeUI();
				addemployee.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(55, 199, 85, 30);
		panel_1.add(btnNewButton_1);

		// ****************時間****************

		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(291, 383, 145, 30);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}

}
