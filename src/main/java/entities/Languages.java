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

    public Languages(Long id, Set<WordInfo> word, String languageName, String languageFamily) {
        this.id = id;
        this.word = word;
        this.languageName = languageName;
        this.languageFamily = languageFamily;
    }

    public Languages(Set<WordInfo> word, String languageName, String languageFamily) {
        this.word = word;
        this.languageName = languageName;
        this.languageFamily = languageFamily;
    }

    public Languages() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<WordInfo> getWord() {
        return word;
    }

    public void setWord(Set<WordInfo> word) {
        this.word = word;
    }

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageFamily() {
        return languageFamily;
    }

    public void setLanguageFamily(String languageFamily) {
        this.languageFamily = languageFamily;
    }
}
