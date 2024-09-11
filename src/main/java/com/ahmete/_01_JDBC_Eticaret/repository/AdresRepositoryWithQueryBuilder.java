package com.ahmete._01_JDBC_Eticaret.repository;

import com.ahmete._01_JDBC_Eticaret.entity.Adres;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresRepositoryWithQueryBuilder implements ICrud<Adres> {
	String sql;
	private final DatabaseHelper databaseHelper;
	
	public AdresRepositoryWithQueryBuilder() {
		this.databaseHelper = new DatabaseHelper();
	}
	
	@Override
	public void save(Adres adres) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateInsert(adres,"tbladres"));
	}
	
	@Override
	public void delete(int silinecekAdresId) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateDelete(Adres.class, "tbladres", silinecekAdresId));
		
	}
	
	@Override
	public void update(Adres adres) {
		databaseHelper.executeUpdate(SQLQueryBuilder.generateUpdate(adres,"tbladres"));
		
	}
	
	@Override
	public List<Adres> findAll() {
		Optional<ResultSet> resultSet = databaseHelper.executeQuery("SELECT * FROM " +
				                                                            "tbladres " +
				                                                            "ORDER BY id");
		if(resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			return SQLQueryBuilder.generateList(Adres.class, "tbladres", rs);
		}
		return new ArrayList<>();
	}
	
	@Override
	public Optional<Adres> findById(int bulunacakAdresId) {
		sql = "SELECT * FROM tbladres WHERE id =" + bulunacakAdresId;
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		if (resultSet.isPresent()) {
			ResultSet rs = resultSet.get();
			return SQLQueryBuilder.findById(Adres.class, "tbladres", bulunacakAdresId, rs);
		}
		return Optional.empty();
	}
}