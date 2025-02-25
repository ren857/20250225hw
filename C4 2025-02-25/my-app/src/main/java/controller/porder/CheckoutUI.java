package controller.porder;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import model.Consmer;
import service.impl.PorderServiceImpl;
import util.ChangeCalculator;
import util.Clock;
import util.Tool;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckoutUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField money;
	private static Consmer consmer = (Consmer) Tool.read("consmer.txt");
	private PorderServiceImpl porderserviceimpl = new PorderServiceImpl();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CheckoutUI frame = new CheckoutUI();
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
	public CheckoutUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(28, 10, 481, 74);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("結帳");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel.setBounds(43, 5, 387, 59);
		panel.add(lblNewLabel);
		
		//****************列印按鈕*******************
		
		JButton btnNewButton_2 = new JButton("列印");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excel excel = new Excel();
				excel.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("新細明體", Font.BOLD, 14));
		btnNewButton_2.setBounds(396, 21, 75, 32);
		panel.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 118, 473, 217);
		contentPane.add(scrollPane);
		
		JTextArea output = new JTextArea();
		scrollPane.setViewportView(output);
		
		//********************總金額按鈕********************
		
		JButton btnNewButton = new JButton("總金額");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String orderDetails = porderserviceimpl.displayOrders(consmer.getName());
			System.out.println(consmer.getName());
			output.setText(orderDetails);
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.setBounds(46, 400, 85, 23);
		contentPane.add(btnNewButton);
		
		//********************付款按鈕*********************
		
		JButton btnNewButton_1 = new JButton("付款");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int total= porderserviceimpl.getTotalAmount();
				System.out.println(total);
				int Money=Integer.parseInt(money.getText());
				if ((Money - total) > 0) {
					String changeDetails = ChangeCalculator.calculateChange(Money - total);
					output.append(changeDetails);
					System.out.println("總金額: " + total + "元");
				}
			}
		});
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBounds(424, 427, 85, 23);
		contentPane.add(btnNewButton_1);
		
		money = new JTextField();
		money.setBounds(320, 401, 96, 21);
		contentPane.add(money);
		money.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("元");
		lblNewLabel_1.setFont(new Font("新細明體", Font.PLAIN, 15));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(424, 394, 47, 35);
		contentPane.add(lblNewLabel_1);
		
		//*****************時間*****************
		
		JLabel clock = new JLabel("New label");
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(371, 488, 165, 25);
		contentPane.add(clock);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
	}
}
