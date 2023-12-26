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

    public WordInfo(Long id, Languages language, String word, String definition, String exampleSentence, String pronunciation, String etymology) {
        this.id = id;
        this.language = language;
        this.word = word;
        this.definition = definition;
        this.exampleSentence = exampleSentence;
        this.pronunciation = pronunciation;
        this.etymology = etymology;
    }

    public WordInfo(Languages language, String word, String definition, String exampleSentence, String pronunciation, String etymology) {
        this.language = language;
        this.word = word;
        this.definition = definition;
        this.exampleSentence = exampleSentence;
        this.pronunciation = pronunciation;
        this.etymology = etymology;
    }

    public WordInfo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Languages getLanguage() {
        return language;
    }

    public void setLanguage(Languages language) {
        this.language = language;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public String getExampleSentence() {
        return exampleSentence;
    }

    public void setExampleSentence(String exampleSentence) {
        this.exampleSentence = exampleSentence;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }

    public String getEtymology() {
        return etymology;
    }

    public void setEtymology(String etymology) {
        this.etymology = etymology;
    }
}
