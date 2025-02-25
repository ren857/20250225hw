package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ConsmerDao;
import model.Consmer;
import util.DbConnection;

public class ConsmerDaoImpl implements ConsmerDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Connection conn = DbConnection.getDb();

	@Override
	public void add(Consmer consmer) {

		String SQL = "insert into consmer(name,username,password,phone,address)" + "values(?,?,?,?,?)";

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(SQL);
			preparedstatement.setString(1, consmer.getName());
			preparedstatement.setString(2, consmer.getUsername());
			preparedstatement.setString(3, consmer.getPassword());
			preparedstatement.setString(4, consmer.getPhone());
			preparedstatement.setString(5, consmer.getAddress());

			preparedstatement.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<Consmer> selectAll() {
		String aql = "select*from consmer";
		List<Consmer> l = new ArrayList<>();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(aql);
			ResultSet resultset = preparedstatement.executeQuery();

			while (resultset.next()) {
				Consmer c = new Consmer();
				c.setConsmerID(resultset.getInt("consmerID"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setPhone(resultset.getString("phone"));
				c.setAddress(resultset.getString("address"));
				l.add(c);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return l;
	}

	@Override
	public List<Consmer> selectUsernameAndPassword(String username, String password) {
		String sql = "select*from consmer where username=? and password=?";
		List<Consmer> l = new ArrayList<>();

		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			preparedstatement.setString(2, password);
			ResultSet resultset = preparedstatement.executeQuery();

			if (resultset.next()) {
				Consmer c = new Consmer();
				c.setConsmerID(resultset.getInt("consmerID"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setPhone(resultset.getString("phone"));
				c.setAddress(resultset.getString("address"));

				l.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

	@Override
	public List<Consmer> selectByUsername(String username) {
		String sql = "select * from consmer where username=?";
		List<Consmer> l = new ArrayList<>();
		try {
			PreparedStatement preparedstatement = conn.prepareStatement(sql);
			preparedstatement.setString(1, username);
			ResultSet resultset = preparedstatement.executeQuery();
			if (resultset.next()) {
				Consmer c = new Consmer();
				c.setConsmerID(resultset.getInt("consmerID"));
				c.setName(resultset.getString("name"));
				c.setUsername(resultset.getString("username"));
				c.setPassword(resultset.getString("password"));
				c.setPhone(resultset.getString("phone"));
				c.setAddress(resultset.getString("address"));
				l.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return l;
	}

//	public Integer selectByName(String name) {
//		String sql = "SELECT consmerID FROM consmer WHERE name = ?";
//		Integer consmerID = null;
//
//		try {
//			PreparedStatement preparedstatement = conn.prepareStatement(sql);
//			ResultSet resultset = preparedstatement.executeQuery();
//			preparedstatement.setString(1, name);
//
//			if (resultset.next()) {
//				consmerID = resultset.getInt("consmerID");
//
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return consmerID;
//
//	}
}
