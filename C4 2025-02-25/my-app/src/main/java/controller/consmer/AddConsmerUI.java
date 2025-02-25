package controller.consmer;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Consmer;
import service.impl.ConsmerServiceImpl;
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

public class AddConsmerUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField address;
	private JTextField phone;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddConsmerUI frame = new AddConsmerUI();
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
	public AddConsmerUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("註冊");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(127, 10, 287, 69);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(216, 216, 216));
		panel.setBounds(98, 85, 350, 366);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("姓名:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1.setBounds(69, 29, 66, 33);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("帳號:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(69, 90, 66, 33);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("密碼:");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_2.setBounds(69, 144, 66, 33);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("地址:");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_3.setBounds(69, 204, 66, 33);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("電話:");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("新細明體", Font.BOLD, 15));
		lblNewLabel_1_4.setBounds(69, 264, 66, 33);
		panel.add(lblNewLabel_1_4);
		
		name = new JTextField();
		name.setBounds(165, 35, 96, 21);
		panel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(165, 96, 96, 21);
		panel.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(165, 150, 96, 21);
		panel.add(password);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(165, 210, 96, 21);
		panel.add(address);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(165, 270, 96, 21);
		panel.add(phone);
		
		//*****************確定按鈕*****************
		
		JButton btnNewButton = new JButton("確定");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String Name=name.getText();
				String Username =username.getText();
				String Password=password.getText();
				String Address=address.getText();
				String Phone=phone.getText();
				
				if (new ConsmerServiceImpl().isUsernameBeenUse(Username)) {
				    JOptionPane.showMessageDialog(null, "帳號已被使用");
				} else if (!new ConsmerServiceImpl().isValidUsername(Username)) {
				    JOptionPane.showMessageDialog(null, "帳號格式錯誤");
				} else if (!new ConsmerServiceImpl().isValidPassword(Password)) {
				    JOptionPane.showMessageDialog(null, "密碼格式錯誤");
				} else if (!new ConsmerServiceImpl().isValidPhone(Phone)) {
				    JOptionPane.showMessageDialog(null, "電話格式錯誤");				
				}
				else {
					Consmer consmer = new Consmer(Name,Username,Password,Address,Phone, 1);
					new ConsmerServiceImpl().addConsmer(consmer);
					System.out.print("Yes");
					JOptionPane.showMessageDialog(null, "註冊成功！");
					ConsmerLoginUI consmerlogin= new ConsmerLoginUI();
					consmerlogin.setVisible(true);
					dispose();
					
				}
			}
		});
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBounds(262, 323, 78, 33);
		panel.add(btnNewButton);
		
		//****************返回按鈕***************
		
		JButton btnNewButton_1 = new JButton("返回");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ConsmerLoginUI consmerlogin= new ConsmerLoginUI();
				consmerlogin.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(10, 29, 78, 33);
		contentPane.add(btnNewButton_1);
		
		//**************時間*************
		
		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(363, 488, 173, 25);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}

}
