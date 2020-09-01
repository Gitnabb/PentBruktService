package org.ntnu.PentBruktService.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "listing")
public class Listing {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long listingId;
    @NotNull
    private String itemName;

    @NotNull
    private String desc;

    @NotNull
    private int price;

    @NotNull
    private LocalDate published;

    @PrePersist
    private void init(){
        setPublished(LocalDate.now());
    }

}
