package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the GRESTAURANTS database table.
 * 
 */
@Entity
@Table(name="GRESTAURANTS")
@NamedQuery(name="Grestaurant.findAll", query="SELECT g FROM Grestaurant g")
public class Grestaurant implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GRESTAURANTS_GRESTAURANTID_GENERATOR", sequenceName="GRESTAURANTS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GRESTAURANTS_GRESTAURANTID_GENERATOR")
	private long grestaurantid;

	private String address;

	private String description;

	private String gname;

	//bi-directional one-to-one association to Avgrating
	@OneToOne(mappedBy="grestaurant")
	private Avgrating avgrating;

	//bi-directional many-to-one association to Greview
	@OneToMany(mappedBy="grestaurant")
	private List<Greview> greviews;

	public Grestaurant() {
	}

	public long getGrestaurantid() {
		return this.grestaurantid;
	}

	public void setGrestaurantid(long grestaurantid) {
		this.grestaurantid = grestaurantid;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public Avgrating getAvgrating() {
		return this.avgrating;
	}

	public void setAvgrating(Avgrating avgrating) {
		this.avgrating = avgrating;
	}

	public List<Greview> getGreviews() {
		return this.greviews;
	}

	public void setGreviews(List<Greview> greviews) {
		this.greviews = greviews;
	}

	public Greview addGreview(Greview greview) {
		getGreviews().add(greview);
		greview.setGrestaurant(this);

		return greview;
	}

	public Greview removeGreview(Greview greview) {
		getGreviews().remove(greview);
		greview.setGrestaurant(null);

		return greview;
	}

}