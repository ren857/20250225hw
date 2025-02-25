package util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import model.Hw;
import model.SalesRecord;

import java.io.*;
import java.sql.*;
import java.util.*;

public class DBExcel {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
	private static final String DB_USER = "root";
	private static final String DB_PASSWORD = "1234";

	public static void main(String[]args) {
			System.out.println(DBExcel.fetchSalesData());
	}	
			// 讀取 MySQL 數據
	public static List<Hw> fetchSalesData() {
		List<Hw> salesList = new ArrayList<>();
		String query = "SELECT consmername, consmerID, phone, address, employeename, productname, amount, price, sum  FROM hw5.hw ORDER BY consmername, consmerID ";
		try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			while (rs.next()) {
				salesList.add(new Hw(rs.getString("consmername"), rs.getInt("consmerID"), rs.getString("phone"),
						rs.getString("address"), rs.getString("employeename"), rs.getString("productname"),
						rs.getInt("amount"), rs.getInt("price"), rs.getInt("sum")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return salesList;
	}

	// 導出到 Excel
	public static void exportToExcel(List<Hw> hw, String filePath) {
		try (Workbook workbook = new XSSFWorkbook(); FileOutputStream fileOut = new FileOutputStream(filePath)) {

			Sheet sheet = workbook.createSheet("hw");
			Row headerRow = sheet.createRow(0);
			String[] header = { "consmername", "consmerID", "phone", "address", "employeename", "productname", "amount",
					"price", "sum" };
			for (int i = 0; i < header.length; i++) {
				Cell cell = headerRow.createCell(i);
				cell.setCellValue(header[i]);
			}
			int rowNum = 1;
			for (Hw h : hw) {
				Row row = sheet.createRow(rowNum++);
				row.createCell(0).setCellValue(h.getConsmername());
				row.createCell(1).setCellValue(h.getConsmerID());
				row.createCell(2).setCellValue(h.getPhone());
				row.createCell(3).setCellValue(h.getAddress());
				row.createCell(4).setCellValue(h.getEmployeename());
				row.createCell(5).setCellValue(h.getProductname());
				row.createCell(6).setCellValue(h.getAmount());
				row.createCell(7).setCellValue(h.getPrice());
				row.createCell(8).setCellValue(h.getSum());

			}
			workbook.write(fileOut);
			System.out.println("Excel 文件已保存：" + filePath);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
