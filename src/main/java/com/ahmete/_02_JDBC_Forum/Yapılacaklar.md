*****************
Java15 Forum
*****************
1- Register Ol
2- Giris Yap

Database adı:Java15ForumDB
Tablo adı: User
1. entity package içinde User(id,ad,soyad,username(Unique),password) adında bir class acalım
2. register işlemi sırasında username'in daha önce alınıp alınmadığı kontrol edilmeli
**********
* Register *
**********
3. Adınızı giriniz:
4. Soyadınızı giriniz:
5. Username giriniz:
6. Password giriniz
7. UserRepository hazırlamalısınız Temel crud işlemleri olmalı Extra olarak:
  - boolean existsByUserName(String username)
  - Optional<USER> doLogin(String username,String password)
**********
* Login *
**********
Giris Yap:
  - Username giriniz:
  - password giriniz:
  - Eğer giriş bilgileri doğru ise o zaman başka bir ekrana geçiş yapsın 

MainController

********************
Hoşgeldin, Ad Soyad
********************
1-Post görüntüle
2-Post Paylaş
3-kendi poslarını görüntüle
4-Kullanıcıları listele
5-Logout

Yapılacaklar:
Entity kısmında Post(id,userId,baslik,icerik,paylasimTarihi)
PostRepository(Crud islemleri)


CREATE TABLE tbluser
(
id serial PRIMARY KEY,
ad varchar(50),
soyad varchar(50),
username varchar(50) UNIQUE,
password varchar(15),
state INTEGER DEFAULT 1,
createat int DEFAULT EXTRACT(epoch FROM now()),
updateat int DEFAULT EXTRACT(epoch FROM now())
)

CREATE TABLE tblpost
(
id serial PRIMARY KEY,
user_id INTEGER NOT NULL REFERENCES tbluser(id),
baslik varchar(150),
icerik text,
paylasimTarihi date,
state INTEGER DEFAULT 1,
createat int DEFAULT EXTRACT(epoch FROM now()),
updateat int DEFAULT EXTRACT(epoch FROM now())
)