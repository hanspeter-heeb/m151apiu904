package m223.apiu904.db;

import java.sql.*;
import java.util.*;

/**
 * 
 * @author Andreas Hildebrandt
 *
 */
public class DatenbankzugriffMySql implements DatenbankZugriffInterface
{

	private String url = "jdbc:mysql://localhost/";
	private String dbName = "blub";
	private String user = "root";
	private String password = "";
	private Statement statement = null;
	
	private Connection ctn = null;

	public DatenbankzugriffMySql(String url, String usr, String pwd) {
		this.url = url;
		this.user = usr;
		this.password = pwd;
		this.dbName ="";
		this.connectToDatabase();
	}
	
	/**
	 * @author Andreas Hildebrand
	 */
	public void connectToDatabase() { 						// << DB Connection
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e1) {
			
			e1.printStackTrace();
		} catch (IllegalAccessException e1) {

			e1.printStackTrace();
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			url += dbName;													// setzt url (+dbName aus der Testklasse)
			ctn = DriverManager.getConnection(url, user, password);			// Verbindung
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			statement = ctn.createStatement();
			
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
	}
	
	/**
	 * @author Andreas Hildebrandt
	 * 
	 */
	public boolean addZeile(Zeile z) {
      List<String> feldInhalt = z.getFeldinhalte();
      List<String> feldNamen = z.getTabelle().getFeldnamen();
      //z.setFeld(this.getPrimaryKey(z.getTabelle().getName()),"0");
      String tableName = z.getTabelle().getName();
      String query = "Insert into " + tableName + "(";
      for (String col : feldNamen) {
         	query += col + ", ";
      }
      
      query = query.substring(0,query.length()-2);
      query += ") values ('";

      int i=0;
      for (String val : feldInhalt) {
      		  query += z.getFeld(i++) + "', '";
      }
      
      query = query.substring(0,query.length()-3);
      query += ")";
      System.out.println(query);
      try {
          statement.executeUpdate(query,statement.RETURN_GENERATED_KEYS);
          ResultSet ks = statement.getGeneratedKeys();
          int id=0;
          if(ks.first())
         	 id=ks.getInt(1);
          z.setFeld(this.getPrimaryKey(z.getTabelle().getName()),""+id);
      } catch (SQLException e) {            
          e.printStackTrace();
          return false;
      }
      return true;
  }

	@Override
	public boolean closeDatabase()
	{
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * 
	 * @author René Bigler
	 */
	public Map<String, Tabelle> getTabellen() {
		Map<String, Tabelle> tabellen = new HashMap<String, Tabelle>();
		try {
				ResultSet r = statement.executeQuery("SHOW TABLES");
			while(r.next()) {
				Tabelle t = new Tabelle();
				t.setFeldnamen(this.getFieldNames(r.getString(1)));
				t.setFeldtypen(this.getFieldTypes(r.getString(1)));
				t.setPrimaryKey(this.getPrimaryKey(r.getString(1)));
				t.setName(r.getString(1));
				tabellen.put(r.getString(1), t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tabellen;
	}
	
	/**
	 * @author René Bigler
	 * @param table
	 * @return
	 */
	private String getPrimaryKey(String table) {
		String pk = "";
		try {
			ResultSet r = this.ctn.getMetaData().getPrimaryKeys(null, null, table);
			r.next();
			pk = r.getString("COLUMN_NAME");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return pk;
	}

	/**
	 * @author Andreas Hildebrand
	 * 
	 */
	public List<Zeile> getZeilen(String tn, String where, String orderBy)
	{	List<Zeile> zn= new ArrayList<Zeile>();
		Tabelle t = this.getTabellen().get(tn);
		
		try {
			ResultSet rs;
			rs = statement.executeQuery("SELECT * FROM "+tn+(where.length()>0?" WHERE "+where:"")+(orderBy.length()>0?" ORDERBY "+orderBy:""));
			while(rs.next()) {
				zn.add(neueZeile(t, rs));	
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return zn;
	}
	
	/**
	 * @author Andreas Hildebrand
	 * @param t Tabelle, die aufgerufen wurde
	 * @param rs Resultset, der Query
	 * @return ein Zeilenobjekt
	 */
	private Zeile neueZeile(Tabelle t, ResultSet rs)
	{
		Zeile z = new Zeile(t);
		int i=0;
		try {
			while(rs.getMetaData().getColumnCount() > i)
			{
				z.setFeld(i++, rs.getString(i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return z;
	}

	@Override
	public boolean openDatabase()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeZeile(Zeile z)
	{
		List<String> feldInhalt = z.getFeldinhalte();
	    String tableName = z.getTabelle().getName();
		 String query = " DELETE FROM "+tableName+"  WHERE `" + this.getPrimaryKey(tableName) + "`="+feldInhalt.get(0);
	    //System.out.println(query);
		 try {
	        statement.executeUpdate(query);
	    } catch (SQLException e) {            
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}

	/**
	 * Speichert eine Zeile in die Datenbank
	 * @author Benjamin und Bettina
	 * @param z Zu speichernde Zeile
	 * @return true wenn Speichervorgang fehlerfrei
	 */
	public boolean updateZeile(Zeile z) {
	    List<String> feldInhalt = z.getFeldinhalte();
	    List<String> feldNamen = z.getTabelle().getFeldnamen();
	    String tableName = z.getTabelle().getName();
	    String query = "UPDATE " + tableName + " SET ";
	    int lst =feldInhalt.size()-1;
	    for (int i=1;i< lst ;i++) {
	   	 System.out.println(lst);
	   	 	System.out.println(i);
	       	query += feldNamen.get(i) +" = '"+feldInhalt.get(i)+ "', ";
	    }
	    if(lst>1)
	   	 query += feldNamen.get(lst) +" = '"+feldInhalt.get(lst)+ "' ";
	    query += " WHERE `" + this.getPrimaryKey(tableName) + "`="+z.getPrimary();
	    System.out.println(query);
	    try {
	        //System.out.println(query);
	        statement.executeUpdate(query);
	    } catch (SQLException e) {            
	        e.printStackTrace();
	        return false;
	    }
	    return true;
	}
	
	/**
	 * @author René Bigler
	 * @param table
	 * @return
	 */
	private List<String> getFieldTypes(String table) {
		List<String> fieldTypes = new ArrayList<String>();
		try {
			Statement st = ctn.createStatement();
			ResultSet r = st.executeQuery("SHOW COLUMNS FROM " + table);
			while(r.next()) {
				String type = r.getString("Type");
				if(type.contains("tinyint")) {
					type = "Short";
				}
				else if(type.contains("int")) {
					type = "Integer";
				}
				else if(type.contains("varchar")) {
					type = "String";
				}
				else if(type.contains("int")) {
					type = "Integer";
				}
				else if(type.contains("float")) {
					type = "Float";
				}
				fieldTypes.add(type);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fieldTypes;
	}
	
	/**
	 * 
	 * @author René Bigler
	 * @param table
	 * @return
	 */
	private List<String> getFieldNames(String table) {
		List<String> fieldNameses = new ArrayList<String>();
		try {
			Statement st = ctn.createStatement();
			ResultSet r = st.executeQuery("SHOW COLUMNS FROM " + table);
			while(r.next()) {
					fieldNameses.add(r.getString("Field"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return fieldNameses;
	}
}
