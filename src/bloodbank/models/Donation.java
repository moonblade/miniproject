/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.models;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author moonblade
 */
public class Donation {

    int id;
    public String name,mobile,dateString;
    public int status;
    Donation(int id, String name, String dateString)
    {
        this.id=id;
        this.name = name;
    }
    public Donation(ResultSet r) throws SQLException
    {
        int i=1;
        this.name = r.getObject(i++).toString();
        this.mobile = r.getObject(i++).toString();
        this.status = Integer.parseInt(r.getObject(i++).toString());
        this.id=Integer.parseInt(r.getObject(i++).toString());
        dateString = r.getObject(i++).toString();
    }
    String toRow()
    {
        return (this.id + " " + this.name + " " + this.dateString);
    }
}
