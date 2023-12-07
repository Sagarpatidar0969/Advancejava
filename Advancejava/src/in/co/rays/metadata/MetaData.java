package in.co.rays.metadata;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;





public class MetaData {
	public static void main(String[] args) throws Exception { 
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/advance04", "root", "root");

		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select id,name,roll_no from newstudent");
		
		ResultSetMetaData rsmt = rs.getMetaData();
		
		System.out.println("Catalog Name : "+rsmt.getCatalogName(1)); 
		
		System.out.println("Table Name:"+rsmt.getTableName(1));

	
		int columnCount=rsmt.getColumnCount();
		
		System.out.println("Total coloums: "+columnCount); 

		for (int i = 1; i <=columnCount; i++) {
		System.out.println("Coloumn: "+i);
        System.out.println("label: "+rsmt.getColumnLabel(i));
        System.out.println("Name: " + rsmt.getColumnName(i));
        System.out.println("Tpye: " +rsmt.getColumnType(i));
        System.out.println("Size:" + rsmt.getColumnDisplaySize(i));
        System.out.println("Precision :" + rsmt.getPrecision(i));
        

		

		

		}	
	}
}