package entities;

import jakarta.persistence.*;

@Entity
public class WordInfo {
    @Id
    @GeneratedValue
    private Long id;
}
