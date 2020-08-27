package org.ntnu.PentBruktService.misc;

import org.glassfish.jersey.server.JSONP;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class Item {

    private long itemId;
    private String itemName;
    private Date created;
    private String seller;

    public Item(){

    }

    public Item(long itemId, String itemName, Date created, String seller) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.created = new Date();
        this.seller = seller;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Date getDatePosted() {
        return created;
    }

    public void setDatePosted(Date datePosted) {
        this.created = datePosted;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
}
