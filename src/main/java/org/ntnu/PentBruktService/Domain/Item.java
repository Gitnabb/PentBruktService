package org.ntnu.PentBruktService.Domain;

import javax.persistence.*;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "items")
public class Item implements Serializable {

    @Id
    @Column(name = "itemID", unique = true)
    private long itemId;

    private String itemName;
    private String desc;
    private int price;
    private String published;

    public Item(){

    }

    public Item(long itemId, String itemName, String profile) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.published = new SimpleDateFormat("dd:MM:yyyy").format(new Date());
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

    public String getCreated() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
