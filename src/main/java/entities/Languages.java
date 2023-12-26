package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Languages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "language_id")
    private Long id;
    @OneToMany(mappedBy = "language")
    private Set<WordInfo> word = new HashSet<>();
    @Column(name = "language_text")
    private String languageName;
    @Column(name = "language_family")
    private String languageFamily;
}
