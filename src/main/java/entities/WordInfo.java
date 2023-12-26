package entities;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class WordInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "word_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Languages language;
    @Column(name = "word")
    private String word;
    @Column(name = "definition")
    private String definition;
    @Column(name = "exampleSentence")
    private String exampleSentence;
    @Column(name = "pronunciation")
    private String pronunciation;
    @Column(name = "etymology")
    private String etymology;


}
