package com.ahmete._00_JDBC_Baslangic;

import java.sql.*;
/**
 * executeUpdate metodu ile INSERT,DELETE,UPDATE komutları calıştırıldı. Geriye int olarak etkilenen satır sayısını
 * dondu
 * exucuteQuery metodu ile SELECT komutu calıştırılır. Geriye resultSet döndü
 * execute metodu tum komutları calıştırılabilir
 */

public class Runner {
	public static void main(String[] args) throws SQLException {
//		adresEkle("İzmir","Bornova",3);
//		adresEkle("Bolu","Mengen",4);
//		adresEkle("Sakarya","Sapanca",5);

//		adresEklePrepared("Ankara","Mamak",6);
//		adresEklePrepared("Antalya","Manavgat",7);
//		adresEklePrepared("Isparta","Eğirdir",8);

//		adresSil(1020);

//		adresGuncelle("Izmir","Marmaris",1021);
		
		adresListele("fra");
	}
	
	private static void adresListele(String ilArg) {
		String ADRES_SELECT_SQL = "SELECT musteri_id,il,ilce FROM tbladres WHERE il ILIKE ?";
		// DİKKAT YAZIM DEĞİŞİKLİĞİ
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret?user=postgres&password=root";
		
		try (Connection connection = DriverManager.getConnection(connectionString);
		     PreparedStatement preparedStatement = connection.prepareStatement(ADRES_SELECT_SQL)) {
			preparedStatement.setString(1, "%" + ilArg + "%");
			// DİKKAT METOD DEĞİŞİKLİĞİ executeQuery kullandık. Select sorgularında dönen tabla sonuçlarını
			//ResultSet yapısında getiri
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
//				int musteriId = resultSet.getInt("musteri_id");
//				String il = resultSet.getString("il");
//				String ilce = resultSet.getString("ilce");
				
				//Eğer resultSet'in get metodlarında columnIndex vermek istersenşz,sorgunuzdan dönen tablodaki
				// kolonları 1'den başlayarak index numaralarını bulabiliriniz
				int musteriId = resultSet.getInt(1);
				String il = resultSet.getString(2);
				String ilce = resultSet.getString(3);
				
				System.out.println("Müşteri id: " + musteriId + " il: " + il + " ilce: " + ilce);
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("while döngüsü bitti");
	}
	
	private static void adresGuncelle(String yeniIl, String yeniIlce, int id) {
		String ADRES_UPDATE_SQL = "UPDATE tbladres SET  il=?, ilce=? WHERE id=?;";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username = "postgres";
		String password = "root";
		
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
		     PreparedStatement preparedStatement = connection.prepareStatement(ADRES_UPDATE_SQL)) {
			
			preparedStatement.setString(1, yeniIl);
			preparedStatement.setString(2, yeniIlce);
			preparedStatement.setInt(3, id);
			
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if (etkilenenSatirSayisi > 0) {
				System.out.println(etkilenenSatirSayisi + "  Kayıt başarı ile guncellendi");
			}
			else {
				System.out.println("Guncellemede sorun yaşandı");
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	private static void adresEkle(String il, String ilce, int musteri_id) throws SQLException {
		String ADRES_INSERT_SQL =
				"INSERT INTO public.tbladres( il, ilce, musteri_id) VALUES ('" + il + "', '" + ilce + "', " + musteri_id + ")";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username = "postgres";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(connectionString, username, password);
		PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL);
		int etkilenenSatirSayisi = preparedStatement.executeUpdate();
		if (etkilenenSatirSayisi > 0) {
			System.out.println("Kayıt başarı ile eklendi");
		}
		else {
			System.out.println("Kaydetmede sorun yaşandı");
		}
		connection.close();
		
	}
	
	private static void adresEklePrepared(String il, String ilce, int musteri_id) {
		String ADRES_INSERT_SQL = "INSERT INTO public.tbladres( il, ilce, musteri_id) VALUES (?,?,?)";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username = "postgres";
		String password = "root";
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
		     PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL)) {
			preparedStatement.setString(1, il);
			preparedStatement.setString(2, ilce);
			preparedStatement.setInt(3, musteri_id);
			
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if (etkilenenSatirSayisi > 0) {
				System.out.println("Kayıt başarı ile eklendi");
			}
			else {
				System.out.println("Kaydetmede sorun yaşandı");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static void adresSil(int idArg) {
		String ADRES_INSERT_SQL = "DELETE FROM tbladres WHERE id=?";
		String connectionString = "jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username = "postgres";
		String password = "root";
		try (Connection connection = DriverManager.getConnection(connectionString, username, password);
		     PreparedStatement preparedStatement = connection.prepareStatement(ADRES_INSERT_SQL)) {
			preparedStatement.setInt(1, idArg);
			
			int etkilenenSatirSayisi = preparedStatement.executeUpdate();
			if (etkilenenSatirSayisi > 0) {
				System.out.println(etkilenenSatirSayisi + " adet Kayıt başarı ile silindi");
			}
			else {
				System.out.println("Silmede sorun yaşandı");
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}