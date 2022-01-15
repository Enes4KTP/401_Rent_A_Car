import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AracIslemleri implements lConnection<AracIslemleri>{

	private Integer id;
	private String marka;
	private String model;
	private String yıl;
	private String plaka;
	private String renk;
	private String yakıtTipi;
	private String vites;
	private String yasSiniri;
	private Integer fiyat;
	static public String resimURL;
	private String aracDurum;
	
	public String getAracDurum() {
		return aracDurum;
	}

	private void setAracDurum(String aracDurum) {
		this.aracDurum = aracDurum;
	}

	int size=0;
	private Connection connection;
	@Override
	public void acDataBaseOpen() {
		// TODO Auto-generated method stub
		try {
			connection= DriverManager.getConnection(databaseURL);
			System.out.println("DataBase ile iletişim başlatıldı.");
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	public void resimCek(String url)
	{
		setResimURL(url);
	}
	

	@Override
	public void acDataBaseClose() {
		// TODO Auto-generated method stub
		try {
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("DataBase ile iletişim sonlandırıldı.");
		}
	
	}
	public AracIslemleri() {}
	//Verileri Çekme
	public AracIslemleri(int id,String Marka,String Model,String Yıl,String Plaka,String Renk,String YakitTip,String Vites,String yasSinir,int Fiyat,String resimURL,String aracKiralanma) {
		 setId(id);
		 setMarka(Marka);
		 setModel(Model);
		 setYıl(Yıl);
		 setPlaka(Plaka);
		 setRenk(Renk);
		 setYakıtTipi(YakitTip);
		 setVites(Vites);
		 setYasSiniri(yasSinir);
		 setFiyat(Fiyat);
		 setResimURL(resimURL);
		 setAracDurum(aracKiralanma);
	}
	public AracIslemleri(int id,String Marka,String Model,String Yıl,String Plaka,String Renk,String YakitTip,String Vites,String yasSinir,int Fiyat,String resimURL) {
		 setId(id);
		 setMarka(Marka);
		 setModel(Model);
		 setYıl(Yıl);
		 setPlaka(Plaka);
		 setRenk(Renk);
		 setYakıtTipi(YakitTip);
		 setVites(Vites);
		 setYasSiniri(yasSinir);
		 setFiyat(Fiyat);
		 setResimURL(resimURL);
	}
	
	
	//INSERT//
	public AracIslemleri(String Marka,String Model,String Yıl,String Plaka,String Renk,String YakitTip,String Vites,String yasSinir,int Fiyat,String resimURL) {
		
		 setMarka(Marka);
		 setModel(Model);
		 setYıl(Yıl);
		 setPlaka(Plaka);
		 setRenk(Renk);
		 setYakıtTipi(YakitTip);
		 setVites(Vites);
		 setYasSiniri(yasSinir);
		 setFiyat(Fiyat);
		setResimURL(resimURL);
	}
	
	Statement statement;
	ResultSet result;

	
	public void fill_Table() throws SQLException
	{
		String dataBase="SELECT * FROM AracBilgileri";
		 acDataBaseOpen();
		 result = statement.executeQuery(dataBase);
		while(result.next())
		{
			 setId(result.getInt("ID"));
			 setMarka(result.getString("Marka"));
			 setModel(result.getString("Model"));
			 setYıl(result.getString("Yıl"));
			 setPlaka(result.getString("Plaka"));
			 setRenk(result.getString("Renk"));
			 setYakıtTipi(result.getString("Yakit_Tipi"));
			 setVites(result.getString("Vites"));
			 setYasSiniri(result.getString("Yas_Siniri"));
			 setFiyat(result.getInt("Fiyat"));
			 setResimURL(result.getString("AracResim"));
			 setAracDurum(result.getString("KiralanmaDurumu"));

		}
		acDataBaseClose();

	}
	public Integer getId() {
		return id;
	}

	private void setId(Integer id) {
		this.id = id;
	}

	public String getMarka() {
		return marka;
	}

	private void setMarka(String marka) {
		this.marka = marka;
	}

	public String getModel() {
		return model;
	}

	private void setModel(String model) {
		this.model = model;
	}

	public String getYıl() {
		return yıl;
	}

	private void setYıl(String yıl) {
		this.yıl = yıl;
	}

	public String getPlaka() {
		return plaka;
	}

	private void setPlaka(String plaka) {
		this.plaka = plaka;
	}

	public String getRenk() {
		return renk;
	}

	private void setRenk(String renk) {
		this.renk = renk;
	}

	public String getYakıtTipi() {
		return yakıtTipi;
	}

	private void setYakıtTipi(String yakıtTipi) {
		this.yakıtTipi = yakıtTipi;
	}

	public String getVites() {
		return vites;
	}

	private void setVites(String vites) {
		this.vites = vites;
	}


	public String getYasSiniri() {
		return yasSiniri;
	}

	private void setYasSiniri(String yasSiniri) {
		this.yasSiniri = yasSiniri;
	}

	 public Integer getFiyat() {
		return fiyat;
	}

	private void setFiyat(Integer fiyat) {
		this.fiyat = fiyat;
	}

	static public String getResimURL() {
		return resimURL;
	}

	static public void setResimURL(String resimUrL) {
		resimURL = resimUrL;
	}

	@Override
	public void Insert(AracIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		acDataBaseOpen();
		String laststatus="Kiralanmamış";
		Statement statement = connection.createStatement();
		statement.execute("INSERT into AracBilgileri(Marka,Model,Yıl,Plaka,Renk,Yakit_Tipi,Vites,Yas_Siniri,Fiyat,AracResim,KiralanmaDurumu) VALUES('"+getMarka()+"','"+getModel()+"','"+getYıl()+"','"+getPlaka()+"','"+getRenk()+"','"+getYakıtTipi()+"','"+getVites()+"','"+getYasSiniri()+"','"+getFiyat()+"','"+getResimURL()+"','"+laststatus +"')");
		acDataBaseClose();
	}

	@Override
	public void Delete(AracIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void Update(AracIslemleri entity) throws SQLException {
		// TODO Auto-generated method stub
		acDataBaseOpen();
		connection.createStatement();
		String query="Update AracBilgileri SET Marka=?,Model=?,Yıl=?,Plaka=?,Renk=?,Yakit_Tipi=?,Vites=?,Yas_Siniri=?,Fiyat=?,AracResim=? WHERE ID=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		

		preparedStatement.setString(1,entity.getMarka());
		preparedStatement.setString(2,entity.getModel());
		preparedStatement.setString(3,entity.getYıl());
		preparedStatement.setString(4,entity.getPlaka());
		preparedStatement.setString(5,entity.getRenk());
		preparedStatement.setString(6,entity.getYakıtTipi());
		preparedStatement.setString(7,entity.getVites());
		preparedStatement.setString(8,entity.getYasSiniri());
		preparedStatement.setInt(9,entity.getFiyat());
		preparedStatement.setString(10,entity.getResimURL());
		preparedStatement.setInt(11,entity.getId());
		preparedStatement.executeUpdate();
		connection.close();
	}
	public AracIslemleri arama(int id) throws SQLException{
		AracIslemleri araclistele
		=null;
		try {
			
			acDataBaseOpen();
			  String query = "SELECT * FROM AracBilgileri WHERE ID = '"+id+"'";
				Statement statement = connection.createStatement();
				result=statement.executeQuery(query);
				while(result.next())
				{
				araclistele = new AracIslemleri();
				araclistele.setId(result.getInt("ID"));
				araclistele.setResimURL(result.getString("AracResim"));
			
				}
//				String query1="Update AracBilgileri SET AracResim='"+result.getString("AracResim")+"' WHERE ID='"+id+"'";
//				PreparedStatement preparedStatement_1 = connection.prepareStatement(query1);
//				preparedStatement_1.executeUpdate(query1);
				
connection.close();

		}
		catch(SQLException e){
			e.printStackTrace();
		}
return araclistele;
	}
	
		
	
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return this.getMarka()+" "+this.getId(); 
	}
	
	
	}
