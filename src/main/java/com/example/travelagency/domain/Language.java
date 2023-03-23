package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.Objects;

@Entity
public class Language {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "code", nullable = false, length = 5)
    private String code;
    @Basic
    @Column(name = "name", nullable = false, length = 255)
    private String name;
    @OneToMany(mappedBy = "languageByLanguageCode")
    private Collection<GuideLanguage> guideLanguagesByCode;
    @OneToMany(mappedBy = "languageByLanguageCode")
    private Collection<LanguageEmployee> languageEmployeesByCode;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Language language = (Language) o;
        return Objects.equals(code, language.code) && Objects.equals(name, language.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(code, name);
    }

    public Collection<GuideLanguage> getGuideLanguagesByCode() {
        return guideLanguagesByCode;
    }

    public void setGuideLanguagesByCode(Collection<GuideLanguage> guideLanguagesByCode) {
        this.guideLanguagesByCode = guideLanguagesByCode;
    }

    public Collection<LanguageEmployee> getLanguageEmployeesByCode() {
        return languageEmployeesByCode;
    }

    public void setLanguageEmployeesByCode(Collection<LanguageEmployee> languageEmployeesByCode) {
        this.languageEmployeesByCode = languageEmployeesByCode;
    }
}
