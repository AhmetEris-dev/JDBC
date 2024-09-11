package com.ahmete._01_JDBC_Eticaret.repository;

import com.ahmete._01_JDBC_Eticaret.entity.Musteri;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MusteriRepositoryWithQueryBuilder implements ICrud<Musteri> {
	String sql;
	private final DatabaseHelper databaseHelper;
	
	public MusteriRepositoryWithQueryBuilder() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Musteri musteri) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateInsert(musteri,"tblmusteriler"));
	}
	
	@Override
	public void delete(int silinecekAdresId) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateDelete(Musteri.class,"tblmusteriler",silinecekAdresId));
		
	}
	
	@Override
	public void update(Musteri musteri) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateUpdate(musteri,"tblmusteriler"));
		
	}
	
	@Override
	public List<Musteri> findAll() {
		Optional<ResultSet> resultSet = databaseHelper.executeQuery("SELECT * FROM " +
				                                                            "tblmusteriler " +
				                                                            "ORDER BY id");
		if(resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			return SQLQueryBuilder.generateList(Musteri.class, "tblmusteriler", rs);
		}
		return new ArrayList<>();
	}
	
	@Override
	public Optional<Musteri> findById(int bulunacakAdresId) {
		sql = "SELECT * FROM tblmusteriler WHERE id =" + bulunacakAdresId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		if (resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			return SQLQueryBuilder.findById(Musteri.class, "tblmusteriler", bulunacakAdresId, rs);
		}
		return Optional.empty();
	}
}