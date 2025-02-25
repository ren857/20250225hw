package controller.consmer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import controller.employee.EmployeeLoginUI;
import controller.porder.AddPorderUI;
import dao.impl.EmployeeDaoImpl;
import model.Consmer;
import model.Employee;
import service.impl.ConsmerServiceImpl;
import util.Clock;
import util.Tool;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.JComboBox;

public class ConsmerLoginUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField username;
	private JTextField password;
	private static EmployeeDaoImpl employeedaoimpl = new EmployeeDaoImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsmerLoginUI frame = new ConsmerLoginUI();
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
	public ConsmerLoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(10, 10, 526, 70);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("八辣好吃水果行");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(56, 0, 410, 70);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(240, 240, 240));
		panel_1.setBounds(86, 116, 368, 327);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("帳號:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(55, 104, 46, 26);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("密碼:");
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(55, 174, 46, 26);
		panel_1.add(lblNewLabel_1_1);

		username = new JTextField();
		username.setBounds(139, 107, 119, 21);
		panel_1.add(username);
		username.setColumns(10);

		password = new JPasswordField();
		password.setColumns(10);
		password.setBounds(139, 177, 119, 21);
		panel_1.add(password); 
		
		//***********選擇員工***********
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(255, 280, 87, 23);
		List<Employee> employee = employeedaoimpl.selectAll();
		for (Employee e : employee) {
			comboBox.addItem(e);
		}

		panel_1.add(comboBox);
		
		//************確定按鈕*************
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.setForeground(new Color(255, 0, 128));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				String Username = username.getText();
				String Password = password.getText();

				Consmer consmer = new ConsmerServiceImpl().Login(Username, Password);
				
				Employee selectedEmployee = (Employee) comboBox.getSelectedItem();
				
				if (consmer != null) {
					Tool.save(consmer, "consmer.txt");
					Tool.save(selectedEmployee, "employee.txt");

					AddPorderUI addporder = new AddPorderUI();
					addporder.setVisible(true);
					dispose();

				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton.setBounds(255, 227, 69, 31);
		panel_1.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel("登入");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_2.setBounds(28, 26, 310, 39);
		panel_1.add(lblNewLabel_2);
		
		//**************註冊**************
		
		JButton btnNewButton_1 = new JButton("註冊");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddConsmerUI addconsmer = new AddConsmerUI();
				addconsmer.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setForeground(new Color(0, 0, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 15));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(63, 227, 69, 31);
		panel_1.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("我是員工");
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLoginUI employeelogin = new EmployeeLoginUI();
				employeelogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(273, 10, 85, 23);
		panel_1.add(btnNewButton_2);

		JLabel lblNewLabel_1_1_1 = new JLabel("服務人員:");
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(152, 280, 77, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		//************時間************
		
		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(345, 482, 170, 31);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
		
	}
}
