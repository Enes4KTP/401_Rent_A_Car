import java.sql.SQLException;

public interface lConnection<T> {

	public void acDataBaseOpen();
	public String databaseURL = "jdbc:ucanaccess://DataBase.accdb";
	public void acDataBaseClose();
	public void Insert(T entity) throws SQLException;
	public void Delete(T entity) throws SQLException;
	public void Update(T entity) throws SQLException;
}
