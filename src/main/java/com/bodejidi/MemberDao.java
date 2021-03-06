package com.bodejidi;

import java.util.Date;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MemberDao
{
    public Member save(Member member)
    {
        String firstName = member.getFirstName();
        String lastName = member.getLastName();
        System.out.println(firstName);
        System.out.println(lastName);
        
        DatabaseManager dbManager = null;
        String sql = "INSERT INTO member(first_name,last_name,created_date,last_updated) VALUES (?,?,?,?)";

        try
        {
            dbManager = DatabaseManager.newInstance();
            dbManager.execute(sql,firstName,lastName,new Date(),new Date());
            debug(sql);
            
        }catch(SQLException ex)
        {
            debug("SQLException: " + ex.getMessage());
            debug("SQLState: " + ex.getSQLState());
            debug("VendorError: " + ex.getErrorCode());
            System.out.println("Error!");
        }finally
        {
            dbManager.close();
        }  
        return member;
    }
    
    public List<Member> list()
    {
        String sql = "SELECT * FROM member";
        List<Member> memberList = new ArrayList<Member>();
        
        DatabaseManager dbManager = null;
        
       
        
        try
        {
            dbManager = DatabaseManager.newInstance();
            ResultSet rs =  dbManager.executeQuery(sql);
            debug(sql);
            while(rs.next())
            {
                Member member = new Member();
                member.setId(rs.getLong("id"));
                member.setFirstName(rs.getString("first_name"));
                member.setLastName(rs.getString("last_name"));
                memberList.add(member);
            }
            
        }catch(SQLException ex)
        {
            debug("SQLExcetion: " + ex.getMessage());
            debug("SQLState: " + ex.getSQLState());
            debug("VendorError: " + ex.getErrorCode());
            debug("Error!");
        }finally
        {
            dbManager.close();
        }
        return memberList;
    }
    public Member show(Member member)
    {
        Long id = member.getId();

        String sql = "SELECT * FROM member WHERE id=" + id;
         
        DatabaseManager dbManager = null;
 
        try
        {
            dbManager = DatabaseManager.newInstance();
            ResultSet rs = dbManager.executeQuery(sql);
            debug(sql);
            rs.next();
            member.setId(rs.getLong("id"));
            member.setFirstName(rs.getString("first_name"));
            member.setLastName(rs.getString("last_name"));
        }catch(SQLException ex)
        {
            debug("SQLException: " + ex.getMessage());
            debug("SQLState: " + ex.getSQLState());
            debug("VendorError: " + ex.getErrorCode());
            debug("Error!");
        }finally
        {
            dbManager.close();
        }
        return member;
    }
    public void delete(Member member)
    {
        Long id = member.getId();
        
        String sql = "DELETE FROM member WHERE id=" + id;
        
        DatabaseManager dbManager = null;
        
        try
        {
            dbManager = DatabaseManager.newInstance();
            debug(sql);
            dbManager.execute(sql);
        }catch(SQLException ex)
        {
            debug("SQLException:" + ex.getMessage());
            debug("SQLStates:" + ex.getSQLState());
            debug("VendorError:" + ex.getErrorCode());
            debug("Error");
        }finally
        {
            dbManager.close();
        }
    }
    public void update(Member member)
    {
        Long id = member.getId();
        
        String sql = "UPDATE member SET first_name=?,last_name=? WHERE id=?";
        
        DatabaseManager dbManager = null;
        
        try
        {
            dbManager = DatabaseManager.newInstance();
            debug(sql);
            dbManager.execute(sql,member.getFirstName(),member.getLastName(),id);
        }catch(SQLException ex)
        {
            debug("SQLException:" + ex.getMessage());
            debug("SQLState:"+ ex.getSQLState());
            debug("VendorError:" +ex.getErrorCode());
            debug("Error");
        }finally
        {
            dbManager.close();
        }
    }
    
    public void debug(String str)
    {
        System.out.println("[DEBUG]:" + str);
    }
}

