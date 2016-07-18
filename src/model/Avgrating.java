package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the AVGRATING database table.
 * 
 */
@Entity
@NamedQuery(name="Avgrating.findAll", query="SELECT a FROM Avgrating a")
public class Avgrating implements Serializable {
	private static final long serialVersionUID = 1L;

	private BigDecimal avgrating;

	//bi-directional one-to-one association to Grestaurant
	@OneToOne
	@Id
	@JoinColumn(name="GRESTAURANTID")
	private Grestaurant grestaurant;

	public Avgrating() {
	}

	public BigDecimal getAvgrating() {
		return this.avgrating;
	}

	public void setAvgrating(BigDecimal avgrating) {
		this.avgrating = avgrating;
	}

	public Grestaurant getGrestaurant() {
		return this.grestaurant;
	}

	public void setGrestaurant(Grestaurant grestaurant) {
		this.grestaurant = grestaurant;
	}

}