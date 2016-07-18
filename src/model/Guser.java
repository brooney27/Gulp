package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GUSERS database table.
 * 
 */
@Entity
@Table(name="GUSERS")
@NamedQuery(name="Guser.findAll", query="SELECT g FROM Guser g")
public class Guser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="GUSERS_GUSERID_GENERATOR", sequenceName="GUSERS_SEQ")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="GUSERS_GUSERID_GENERATOR")
	private long guserid;

	private String email;

	private String gname;

	private String password;

	private BigDecimal zip;

	//bi-directional many-to-one association to Greview
	@OneToMany(mappedBy="guser")
	private List<Greview> greviews;

	public Guser() {
	}

	public long getGuserid() {
		return this.guserid;
	}

	public void setGuserid(long guserid) {
		this.guserid = guserid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGname() {
		return this.gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public BigDecimal getZip() {
		return this.zip;
	}

	public void setZip(BigDecimal zip) {
		this.zip = zip;
	}

	public List<Greview> getGreviews() {
		return this.greviews;
	}

	public void setGreviews(List<Greview> greviews) {
		this.greviews = greviews;
	}

	public Greview addGreview(Greview greview) {
		getGreviews().add(greview);
		greview.setGuser(this);

		return greview;
	}

	public Greview removeGreview(Greview greview) {
		getGreviews().remove(greview);
		greview.setGuser(null);

		return greview;
	}

}