package com.example.promoweb.promotion;

import com.example.promoweb.product.Product;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "promotion")
public class Promotion {

    @Id
    @SequenceGenerator(
            name = "promotion_sequence",
            sequenceName = "promotion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "promotion_sequence"
    )
    private Long promotion_id;
    private Integer reduction;
    private Date dateDebut;
    private Date dateFin;
    @ManyToOne
    @JoinColumn(name = "promotion_id")
    private Product product;

    public Promotion() {
    }

    public Promotion(Integer reduction, Date dateDebut, Date dateFin, Product product) {
        this.reduction = reduction;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.product = product;
    }

    public Promotion(Long promotion_id, Integer reduction, Date dateDebut, Date dateFin, Product product) {
        this.promotion_id = promotion_id;
        this.reduction = reduction;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
        this.product = product;
    }

    public Long getPromotion_id() {
        return promotion_id;
    }

    public void setPromotion_id(Long promotion_id) {
        this.promotion_id = promotion_id;
    }

    public Integer getReduction() {
        return reduction;
    }

    public void setReduction(Integer reduction) {
        this.reduction = reduction;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Promotion{" +
                "promotion_id=" + promotion_id +
                ", reduction=" + reduction +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", product=" + product +
                '}';
    }
}
