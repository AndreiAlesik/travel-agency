package com.example.travelagency.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "transport_company_transport", schema = "public", catalog = "database")
public class TransportCompanyTransport {
    @Basic
    @Column(name = "transport_company_id", nullable = false, insertable=false, updatable=false)
    private Long transportCompanyId;
    @Basic
    @Column(name = "transport_id", nullable = false, insertable=false, updatable=false)
    private Long transportId;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "transport_company_id", referencedColumnName = "id", nullable = false)
    private TransportCompany transportCompanyByTransportCompanyId;
    @ManyToOne
    @JoinColumn(name = "transport_id", referencedColumnName = "id", nullable = false)
    private Transport transportByTransportId;

    public Long getTransportCompanyId() {
        return transportCompanyId;
    }

    public void setTransportCompanyId(Long transportCompanyId) {
        this.transportCompanyId = transportCompanyId;
    }

    public Long getTransportId() {
        return transportId;
    }

    public void setTransportId(Long transportId) {
        this.transportId = transportId;
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
        TransportCompanyTransport that = (TransportCompanyTransport) o;
        return Objects.equals(transportCompanyId, that.transportCompanyId) && Objects.equals(transportId, that.transportId) && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transportCompanyId, transportId, id);
    }

    public TransportCompany getTransportCompanyByTransportCompanyId() {
        return transportCompanyByTransportCompanyId;
    }

    public void setTransportCompanyByTransportCompanyId(TransportCompany transportCompanyByTransportCompanyId) {
        this.transportCompanyByTransportCompanyId = transportCompanyByTransportCompanyId;
    }

    public Transport getTransportByTransportId() {
        return transportByTransportId;
    }

    public void setTransportByTransportId(Transport transportByTransportId) {
        this.transportByTransportId = transportByTransportId;
    }
}
