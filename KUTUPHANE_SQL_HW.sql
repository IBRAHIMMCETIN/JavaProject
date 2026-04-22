--DDL

--DATABASE OLUŞTURMA
--CREATE DATABASE KUTUPHANE_SQL_HW;(MANUEL OLARAK OLUŞTURDUĞUM İÇİN YORUM SATIRINA ALDIM)


--TABLOLARI OLUŞTURMA

--TÜRLER TABLOSU
CREATE TABLE turler(

	tur_id SERIAL PRIMARY KEY,
	tur_adi VARCHAR(30) NOT NULL

);

--YAZARLAR TABLOSU
CREATE TABLE yazarlar(

	yazar_id SERIAL PRIMARY KEY,
	yazar_adi VARCHAR(100) NOT NULL,
	yazar_soyadi VARCHAR(100) NOT NULL
	
);

--ÖĞRENCİLER TABLOSU
CREATE TABLE ogrenciler(

	ogrenci_id SERIAL PRIMARY KEY,
	ogrenci_adi VARCHAR(100) NOT NULL,
	ogrenci_soyadi VARCHAR(100) NOT NULL,
	ogrenci_bolum VARCHAR(100) NOT NULL,
	ogrenci_tel VARCHAR(14) NOT NULL
	
);

--GÖREVLİLER TABLOSU
CREATE TABLE gorevliler(

	gorevli_id SERIAL PRIMARY KEY,
	gorevli_adi VARCHAR(100) NOT NULL,
	gorevli_soyadi VARCHAR(100) NOT NULL,
	gorevli_email VARCHAR(100) NOT NULL,
	password VARCHAR(100) NOT NULL
	
);

--KİTAPLAR TABLOSU
CREATE TABLE kitaplar(

	kitap_id SERIAL PRIMARY KEY,
	ISBN VARCHAR(100) NOT NULL,
	yayin_yili TIMESTAMP NOT NULL,
	tur_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (tur_id) REFERENCES turler(tur_id),
	yazar_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (yazar_id) REFERENCES yazarlar(yazar_id)
	
);

--ÖDÜNÇ TABLOSU
CREATE TABLE odunc(

	odunc_id SERIAL PRIMARY KEY,
	alinan_tarih TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	son_teslim_tarihi TIMESTAMP DEFAULT (CURRENT_TIMESTAMP + INTERVAL '30 days'),
	kitap_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (kitap_id) REFERENCES kitaplar(kitap_id),
	ogrenci_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (ogrenci_id) REFERENCES ogrenciler(ogrenci_id),
	gorevli_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (gorevli_id) REFERENCES gorevliler(gorevli_id)
);

--İADE TABLOSU
CREATE TABLE iade(

	iade_id SERIAL PRIMARY KEY,
	iade_tarihi TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
	odunc_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (odunc_id) REFERENCES odunc(odunc_id)
);

--CEZALAR TABLOSU
CREATE TABLE ceza(
	
	ceza_id SERIAL PRIMARY KEY,
	ceza_tutari INTEGER,
	iade_id INTEGER UNIQUE NOT NULL,
	FOREIGN KEY (iade_id) REFERENCES iade(iade_id)
	
);

--TABLOLARA KOLON EKLEME
ALTER TABLE ogrenciler ADD COLUMN ogrenci_mail VARCHAR(20);
ALTER TABLE ogrenciler ALTER COLUMN ogrenci_mail SET NOT NULL;


ALTER TABLE gorevliler ADD COLUMN gorevli_gsm VARCHAR(20);
ALTER TABLE gorevliler ALTER COLUMN gorevli_gsm SET NOT NULL;

--DML

--TABLOLAR İÇİN ÜÇER INSERT

-- TURLER INSERT
INSERT INTO turler (tur_adi) VALUES ('Roman'), ('Bilim Kurgu'), ('Tarih');

-- YAZARLAR INSERT
INSERT INTO yazarlar (yazar_adi, yazar_soyadi) VALUES 
('Fyodor', 'Dostoyevski'), 
('Isaac', 'Asimov'), 
('İlber', 'Ortaylı');

-- ÖĞRENCİLER INSERT 
INSERT INTO ogrenciler (ogrenci_adi, ogrenci_soyadi, ogrenci_bolum, ogrenci_tel, ogrenci_mail) VALUES 
('Ahmet', 'Yılmaz', 'Bilgisayar Mühendisliği', '05551112233', 'ahmet@mail.com'),
('Ayşe', 'Demir', 'Hukuk', '05442223344', 'ayse@mail.com'),
('Mehmet', 'Can', 'İşletme', '05334445566', 'mehmet@mail.com');

-- GÖREVLİLER INSERT 
INSERT INTO gorevliler (gorevli_adi, gorevli_soyadi, gorevli_email, password, gorevli_gsm) VALUES 
('Caner', 'Berk', 'caner@kutuphane.com', '123456', '05051112233'),
('Selin', 'Gün', 'selin@kutuphane.com', 'sifre789', '05062223344'),
('Mert', 'Ege', 'mert@kutuphane.com', 'mert123', '05073334455');

-- KİTAPLAR INSERT
INSERT INTO kitaplar (ISBN, yayin_yili, tur_id, yazar_id) VALUES 
('978605332', '1866-01-01 00:00:00', 1, 1), -- Suç ve Ceza
('978975210', '1951-01-01 00:00:00', 2, 2), -- Vakıf
('978605092', '2015-01-01 00:00:00', 3, 3); -- Türklerin Tarihi

-- ÖDÜNÇ INSERT
INSERT INTO odunc (kitap_id, ogrenci_id, gorevli_id) VALUES 
(1, 1, 1),
(2, 2, 2),
(3, 3, 3);

-- İADE INSERT
INSERT INTO iade (odunc_id) VALUES (1), (2), (3);

-- CEZALAR INSERT
INSERT INTO ceza (ceza_tutari, iade_id) VALUES 
(50, 1),
(0, 2),
(20, 3);

UPDATE ogrenciler SET ogrenci_mail = 'ayse.yeni@mail.com', ogrenci_tel = '05009998877' WHERE ogrenci_id = 2;

DELETE FROM ceza WHERE ceza_id = 3;

SELECT gorevli_adi, gorevli_soyadi, gorevli_email FROM gorevliler;

SELECT * FROM odunc ORDER BY alinan_tarih DESC;

SELECT SUM(ceza_tutari) AS toplam_kutuphane_geliri FROM ceza;












