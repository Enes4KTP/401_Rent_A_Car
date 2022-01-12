import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class SozlesmeIslemleri implements lConnection<SozlesmeIslemleri> {
	private String ad;
	private String soyad;
	private String tc_No;
	private String dogumTarih;
	private String dogumYeri;
	private String cinsiyet;
	private String cepNo;
	private String mail;
	private String adres;
	private String ehliyetTarih;
	private String ehliyetTip;
	private String kefilAD;
	private String kefilSoyad;
	private String kefilAdres;
	private String kefilcepNO;
	private String ilktarih;
	private String sontarih;
	private double sonTutar;
	private String aracID;
	private int kullaniciID;
	private int kalanGun;
	
	public int getKalanGun() {
		return kalanGun;
	}

	public void setKalanGun(int kalanGun) {
		this.kalanGun = kalanGun;
	}

	public int getKullaniciID() {
		return kullaniciID;
	}

	public void setKullaniciID(int kulID) {
		this.kullaniciID = kulID;
	}

	public String Status="Kiralandý";
	public String Status1="Kiralanmadý";
	
	public String getAd() {
		return ad;
	}

	public void setAd(String ad) {
		this.ad = ad;
	}

	public String getSoyad() {
		return soyad;
	}

	public void setSoyad(String soyad) {
		this.soyad = soyad;
	}

	public String getTc_No() {
		return tc_No;
	}

	public void setTc_No(String tc_No) {
		this.tc_No = tc_No;
	}

	public String getDogumTarih() {
		return dogumTarih;
	}

	public void setDogumTarih(String dogumTarih) {
		this.dogumTarih = dogumTarih;
	}

	public String getDogumYeri() {
		return dogumYeri;
	}

	public void setDogumYeri(String dogumYeri) {
		this.dogumYeri = dogumYeri;
	}

	public String getCinsiyet() {
		return cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}

	public String getCepNo() {
		return cepNo;
	}

	public void setCepNo(String cepNo) {
		this.cepNo = cepNo;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getEhliyetTarih() {
		return ehliyetTarih;
	}

	public void setEhliyetTarih(String ehliyetTarih) {
		this.ehliyetTarih = ehliyetTarih;
	}

	public String getEhliyetTip() {
		return ehliyetTip;
	}

	public void setEhliyetTip(String ehliyetTip) {
		this.ehliyetTip = ehliyetTip;
	}

	public String getKefilAD() {
		return kefilAD;
	}

	public void setKefilAD(String kefilAD) {
		this.kefilAD = kefilAD;
	}

	public String getKefilSoyad() {
		return kefilSoyad;
	}

	public void setKefilSoyad(String kefilSoyad) {
		this.kefilSoyad = kefilSoyad;
	}

	public String getKefilAdres() {
		return kefilAdres;
	}

	public void setKefilAdres(String kefilAdres) {
		this.kefilAdres = kefilAdres;
	}

	public String getKefilcepNO() {
		return kefilcepNO;
	}

	public void setKefilcepNO(String kefilcepNO) {
		this.kefilcepNO = kefilcepNO;
	}

	public String getIlktarih() {
		return ilktarih;
	}

	public void setIlktarih(String ilktarih) {
		this.ilktarih = ilktarih;
	}

	public String getSontarih() {
		return sontarih;
	}

	public void setSontarih(String sontarih) {
		this.sontarih = sontarih;
	}

	public double getSonTutar() {
		return sonTutar;
	}

	public void setSonTutar(double sonTutar) {
		this.sonTutar = sonTutar;
	}

	public String getAracID() {
		return aracID;
	}

	public void setAracID(String aracID) {
		this.aracID = aracID;
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public Connection connection;
	
	
	public SozlesmeIslemleri() 
	{
		
	}
	public SozlesmeIslemleri(int kalangun) 
	{
		setKalanGun(kalangun);
	}
	public SozlesmeIslemleri(int kullanici_Id,String arac_Id) 
	{
		setKullaniciID(kullanici_Id);
		setAracID(arac_Id);
	}
	public SozlesmeIslemleri(int kulID,String ilk_tarih,String son_tarih,String arac_ID)
	{
		setKullaniciID(kulID);
		setIlktarih(ilk_tarih);
		setSontarih(son_tarih);
		setAracID(arac_ID);

	}
	public SozlesmeIslemleri(String Ad, String Soyad, String tc_No, String DogumTarih, String DogumYeri, String Cinsiyet,
			String cepNo, String mail, String adres,String ehliyetTarih, String ehliyetTip, String kefilAd, String kefilSoyad, String kefilAdres,
			String kefilcepno,  String date, String date2, double Tutar, String aracID) {
		// TODO Auto-generated constructor stub
		setAd(Ad);
		setSoyad(Soyad);
		setTc_No(tc_No);
		setDogumTarih(DogumTarih);
		setCinsiyet(Cinsiyet);
		setCepNo(cepNo);
		setMail(mail);
		setAdres(adres);
		setEhliyetTarih(ehliyetTarih);
		setEhliyetTarih(ehliyetTip);
		setKefilAD(kefilAd);
		setKefilSoyad(kefilSoyad);
		setKefilAdres(kefilAdres);
		setKefilcepNO(kefilcepno);
		setIlktarih(date);
		setSontarih(date2);
		setSonTutar(Tutar);
		setAracID(aracID);
		setEhliyetTip(ehliyetTip);
		setDogumYeri(DogumYeri);
	}
	
	public SozlesmeIslemleri(String aracIDGuncelle)
	{
		setAracID(aracID);
	}

	@Override
	public void acDataBaseOpen() {
		// TODO Auto-generated method stub
		try {
			connection= DriverManager.getConnection(databaseURL);
			System.out.println("DataBase ile iletiþim baþlatýldý.");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	@Override
	public void acDataBaseClose() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DataBase ile iletiþim sonlandýrýldý.");
		}
	
	}

	@Override
	public void Insert(SozlesmeIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		acDataBaseOpen();
		Statement statement = connection.createStatement();
		statement.execute("INSERT into Sozlesmeler(Ad,Soyad,Tc_No,Dogum_Tarihi,Cinsiyet,Telefon_No,eMail,Adres,ehliyetTarih,Ehliyet_Tipi,DogumYeri,KefilAD,KefilSoyAD,KefilAdres,KiralamaTarih,TeslimTarihi,KefilTelefon,arabaID,TotalFiyat) VALUES('"+getAd()+"','"+getSoyad()+"','"+getTc_No()+"','"+getDogumTarih()+"','"+getCinsiyet()+"','"+getCepNo()+"','"+getMail()+"','"+getAdres()+"','"+getEhliyetTarih()+"','"+getEhliyetTip()+"','"+getDogumYeri()+"','"+getKefilAD()+"','"+getKefilSoyad()+"','"+getKefilAdres()+"','"+getIlktarih()+"','"+getSontarih()+"','"+getKefilcepNO()+"','"+getAracID()+"','"+getSonTutar()+"')");
		acDataBaseClose();
		
	}

	@Override
	public void Delete(SozlesmeIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		acDataBaseOpen();
		String query="delete from Sozlesmeler Where ID=?";
		PreparedStatement pat = connection.prepareStatement(query);
		pat.setInt(1, getKullaniciID());
		pat.executeUpdate();
		connection.createStatement();
		String query2="Update AracBilgileri SET KiralanmaDurumu=? WHERE ID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query2);
		preparedStatement.setString(1,entity.Status1);
		preparedStatement.setString(2,entity.getAracID());	
		preparedStatement.executeUpdate();
		connection.close();
	}

	@Override
	public void Update(SozlesmeIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		acDataBaseOpen();
		
		connection.createStatement();
		String query="Update AracBilgileri SET KiralanmaDurumu=? WHERE ID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1,entity.Status);
		preparedStatement.setString(2,entity.getAracID());	
		preparedStatement.executeUpdate();
		connection.close();
		
	}
	

}
