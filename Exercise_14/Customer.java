/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Exercise_14;

/**
 *
 * @author VISHNU KUMAR M.J
 */
class Customer
{
   private int id;
    private String f_name;
    private String l_name;
    private String email;
    private String phone;

    public Customer(int id, String f_name, String l_name, String email, String phone) 
    {
        this.id = id;
        this.f_name = f_name;
        this.l_name = l_name;
        this.email = email;
        this.phone = phone;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getF_name() {
        return f_name;
    }

    public void setF_name(String f_name) {
        this.f_name = f_name;
    }

    public String getL_name() {
        return l_name;
    }

    public void setL_name(String l_name) {
        this.l_name = l_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
   @Override
    public String toString()
    {
        return "\nId:"+id+" Name:"+f_name+" "+l_name+" Email:"+email+" Mobile Number:"+phone+" ";
    }
}
