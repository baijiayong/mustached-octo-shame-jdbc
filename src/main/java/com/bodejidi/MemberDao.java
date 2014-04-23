package com.bodejidi;

import java.util.Date;
import java.sql.SQLException;

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
        debug(sql);

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
    
    public void debug(String str)
    {
        System.out.println("[DEBUG]:" + str);
    }
}

