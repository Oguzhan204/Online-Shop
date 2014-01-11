package de.shop.kundenverwaltung.domain;

import java.io.Serializable;
import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;







import org.hibernate.validator.constraints.Email;

import de.shop.bestellverwaltung.domain.Bestellung;
import de.shop.kundenverwaltung.domain.HobbyType;

/**
 * @author <a href="mailto:oguzhan.atmaca@web.de">Oguzhan Atmaca</a>
 */
public class Kunde implements Serializable {	

	private static final long serialVersionUID = -7781792054449572766L;
	
	private static final String NAME_PATTERN = "[A-Z\u00C4\u00D6\u00DC][a-z\u00E4\u00F6\u00FC\u00DF]+";
	private static final String NACHNAME_PREFIX = "(o'|von|von der|von und zu|van)?";
	public static final String NACHNAME_PATTERN = NACHNAME_PREFIX + NAME_PATTERN + "(-" + NAME_PATTERN + ")?";
	private static final int NACHNAME_LENGTH_MIN = 2;
	private static final int NACHNAME_LENGTH_MAX = 32;
	private static final int EMAIL_LENGTH_MAX = 128;

	private Long id;

	@NotNull(message = "{kunde.nachname.notNull}")
	@Size(min = NACHNAME_LENGTH_MIN, max = NACHNAME_LENGTH_MAX,
	      message = "{kunde.nachname.length}")
	@Pattern(regexp = NACHNAME_PATTERN, message = "{kunde.nachname.pattern}")
	private String nachname;
	
	@Email(message = "{kunde.email.pattern}")
	@NotNull(message = "{kunde.email.notNull}")
	@Size(max = EMAIL_LENGTH_MAX, message = "{kunde.email.length}")
	private String email;

	@Past(message = "{kunde.seit.past}")
	private Date seit;

	@Valid
	@NotNull(message = "{kunde.adresse.notNull}")
	private Adresse adresse;
	
	@XmlTransient
	private List<Bestellung> bestellungen;
	
	private URI bestellungenUri;
	
	private Set<HobbyType> hobbies;
	
	public Set<HobbyType> getHobbies() {
		return hobbies;
	}
	
	public void setHobbies(Set<HobbyType> hobbies) {
		this.hobbies = hobbies;
	}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNachname() {
		return nachname;
	}
	public void setNachname(String nachname) {
		this.nachname = nachname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getSeit() {
		return seit;
	}
	public void setSeit(Date seit) {
		this.seit = seit;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	public List<Bestellung> getBestellungen() {
		return bestellungen;
	}
	public void setBestellungen(List<Bestellung> bestellungen) {
		this.bestellungen = bestellungen;
	}

	public URI getBestellungenUri() {
		return bestellungenUri;
	}
	public void setBestellungenUri(URI bestellungenUri) {
		this.bestellungenUri = bestellungenUri;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kunde other = (Kunde) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		}
		else if (!email.equals(other.email))
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Kunde [id=" + id + ", nachname=" + nachname + ", email=" + email + ", seit=" + seit
			   + " " + adresse + ", bestellungenUri=" + bestellungenUri + "]";
	}
}
