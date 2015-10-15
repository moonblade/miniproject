/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bloodbank.models;

import java.sql.Date;

/**
 *
 * @author moonblade
 */
public class Donation {

    int id;
    String receiverName;
    String dateString;
    Donation(int id, String receiverName, String dateString)
    {
        this.id=id;
        this.receiverName = receiverName;
        this.dateString=dateString;
    }
    Donation(String row)
    {
        String split[] = row.split("\\s+");
        int i=0;
        this.id=Integer.parseInt(split[i++]);
        this.receiverName=split[i++];
        this.dateString=split[i++];
    }
    String toRow()
    {
        return (this.id + " " + this.receiverName + " " + this.dateString);
    }
}
