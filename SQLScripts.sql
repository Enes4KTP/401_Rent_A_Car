“SELECT * FROM AracBilgileri”
"INSERT into AracBilgileri(Marka,Model,Yıl,Plaka,Renk,Yakit_Tipi,Vites,Yas_Siniri,Fiyat,AracResim,KiralanmaDurumu) VALUES('"+getMarka()+"','"+getModel()+"','"+getYıl()+"','"+getPlaka()+"','"+getRenk()+"','"+getYakıtTipi()+"','"+getVites()+"','"+getYasSiniri()+"','"+getFiyat()+"','"+getResimURL()+"','"+laststatus +"')"
"Update AracBilgileri SET Marka=?,Model=?,Yıl=?,Plaka=?,Renk=?,Yakit_Tipi=?,Vites=?,Yas_Siniri=?,Fiyat=?,AracResim=? WHERE ID=?"
"SELECT * FROM AracBilgileri WHERE ID = '"+id+"'"
"INSERT into Sozlesmeler(Ad,Soyad,Tc_No,Dogum_Tarihi,Cinsiyet,Telefon_No,eMail,Adres,ehliyetTarih,Ehliyet_Tipi,DogumYeri,KefilAD,KefilSoyAD,KefilAdres,KiralamaTarih,TeslimTarihi,KefilTelefon,arabaID,TotalFiyat) VALUES('"+getAd()+"','"+getSoyad()+"','"+getTc_No()+"','"+getDogumTarih()+"','"+getCinsiyet()+"','"+getCepNo()+"','"+getMail()+"','"+getAdres()+"','"+getEhliyetTarih()+"','"+getEhliyetTip()+"','"+getDogumYeri()+"','"+getKefilAD()+"','"+getKefilSoyad()+"','"+getKefilAdres()+"','"+getIlktarih()+"','"+getSontarih()+"','"+getKefilcepNO()+"','"+getAracID()+"','"+getSonTutar()+"')"
"delete from Sozlesmeler Where ID=?"
"Update AracBilgileri SET KiralanmaDurumu=? WHERE ID=?"
"SELECT * FROM YoneticiBilgileri WHERE yoneticiAd = '" + username + "'and yoneticiSifre= '" + password+ "'"
