/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_14;

import java.util.*;

/**
 *
 * @author VISHNU KUMAR M.J
 */
public class Cilent {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc=new Scanner(System.in);
        System.out.println("Choices:\n1.Update Email\n2.Update Phone Number");
        System.out.println("Enter Your choice:");
        int ch=sc.nextInt();
        if(ch==2)
        {
            System.out.println("Enter Your Id:");
            int id=sc.nextInt();
            System.out.println("Enter Your New Mobile Number:");
            String phone=sc.next();
           c_phone(id,phone);
        }
        else if(ch==1)
        {
            System.out.println("Enter Your Id:");
            int id=sc.nextInt();
            System.out.println("Enter Your New Email:");
            String Email=sc.next();
            c_email(id,Email);
        }
    }

    private static void c_phone(int id, String phone) {
        Customer_Service service = new Customer_Service();
        String customers = service.Update_Phone(id, phone);
        System.out.println(customers);
    }
    private static void c_email(int id, String email) {
        Customer_Service service = new Customer_Service();
        String customers = service.Update_Email(id, email);
        System.out.println(customers);
    }
}
