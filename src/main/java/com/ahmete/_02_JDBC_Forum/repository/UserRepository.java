package com.ahmete._02_JDBC_Forum.repository;



import com.ahmete._01_JDBC_Eticaret.entity.Musteri;
import com.ahmete._02_JDBC_Forum.entity.User;
import com.ahmete._02_JDBC_Forum.repository.DatabaseHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository implements ICRUD<User> {
	private final DatabaseHelper databaseHelper;
	private String sql;
	
	public UserRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	
	@Override
	public void save(User user) {
		sql = "INSERT INTO tbluser (ad,soyad,username,password) VALUES ('%s','%s','%s','%s')"
				.formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int silinecekUserid) {
		sql="DELETE FROM tbluser WHERE id="+silinecekUserid;
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(User user) {
		sql=("UPDATE tlbuser SET ad='%s', soyad='%s',username='%s', password='%s' WHERE id=%d")
				.formatted(user.getAd(), user.getSoyad(), user.getUsername(), user.getPassword(), user.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<User> findAll() {
		sql="SELECT * FROM tbluser ORDER BY id ";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<User> userList = new ArrayList<>();
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				while (rs.next()){
					
					userList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("User listesi getirirken bir sorun yaşandı... "+e.getMessage());
		}
		return userList;
	}
	
	@Override
	public Optional<User> findById(int bulunacakUserId) {
		sql="SELECT * FROM tbluser WHERE id="+bulunacakUserId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				if (rs.next()){
					
					return Optional.of(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("User bulmada sorun yaşando... "+e.getMessage());
			return Optional.empty();
		}
		return Optional.empty();
	}
	public boolean existsByUserName(String username) {
		sql = "SELECT * FROM tbluser WHERE username = '%s'".formatted(username);
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try {
			if (resultSet.isPresent()) {
				return resultSet.get().next();
			}
		} catch (SQLException e) {
			System.out.println("Username kontrolü sırasında hata oluştu... " + e.getMessage());
		}
		return false;
	}
	
	public Optional<User> doLogin(String username, String password) {
		sql = "SELECT * FROM tbluser WHERE username = '%s' AND password = '%s'"
				.formatted(username, password);
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				if (rs.next()) {
					return Optional.of(getValueFromResultSet(rs)); // Doğru bilgilerse kullanıcıyı döndür
				}
			}
		} catch (SQLException e) {
			System.out.println("Login sırasında hata oluştu... " + e.getMessage());
		}
		return Optional.empty();
	}
	
	private User getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String ad = rs.getString("ad");
		String soyad = rs.getString("soyad");
		String username = rs.getString("username");
		String password = rs.getString("password");
		Integer state = rs.getInt("state");
		Long createat = rs.getLong("createat");
		Long updateat= rs.getLong("updateat");
		
		return new User(id,ad,soyad,username,password,state,createat,updateat);
	}
	
	
}