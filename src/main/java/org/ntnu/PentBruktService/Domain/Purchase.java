package org.ntnu.PentBruktService.Domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "purchase")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull
    private Long id;

    @NotNull
    private Long userId;

    @NotNull
    private Long productId;

    @NotNull
    private LocalDate datePublished;

    @PrePersist
    private void init(){
        setDatePublished(LocalDate.now());
    }

}
