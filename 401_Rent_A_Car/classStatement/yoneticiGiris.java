import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class yoneticiGiris implements lLoginStatement<yoneticiGiris>{
	
	private Connection connection;
	static int sayac=0; //1'se ba�ar�l� demek
	@Override
	public void acDataBaseOpen() {
		// TODO Auto-generated method stub
		try {
			connection= DriverManager.getConnection(databaseURL);
			System.out.println("DataBase ile ileti�im ba�lat�ld�.");
		
			
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
			System.out.println("DataBase ile ileti�im sonland�r�ld�.");
		}
	}

	public void girisDogrulama(String username,String password)
	{
		acDataBaseOpen();
		try  
        {
         
                String sql = "SELECT * FROM YoneticiBilgileri WHERE yoneticiAd = '" + username + "'and yoneticiSifre= '" + password+ "'"; //

               Statement statement = connection.createStatement();
               
             
              ResultSet  result=statement.executeQuery(sql);
                if(result.next()) {
                 sayac=1;
                
                }
                else
                {
                	System.out.print("HATALI G�R�� L�TFEN TEKRAR DENEY�N�Z!!");
                }
                
            	acDataBaseClose();
              
            }
          
		catch (SQLException ex) {
            ex.printStackTrace();
        }



        } 
	}


