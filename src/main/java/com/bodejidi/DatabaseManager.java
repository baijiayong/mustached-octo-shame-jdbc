package com.bodejidi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.Date;
import java.lang.AutoCloseable;

public class DatabaseManager
{
    private Connection conn = null;
    private PreparedStatement pstmt = null;
    private ResultSet rs = null;
    
    Integer index = null;
    
    static final String jdbcUrl = "jdbc:mysql://localhost/test?" + "user=root" + "&password=";
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
   // static final String jdbcUrl = "jdbc:mysql://localhost/test?" + "user=root" + "&password=";
    //static final String jdbcDriver = "com.mysql.jdbc.Driver";
    
    private DatabaseManager()
    {
        
    }
    static public DatabaseManager newInstance() throws SQLException
    {
        DatabaseManager dbManager = new DatabaseManager();
        
        dbManager.conn = dbManager.createConnection();
        
        return dbManager;
    } 
    public Connection createConnection() throws SQLException
    {
        try
        {
            Class.forName(jdbcDriver).newInstance();
            
        }catch(Exception ex)
        {
            //ignore;
        }
        return DriverManager.getConnection(jdbcUrl);
    }
    public DatabaseManager prepare(String sql) throws SQLException
    {
        pstmt = conn.prepareStatement(sql);
        index = 1;
        return this;
    }
    public DatabaseManager setString(String param) throws SQLException
    {
        pstmt.setString(index,param);
        index++;
        return this;
    }
    public DatabaseManager setLong(Long param) throws SQLException
    {
        pstmt.setLong(index,param);
        index++;
        return this;
    }
    public DatabaseManager setDate(Date date) throws SQLException
    {
        pstmt.setDate(index,new java.sql.Date(date.getTime()));
        index++;
        return this;
    }
    public Boolean execute() throws SQLException
    {
        return pstmt.execute();
    }
    public ResultSet executeQuery() throws SQLException
    {
        return pstmt.executeQuery();
    }
    public ResultSet executeQuery(String sql) throws SQLException
    {
        prepare(sql);
        return executeQuery();
    }
    public Boolean execute(String sql,Object... params) throws SQLException
    {
        prepare(sql);
        for(Object param: params)
        {
            if(param instanceof String)
            {
                setString((String) param);
            }else if(param instanceof Long)
            {
                setLong((Long) param);
            }else if(param instanceof Date)
            {
                setDate((Date) param);
            }
        }
        return execute();
    }
    public void close()
    {
        close(conn);
        conn = null;
        
        close(pstmt);
        pstmt = null;
         
        close(rs);
        rs = null;  
    }
    public void close(AutoCloseable obj)
    {
        if (obj != null)
        {
            try
            {
                obj.close();
            }catch(Exception e)
            {
               //ignore;
            }
        }
    }
    public void debug(String str)
    {
        System.out.println(str);
    }
    
}