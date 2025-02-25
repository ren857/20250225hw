package controller.porder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JOptionPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import dao.impl.PorderDaoImpl;
import dao.impl.ProductDaoImpl;
import model.Consmer;
import model.Employee;
import model.Porder;
import model.Product;
import util.Clock;
import util.Tool;
import java.awt.Component;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPorderUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	DefaultTableModel model;
	private JTable table;
	private static Consmer consmer = (Consmer) Tool.read("consmer.txt");
	private JTextField textField;
	private JComboBox<Product> comboBox;
	private static ProductDaoImpl productdaoimpl = new ProductDaoImpl();
	private static PorderDaoImpl porderdaoimpl = new PorderDaoImpl();
	private static Employee employee = (Employee) Tool.read("employee.txt");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPorderUI frame = new AddPorderUI();
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
	public AddPorderUI() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 550);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 526, 67);
		panel.setBackground(new Color(128, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("八辣好吃水果行");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(46, 10, 433, 52);
		panel.add(lblNewLabel);
		model = new DefaultTableModel();

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(237, 120, 289, 340);

		contentPane.add(scrollPane);
		
		//****************JTable表格*******************
		
		table = new JTable();
		model = new DefaultTableModel();
		Object[] column = { "訂單", "顧客", "商品", "數量", "單價", "總價" };
		// Object[] row = new Object[4];
		model.setColumnIdentifiers(column);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		//*****************選擇商品*********************
		
		comboBox = new JComboBox<>();
		List<Product> productList = productdaoimpl.selectAll();
		for (Product p : productList) {
			comboBox.addItem(p);
		}
		comboBox.setRenderer((list, value, index, isSelected, cellHasFocus) -> {
			JLabel label = new JLabel(value.getProductname() + " - " + value.getPrice() + "元");
			return label;
		});

		comboBox.setBounds(111, 176, 92, 30);
		contentPane.add(comboBox);
		
		//*****************新增按鈕****************
		
		JButton btnNewButton = new JButton("ADD");
		btnNewButton.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				if (comboBox.getSelectedItem() == null) {
					JOptionPane.showMessageDialog(null, "請選擇一個商品");
					return;
				}

				Product selectedProduct = (Product) comboBox.getSelectedItem();

				if (textField.getText().trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "請輸入數量");
					return;
				}

				try {
					// 取得輸入的數量並進行轉換
					int amount = Integer.parseInt(textField.getText().trim());

					if (amount <= 0) {
						JOptionPane.showMessageDialog(null, "數量必須大於零");
						return;
					}

					int consmerId = consmer.getConsmerID(); // 從 Consmer 類別中獲取 ID
					int productId = selectedProduct.getProductID(); // 從 Product 類別中獲取 ID
					int employeeId = employee.getEmployeeID(); // 假設你有一個 Employee 物件
					int totalPrice = selectedProduct.getPrice() * amount;
					Porder porder = new Porder(consmerId, productId, employeeId, amount);
					porderdaoimpl.addporder(porder);

					Object[] row = new Object[6];
					row[0] = porderdaoimpl.queryporderID();
					row[1] = consmer.getName();
					row[2] = selectedProduct.getProductname();
					row[3] = amount;
					row[4] = selectedProduct.getPrice();
					row[5] = totalPrice; // 將總價放入此欄位

					model.addRow(row);
					JOptionPane.showMessageDialog(null, "訂單已成功加入！");
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "請輸入有效的數量");
				}

			}

		});

		btnNewButton.setBounds(10, 330, 86, 23);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("商品:");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1.setBounds(10, 176, 75, 35);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(95, 248, 65, 28);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_1_1 = new JLabel("數量:");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1.setBounds(10, 248, 75, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("顆");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setFont(new Font("新細明體", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(152, 248, 75, 35);
		contentPane.add(lblNewLabel_1_1_1);
		
		//********************調整按鈕*********************
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("新細明體", Font.BOLD, 12));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int amount = Integer.parseInt(textField.getText().trim());
				if (amount <= 0) {
					JOptionPane.showMessageDialog(null, "數量必須大於零");
					return;
				}
				Product selectedProduct = (Product) comboBox.getSelectedItem();
				int consmerId = consmer.getConsmerID(); // 從 Consmer 類別中獲取 ID
				int productId = selectedProduct.getProductID(); // 從 Product 類別中獲取 ID
				int employeeId = employee.getEmployeeID(); // 假設你有一個 Employee 物件
				int totalPrice = selectedProduct.getPrice() * amount;
				int row = table.getSelectedRow(); // 選中的列
				// int porderId = (int) model.getValueAt(row, 0);
				int porderId = (int) table.getValueAt(row, 0);
				int i = table.getSelectedRow();

				model.setValueAt(selectedProduct.getProductname(), i, 2);
				model.setValueAt(textField.getText(), i, 3);
				model.setValueAt(selectedProduct.getPrice(), i, 4);
				model.setValueAt(totalPrice, i, 5);

				Porder porder = new Porder(consmerId, productId, employeeId, amount, porderId);
				porderdaoimpl.update(porder);

			}
		});
		btnUpdate.setBounds(123, 330, 92, 23);
		contentPane.add(btnUpdate);
		
		//***************** 刪除按鈕 *******************
		
		JButton btnDelete = new JButton("delete");
		btnDelete.setFont(new Font("新細明體", Font.BOLD, 12));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int i = table.getSelectedRow();
				int porderId = porderdaoimpl.queryporderID();

				if (i >= 0) {

					model.removeRow(i);
					porderdaoimpl.delete(porderId);
				} else {
					JOptionPane.showMessageDialog(null, "請選取欄位");
				}

			}
		});
		btnDelete.setBounds(10, 383, 92, 23);
		contentPane.add(btnDelete);

		// *******************結帳按鈕********************

		JButton btnNewButton_1 = new JButton("結帳");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckoutUI checkout = new CheckoutUI();
				checkout.setVisible(true);
				dispose();
			}
		});

		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("新細明體", Font.BOLD, 12));
		btnNewButton_1.setBounds(413, 87, 85, 23);
		contentPane.add(btnNewButton_1);

		// *******************時間 *********************

		JLabel clock = new JLabel("New label");
		clock.setHorizontalAlignment(SwingConstants.CENTER);
		clock.setFont(new Font("新細明體", Font.BOLD, 14));
		clock.setBounds(373, 488, 163, 25);
		Timer timer = new Timer(1000, e -> Clock.updateDateTime(clock));
		timer.start();
		contentPane.add(clock);

		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(
				new Component[] { panel, lblNewLabel, table, scrollPane, comboBox, lblNewLabel_1, textField,
						lblNewLabel_1_1, lblNewLabel_1_1_1, btnUpdate, btnDelete, btnNewButton_1, clock }));

	}
}
