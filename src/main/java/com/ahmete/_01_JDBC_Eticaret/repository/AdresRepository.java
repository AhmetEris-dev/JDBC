package com.ahmete._01_JDBC_Eticaret.repository;

import com.ahmete._01_JDBC_Eticaret.entity.Adres;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AdresRepository implements ICrud<Adres> {
	private final DatabaseHelper databaseHelper;
	private String sql;
	
	public AdresRepository() {
		this.databaseHelper =new DatabaseHelper();
		
	}
	
	@Override
	public void save(Adres adres) {
		sql = "INSERT INTO tbladres(musteri_id,il,ilce,mahalle,adres) VALUES (%d,'%s','%s','%s','%s')"
				.formatted(adres.getMusteri_id(),adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int silinecekAdresId) {
		sql="DELETE FROM tbladres WHERE id="+silinecekAdresId;
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(Adres adres) {
		sql=("UPDATE tbladres SET il='%s', ilce='%s', mahalle='%s', adres='%s' WHERE id=%d")
				.formatted(adres.getIl(),adres.getIlce(),adres.getMahalle(),adres.getAdres(),adres.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Adres> findAll() {
		sql="SELECT * FROM tbladres ORDER BY id DESC";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Adres> adresList = new ArrayList<>();
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				while (rs.next()){
					
					adresList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("Adres listesi getirirken bir sorun yaşandı... "+e.getMessage());
		}
		return adresList;
	}
	
	@Override
	public Optional<Adres> findById(int bulunacakAdresId) {
		sql="SELECT * FROM tbladres WHERE id="+bulunacakAdresId;
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
			System.out.println("Adres bulmada sorun yaşando... "+e.getMessage());
			return Optional.empty();
		}
		return Optional.empty();
	}
	
	
	
	private Adres getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		Integer musteri_id = rs.getInt("musteri_id");
		String il = rs.getString("il");
		String ilce = rs.getString("ilce");
		String mahalle = rs.getString("mahalle");
		String adres = rs.getString("adres");
		Integer state = rs.getInt("state");
		Long createat = rs.getLong("createat");
		Long updateat= rs.getLong("updateat");
		
		return new Adres(id,musteri_id,il,ilce,mahalle,adres,state, createat, updateat, id);
		
	}
}