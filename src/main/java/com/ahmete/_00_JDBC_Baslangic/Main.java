package com.ahmete._00_JDBC_Baslangic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
	public static void main(String[] args) throws SQLException {
		//Connection String - Bağlantı cümlesi oluşturma
		String connectionString="jdbc:postgresql://localhost:5432/Java15ETicaret";
		String username="postgres";
		String password="root";
		
		// Parametrelerle Connection nesnesi yaratmak için DriverManager sınıfının getConnection metodu kullandık
		Connection connection = DriverManager.getConnection(connectionString, username, password);
		
		//String bir ifade içinde basit bir SQL komutu yazalım:
		String sqlkomut="INSERT INTO public.tbladres( il, ilce, musteri_id)VALUES ('Londra', 'Soho', 2)";
		
		//String bir sorgu direkt olarak connection nesnesi aracılığıyla calıştırılamaz!
		//bunun için öncelikle bu komutun hazırlanması lazım
		
		PreparedStatement preparedStatement = connection.prepareStatement(sqlkomut);
		//Bu islem sonucunda artık SQL ifadesi calıştırılabilir hale gelmiştir
		preparedStatement.executeUpdate(); // bu adım sorgumuzun vt serverinda calıştırılmasını sağlar
		
		connection.close(); //connection işlemler bittikten sonra kapatılmalıdır.
	}
	
	
}