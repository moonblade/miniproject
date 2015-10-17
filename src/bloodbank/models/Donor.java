/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.models;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moonblade
 */
public class Donor {

    public int id;
    public String name, email, bloodgroup, mobile;
    public String password;

    public Donor()
    {
        this.id = 0;
    }
    
    public Donor(int id, String name, String email, String password, String bloodgroup, String mobile) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.bloodgroup = bloodgroup;
        this.mobile = mobile;
    }

    public Donor(String name, String email, String password, String bloodgroup, String mobile) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.bloodgroup = bloodgroup;
        this.mobile = mobile;
    }

    public Donor(String row) {
        String split[] = row.split("\\s+");
        int i = 0;
        this.id = Integer.parseInt(split[i++]);
        this.name = split[i++] + split[i++];
        this.email = split[i++];
        this.password = split[i++];
        this.bloodgroup = split[i++];
        this.mobile = split[i++];
    }

    public Donor(ResultSet r) throws SQLException {
        int i = 1;
        id = Integer.parseInt(r.getObject(i++).toString());
        name = r.getObject(i++).toString();
        email = r.getObject(i++).toString();
        password = r.getObject(i++).toString();
        bloodgroup = r.getObject(i++).toString();
        mobile = r.getObject(i++).toString();

    }

    public String toRow() {
        return (this.id + " " + this.name + " " + this.email + " " + this.password + " " + this.bloodgroup + " " + this.mobile);
    }

    public String getMobile() {
        return this.mobile;
    }

    public void print() {
        System.out.println(toRow());
    }
}
