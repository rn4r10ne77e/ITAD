package ITAD;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBConn
{
	String connectionUrl=null; String Qry=null, ErrMsg=null;
	Connection conn=null;
	Statement stmt=null;
	ResultSet rset=null;

	String SIP, Port, SID, SPW, DBname;
	
	public DBConn()
	{
		SIP = "localhost";
		Port = "1433";
		SID = "YS";
		SPW = "@Wsx3edc";
		DBname = "ITAD";	
	}
	public DBConn(String strIP, String strPORT, String strID, String strPW, String strDBname )
	{
		this.SIP = strIP;
		this.Port = strPORT;
		this.SID = strID;
		this.SPW = strDBname;
		this.DBname = strDBname;	
	}

	public List<Map<String, Object>> Load( String qry )
	{
		Connect();
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		Map<String, Object> map;

		try
		{
			rset = stmt.executeQuery(qry);
			ResultSetMetaData metaData = rset.getMetaData();

			int sizeOfColumn = metaData.getColumnCount();

			String column, type;

			while (rset.next())
			{
				map = new HashMap<String, Object>();

				for (int indexOfcolumn = 0; indexOfcolumn < sizeOfColumn; indexOfcolumn++)
				{
					column = metaData.getColumnName(indexOfcolumn + 1);
					type = metaData.getColumnTypeName(indexOfcolumn + 1);

					if( "int".equals(type) ) 
						map.put(column, rset.getInt(column));
					else if( "money".equals(type))
						map.put(column, rset.getLong(column));
					else
						map.put(column, rset.getString(column));
				}
				list.add(map);
			}
			Disconnect();
		}
		catch( Exception e ){ e.printStackTrace(); System.out.println(qry); Disconnect(); }

		
		return list;
	}
	public boolean Update( String qry )
	{
		Connect();
		try
		{
			rset = stmt.executeQuery(qry);
			Disconnect();
			return true;
		}
		catch( Exception ex){ Disconnect(); return false; }
	}
	public int Insert( String qry )
	{
		Connect();
		ErrMsg = qry;
		int resultrow=0; int CreationIdx=-1;
		try
		{
			resultrow = stmt.executeUpdate(qry);
			if( resultrow != 0 )
			{
				rset = stmt.executeQuery("select @@IDENTITY");
				while(rset.next()){ CreationIdx = rset.getInt(1); };
			}
			Disconnect();
		}
		catch(SQLException ex){ Disconnect(); return CreationIdx;}
		return CreationIdx;
	}	
	public int Delete( String qry )
	{
		return 1;
	}
	
	public void sp_exec( String spname, int totalparam, List<Map<String, Object>> paramlist )
	{
		try
		{
			CallableStatement cs = conn.prepareCall( spname );//"{call myStoredProcedure(?,?,?)}"
			
			
			
			//cs.callableStatement.setInt(1, 10);
			//cs.registerOutParameter(parameterIndex,sqlType);
			cs.execute(); 
		}
		catch( Exception E )
		{
			E.getStackTrace();
		}
	
	}
	
	public boolean Connect()
	{
		try
		{
			Context context = new InitialContext();
			DataSource source = (DataSource)context.lookup("java:comp/env/jdbc/sqlserver");
			conn = source.getConnection();
			/*
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://"+SIP+":"+Port+";user="+SID+";password="+SPW+";databasename="+DBname);
			*/
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);// this ResultSet option need method last()
		}
		catch(Exception e)
		{
			System.out.println(e);
			e.printStackTrace();
			return false;
		}
		return true;
	}
	public boolean Disconnect()
	{
		try
		{
			rset.close();
			stmt.close();
			conn.close();
			
			return true;
		}
		catch(Exception e)
		{
			ErrMsg = e.getMessage();
			return false;
		}
	}



	
	public int GetRecordCnt()
	{
		int numRecord=0;
		try
		{
			rset.last();
			numRecord = rset.getRow();
			rset.beforeFirst();
		}
		catch(Exception e){ ErrMsg = e.getMessage(); }
		return numRecord;
	}
	public boolean SearchValue(String TB_Name, String input, String Colum)
	{

		boolean onoff = false;
		Qry="Select * from "+TB_Name;
		try
		{
			Connect();
			rset = stmt.executeQuery(Qry);
			while(rset.next())
			{
				if( input.equals(rset.getString(Colum).trim()))
				{
					onoff = true;
					break;
				}
			}
			Disconnect();
		}
		catch(SQLException ex){ ErrMsg = ex.getMessage(); Disconnect(); }
		
		return onoff;
	}
	public String CodeLookup(String TB_Name, String input, String Colum1, String Colum2)
	{

		String rt="0";
		String Qry="Select * from "+TB_Name;
		try
		{
			Connect();
			rset = stmt.executeQuery(Qry);
			while(rset.next())
			{
				if( input.equals(rset.getString(Colum1).trim()))
				{
					rt = (rset.getString(Colum2));
					break;
				}
			}
			Disconnect();
		}
		catch(SQLException ex){ ErrMsg = ex.getMessage(); Disconnect(); }
		
		
		return rt;
	}
	public int ReturnIDX(String TB_Name, String input, String Colum1, String Colum2)
	{
		int rt=0;
		Qry="Select * from "+TB_Name;
		try
		{
			Connect();
			rset = stmt.executeQuery(Qry);
			while(rset.next())
			{
				if( input.equals(rset.getString(Colum1).trim()))
				{
					rt = Integer.parseInt(rset.getString(Colum2));
					break;
				}
			}
			Disconnect();
		}
		catch(SQLException ex){ ErrMsg = ex.getMessage(); Disconnect(); }
		return rt;
	}

	
	// None DB connection
	
	public static String toUTF8(String s)
	{ 
		if(s==null){ return null; } 
		try
		{
			if( s.getBytes().equals("UTF-8") ) return s;
			else
			return new String(s.getBytes("8859_1"),"UTF-8"); 
		}
		catch(Exception e){ return s; } 
	} 
	public static String toToday(String Type)
	{
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat ( Type , Locale.KOREA );
		Date currentTime = new Date ();
		String mTime = mSimpleDateFormat.format ( currentTime );
		return mTime;
	}
	public String GetErrMsg(){ return ErrMsg; }

}
