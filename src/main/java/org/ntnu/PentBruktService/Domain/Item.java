package org.ntnu.PentBruktService.Domain;

import javax.xml.bind.annotation.XmlRootElement;
import java.text.SimpleDateFormat;
import java.util.Date;

@XmlRootElement
public class Item {

    private long itemId;
    private String itemName;
    private String profile;
    private String created;

    public Item(){

    }

    public Item(long itemId, String itemName, String profile) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.profile = profile;
        this.created = new SimpleDateFormat("dd:MM:yyyy").format(new Date());
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
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
}
