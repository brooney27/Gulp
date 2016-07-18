package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GREVIEWS database table.
 * 
 */
@Entity
@Table(name="GREVIEWS")
@NamedQuery(name="Greview.findAll", query="SELECT g FROM Greview g")
public class Greview implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GREVIEWS_GREVIEWID_GENERATOR", sequenceName="GREVIEWS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GREVIEWS_GREVIEWID_GENERATOR")
	private long greviewid;

	private BigDecimal rating;

	@Temporal(TemporalType.DATE)
	private Date reviewdate;

	private String text;

	//bi-directional many-to-one association to Grestaurant
	@ManyToOne
	@JoinColumn(name="GRESTAURANTID")
	private Grestaurant grestaurant;

	//bi-directional many-to-one association to Guser
	@ManyToOne
	@JoinColumn(name="GUSERID")
	private Guser guser;

	public Greview() {
	}

	public long getGreviewid() {
		return this.greviewid;
	}

	public void setGreviewid(long greviewid) {
		this.greviewid = greviewid;
	}

	public BigDecimal getRating() {
		return this.rating;
	}

	public void setRating(BigDecimal rating) {
		this.rating = rating;
	}

	public Date getReviewdate() {
		return this.reviewdate;
	}

	public void setReviewdate(Date reviewdate) {
		this.reviewdate = reviewdate;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Grestaurant getGrestaurant() {
		return this.grestaurant;
	}

	public void setGrestaurant(Grestaurant grestaurant) {
		this.grestaurant = grestaurant;
	}

	public Guser getGuser() {
		return this.guser;
	}

	public void setGuser(Guser guser) {
		this.guser = guser;
	}

}