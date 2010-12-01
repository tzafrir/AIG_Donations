package aig.debug;
import java.sql.*;

public class DBcommon {
	 public static ConnectionConfig HOME_CFG = new ConnectionConfig("root", "", "jdbc:mysql://localhost/test");
	 //public static ConnectionConfig SSDL_CFG = new ConnectionConfig("yp2010-g3", "yp2010-g3", "jdbc:mysql://ssdl-sql/yp2010-g3");
	 public static ConnectionConfig SSDL_CFG = new ConnectionConfig("yp2010-g3", "yp2010-g3", "jdbc:mysql://localhost:3334/yp2010-g3");
	 
	 
	 
	 static boolean driverLoaded = false;
	 
	 static {
		 try {  
			 loadDriverSQL();  
		 }
		 catch (ClassNotFoundException e) {
		 	String msg =  "Cannot load driver: " + e.getMessage();
		 	logError(msg);
		 }
	 }
	 
	 
	 static void loadDriverSQL() throws ClassNotFoundException{
			 Class.forName ("com.mysql.jdbc.Driver");
			 driverLoaded = true;
	 }
	 
	 static Connection connect(ConnectionConfig cfg) throws SQLException{
		 Connection conn = DriverManager.getConnection (cfg.url, cfg.userName, cfg.password);
		 return conn;
	 }
	 
	 
	 public static String testHome(){
		 return test(HOME_CFG);
	 }

	 public static String testSSDL(){
		 return test(SSDL_CFG);
	 }
	 
	 public static String test(ConnectionConfig cfg){
		 Connection conn = null;
		 String t = "";
		 String q_c = "CREATE TABLE test_tbl (id_c5 char(5));";
		 String q_i = "INSERT INTO  test_tbl VALUES  ('fssdl');";
		 String q_s = "SELECT * FROM test_tbl;";
		 //"SELECT * FROM test_tbl"
		 if (!driverLoaded){
			 return "Driver is NOt Loaded";
		 }
		 try
		 {
			 conn = connect(cfg);
		     logInfo("Database connection established");
		     
		     Statement select = conn.createStatement();
		  //   select.executeUpdate(q_c);
		     select.executeUpdate(q_i);
		     ResultSet result = select.executeQuery(q_s);
		     logInfo("Execute: " + q_c + q_i + q_s  );
		     
		     logInfo("Got results:");
		     while (result.next()) { // process results one row at a time
		       String val = result.getString(1);
		       logInfo(val);
		       t += "<tr> <td>" + val + " </td> </tr>";
		     }
		 }
		 catch (SQLException e)
		 {
		 	String msg =  e.getMessage();
		 	logError(msg);
		 	t = msg;
		 }
		 catch (Exception e) 
		 { 
		 	String msg = "Undefied" + e.getMessage();
		 	logError(msg);
		 	t = msg;
		 }
		 finally
		 {
		     if (conn != null)
		     {
		         try
		         {
		             conn.close();
		             System.out.println ("Database connection terminated OK");
		         }
		         catch (Exception e) 
		         { 
		             System.err.println ("Close error" + e.getMessage());
		         	
		         }
		     }
		 }
		 return t;
	 }
	 
	 
	 
	 
	 
	 
	 
	 /**
	  * Logging functions
	  * TODO: implement using logger
	  * @param error true if error fales if info
	  * @param msg - message
	  */
	 static void logError(String msg)
	 {
		 System.err .println(msg);
	 }
	 
	 static void logInfo(String msg)
	 {
		 System.out.println(msg);
	 }
	
}


class ConnectionConfig {
	String userName = "root";
    String password = "";
    String url = "jdbc:mysql://localhost/test";

    ConnectionConfig(String userName, String password, String url){
    	this.userName = userName;
    	this.password = password;
    	this.url	  = url;
    }
}

