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
    
    public List<Member> show()
    {
        String sql = "SELECT * FORM member";
        List<Member> memberList = new ArrayList<Member>();
        
        DatabaseManager dbManager = null;
        
        Member member = new Member();
        
        try
        {
            dbManager = DatabaseManager.newInstance();
            ResultSet rs =  dbManager.executeQuery(sql);
            debug(sql);
            while(rs.next())
            {
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
    
    public void debug(String str)
    {
        System.out.println("[DEBUG]:" + str);
    }
}

