package controller.employee;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Employee;
import service.impl.EmployeeServiceImpl;
import util.Clock;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddEmployeeUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeUI frame = new AddEmployeeUI();
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
	public AddEmployeeUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("員工註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 18));
		lblNewLabel.setBounds(108, 10, 218, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(91, 94, 61, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(91, 155, 61, 39);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(91, 213, 61, 39);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("電話:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(91, 274, 61, 39);
		contentPane.add(lblNewLabel_1_3);
		
		name = new JTextField();
		name.setBounds(192, 103, 96, 21);
		contentPane.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(192, 164, 96, 21);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(192, 222, 96, 21);
		contentPane.add(password);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(192, 283, 96, 21);
		contentPane.add(phone);
		
		//*****************確定按鈕*******************
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name =name.getText();
				String Username = username.getText();
				String Password = password.getText();
				String Phone = phone.getText();
				
				if(new EmployeeServiceImpl().isUsernameBeenUse(Username)
					|| !new EmployeeServiceImpl().isValidUsername(Username)
					|| !new EmployeeServiceImpl().isValidPassword(Password)
					|| !new EmployeeServiceImpl().isValidPhone(Phone)) {
					System.out.println("NO");
					JOptionPane.showMessageDialog(null, "資料格式錯誤請重新輸入");
				}
				else {
					Employee employee = new Employee(Name,Username,Password,Phone,1);
					new EmployeeServiceImpl().addEmployee(employee);
					System.out.println("Yes");
					EmployeeLoginUI employeelogin = new EmployeeLoginUI();
					employeelogin.setVisible(true);
					dispose();
				}
				
				
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBounds(309, 339, 66, 23);
		contentPane.add(btnNewButton);
		
		//***************時間**************
		
		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(261, 382, 165, 31);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
		
		//****************返回按鈕****************
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EmployeeLoginUI employeelogin= new EmployeeLoginUI();
				employeelogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBounds(13, 19, 71, 21);
		contentPane.add(btnNewButton_1);
	}
}
