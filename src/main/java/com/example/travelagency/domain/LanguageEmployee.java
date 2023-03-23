package com.example.travelagency.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "language_employee", schema = "public", catalog = "database")
public class LanguageEmployee {
    @Basic
    @Column(name = "language_code", nullable = false, length = 5, insertable = false, updatable = false)
    private String languageCode;
    @Basic
    @Column(name = "employee_id", nullable = false, insertable = false, updatable = false)
    private Long employeeId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "language_code", referencedColumnName = "code", nullable = false)
    private Language languageByLanguageCode;
    @ManyToOne
    @JoinColumn(name = "employee_id", referencedColumnName = "id", nullable = false)
    private Employee employeeByEmployeeId;

    public String getLanguageCode() {
        return languageCode;
    }

    public void setLanguageCode(String languageCode) {
        this.languageCode = languageCode;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
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
        LanguageEmployee that = (LanguageEmployee) o;
        return Objects.equals(languageCode, that.languageCode) && Objects.equals(employeeId, that.employeeId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(languageCode, employeeId, id);
    }

    public Language getLanguageByLanguageCode() {
        return languageByLanguageCode;
    }

    public void setLanguageByLanguageCode(Language languageByLanguageCode) {
        this.languageByLanguageCode = languageByLanguageCode;
    }

    public Employee getEmployeeByEmployeeId() {
        return employeeByEmployeeId;
    }

    public void setEmployeeByEmployeeId(Employee employeeByEmployeeId) {
        this.employeeByEmployeeId = employeeByEmployeeId;
    }
}
