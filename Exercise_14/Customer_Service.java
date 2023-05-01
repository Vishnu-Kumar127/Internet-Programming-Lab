/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_14;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author VISHNU KUMAR M.J
 */
@WebService(serviceName = "Customer_Service")
public class Customer_Service {

    @WebMethod(operationName = "Update_Phone")
    public String Update_Phone(@WebParam(name = "id") int id,@WebParam(name = "Phone") String phone) 
    {
        List<Customer> customers = new ArrayList<>();
       
        try
        {
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/customer");
            Statement st=c.createStatement();
            String sql = "UPDATE customer SET PHONE = '"+phone+"' WHERE id = "+id;
            st.executeUpdate(sql);
            ResultSet rs=st.executeQuery("SELECT * from customer");
            while (rs.next()) 
            {
            int c_id = rs.getInt(1);
            String f_name = rs.getString(2);
            String l_name = rs.getString(3);
            String email = rs.getString(4);
            String Phone = rs.getString(5);
            Customer customer = new Customer(c_id, f_name,l_name, email, Phone);
            customers.add(customer);
         }   
        } 
        catch (SQLException ex) {}
        
        
        return customers.toString(); 
    }

    /**
     * Web service operation
     * @param id
     * @param Email
     * @return 
     */
    @WebMethod(operationName = "Update_Email")
    public String Update_Email(@WebParam(name = "id") int id, @WebParam(name = "Email") String Email) {
        //TODO write your implementation code here:
        List<Customer> customers = new ArrayList<>();
        
        try
        {
            Connection c=DriverManager.getConnection("jdbc:derby://localhost:1527/customer");
            Statement st=c.createStatement();
            String sql = "UPDATE customer SET email = '"+Email+"' WHERE id = "+id;
            st.executeUpdate(sql);
            ResultSet rs=st.executeQuery("SELECT * from customer");
            while (rs.next()) 
            {
            int c_id = rs.getInt(1);
            String f_name = rs.getString(2);
            String l_name = rs.getString(3);
            String email = rs.getString(4);
            String Phone = rs.getString(5);
            Customer customer = new Customer(c_id, f_name,l_name, email, Phone);
            customers.add(customer);
         }
            
        } 
        
        catch (SQLException ex) {}
        
        return customers.toString() ;
    }

   
}
