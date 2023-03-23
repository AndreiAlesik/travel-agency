package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "guide_language", schema = "public", catalog = "database")
public class GuideLanguage {
    @Basic
    @Column(name = "guide_id", nullable = false, insertable=false, updatable=false)
    private Long guideId;
    @Basic
    @Column(name = "language_code", nullable = false, length = 5, insertable=false, updatable=false)
    private String languageCode;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "guide_id", referencedColumnName = "id", nullable = false)
    private Guide guideByGuideId;
    @ManyToOne
    @JoinColumn(name = "language_code", referencedColumnName = "code", nullable = false)
    private Language languageByLanguageCode;

    public Long getGuideId() {
        return guideId;
    }

    public void setGuideId(Long guideId) {
        this.guideId = guideId;
    }

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuideLanguage that = (GuideLanguage) o;
        return Objects.equals(guideId, that.guideId) && Objects.equals(languageCode, that.languageCode) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guideId, languageCode, id);
    }

    public Guide getGuideByGuideId() {
        return guideByGuideId;
    }

    public void setGuideByGuideId(Guide guideByGuideId) {
        this.guideByGuideId = guideByGuideId;
    }

    public Language getLanguageByLanguageCode() {
        return languageByLanguageCode;
    }

    public void setLanguageByLanguageCode(Language languageByLanguageCode) {
        this.languageByLanguageCode = languageByLanguageCode;
    }
}
