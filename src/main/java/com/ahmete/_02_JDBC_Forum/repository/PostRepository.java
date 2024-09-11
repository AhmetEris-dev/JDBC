package com.ahmete._02_JDBC_Forum.repository;

import com.ahmete._02_JDBC_Forum.entity.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PostRepository implements ICRUD<Post> {
	private final DatabaseHelper databaseHelper;
	private String sql;
	
	public PostRepository() {
		this.databaseHelper = new DatabaseHelper();
	}
	@Override
	public void save(Post post) {
		sql = "INSERT INTO tblpost (user_id,baslik,icerik,paylasimtarihi) VALUES (%d,'%s','%s','%s')"
				.formatted(post.getUserId(),post.getBaslik(),post.getIcerik(),post.getPaylasimTarihi());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void delete(int silinecekPostId) {
		sql="DELETE FROM tblpost WHERE id="+silinecekPostId;
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public void update(Post post) {
		sql=("UPDATE tblpost SET user_id=%d, baslik='%s',icerik='%s', paylasimtarihi='%s' WHERE id=%d")
				.formatted(post.getUserId(),post.getBaslik(),post.getIcerik(),post.getPaylasimTarihi(),post.getId());
		databaseHelper.executeUpdate(sql);
	}
	
	@Override
	public List<Post> findAll() {
		sql="SELECT * FROM tbluser ORDER BY id ";
		Optional<ResultSet> resultSet = databaseHelper.executeQuery(sql);
		List<Post> postList = new ArrayList<>();
		try {
			if (resultSet.isPresent()) {
				ResultSet rs = resultSet.get();
				while (rs.next()){
					
					postList.add(getValueFromResultSet(rs));
				}
			}
		}
		catch (SQLException e) {
			System.out.println("User listesi getirirken bir sorun yaşandı... "+e.getMessage());
		}
		return postList;
	}
	
	
	@Override
	public Optional<Post> findById(int bulunacakPostId) {
		sql="SELECT * FROM tblpost WHERE id="+bulunacakPostId;
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
	
	
	private Post getValueFromResultSet(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		int userId = rs.getInt("user_id");
		String baslik = rs.getString("baslik");
		String icerik = rs.getString("icerik");
		String paylasimTarihi = rs.getString("paylasimtarihi");
		Integer state = rs.getInt("state");
		Long createat = rs.getLong("createat");
		Long updateat= rs.getLong("updateat");
		
		return new Post(id, userId, baslik, icerik, LocalDate.parse(paylasimTarihi), state, createat, updateat);
	}
}