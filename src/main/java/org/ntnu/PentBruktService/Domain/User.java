package org.ntnu.PentBruktService.Domain;


import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

// @Entity
@XmlRootElement
public class User {

    // @NotNull

    private long id;
    private String userName;
    private String firstName;
    private String lastName;
    private Date joined;

    public User() {
    }

    public User(long id, String userName, String firstName, String lastName) {
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getJoined() {
        return joined;
    }

    public void setJoined(Date joined) {
        this.joined = joined;
    }
}
