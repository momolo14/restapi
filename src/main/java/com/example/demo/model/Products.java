package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="produit")
@EntityListeners(AuditingEntityListener.class)

public class Products implements Serializable{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private Long referance;
@Column
private String designiation;
@Column
private double prix;
@Column
private long quantite;
@Column
private boolean promo;
public Long getReferance() {
	return referance;
}
public void setReferance(Long referance) {
	this.referance = referance;
}
public String getDesigniation() {
	return designiation;
}
public void setDesigniation(String designiation) {
	this.designiation = designiation;
}
public double getPrix() {
	return prix;
}
public void setPrix(double prix) {
	this.prix = prix;
}
public long getQuantite() {
	return quantite;
}
public void setQuantite(long quantite) {
	this.quantite = quantite;
}
public boolean isPromo() {
	return promo;
}
public void setPromo(boolean promo) {
	this.promo = promo;
}








}
