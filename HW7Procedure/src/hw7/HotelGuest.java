/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hw7;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.ParameterMode;
import javax.persistence.StoredProcedureParameter;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ashraf Habromman
 */
@Entity
@Table(name = "HOTEL_GUEST")
@XmlRootElement

@NamedStoredProcedureQuery(
	name = "HotelGuest.GET_DATA_BY_SSN", 
	procedureName = "GET_DATA_BY_SSN", 
	parameters = { 
		@StoredProcedureParameter(mode = ParameterMode.IN, type = Integer.class, name = "GUEST_SSN_IN"), 
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "GUEST_NAME_OUT"), 
		@StoredProcedureParameter(mode = ParameterMode.OUT, type = BigInteger.class, name = "AGE_OUT"),
                @StoredProcedureParameter(mode = ParameterMode.OUT, type = String.class, name = "HAVE_COVID19_OUT")
	}
)
@NamedQueries({
    @NamedQuery(name = "HotelGuest.findAll", query = "SELECT h FROM HotelGuest h"),
    @NamedQuery(name = "HotelGuest.findByGuestSsn", query = "SELECT h FROM HotelGuest h WHERE h.guestSsn = :guestSsn"),
    @NamedQuery(name = "HotelGuest.findByAge", query = "SELECT h FROM HotelGuest h WHERE h.age = :age"),
    @NamedQuery(name = "HotelGuest.findByGuestName", query = "SELECT h FROM HotelGuest h WHERE h.guestName = :guestName"),
    @NamedQuery(name = "HotelGuest.findByHaveCovid19", query = "SELECT h FROM HotelGuest h WHERE h.haveCovid19 = :haveCovid19")})
public class HotelGuest implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "GUEST_SSN")
    private Integer guestSsn;
    @Basic(optional = false)
    @Column(name = "AGE")
    private BigInteger age;
    @Basic(optional = false)
    @Column(name = "GUEST_NAME")
    private String guestName;
    @Column(name = "HAVE_COVID19")
    private String haveCovid19;

    public HotelGuest() {
    }

    public HotelGuest(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }

    public HotelGuest(Integer guestSsn, BigInteger age, String guestName) {
        this.guestSsn = guestSsn;
        this.age = age;
        this.guestName = guestName;
    }

    public Integer getGuestSsn() {
        return guestSsn;
    }

    public void setGuestSsn(Integer guestSsn) {
        this.guestSsn = guestSsn;
    }

    public BigInteger getAge() {
        return age;
    }

    public void setAge(BigInteger age) {
        this.age = age;
    }

    public String getGuestName() {
        return guestName;
    }

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public String getHaveCovid19() {
        return haveCovid19;
    }

    public void setHaveCovid19(String haveCovid19) {
        this.haveCovid19 = haveCovid19;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (guestSsn != null ? guestSsn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HotelGuest)) {
            return false;
        }
        HotelGuest other = (HotelGuest) object;
        if ((this.guestSsn == null && other.guestSsn != null) || (this.guestSsn != null && !this.guestSsn.equals(other.guestSsn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "hw7.HotelGuest[ guestSsn=" + guestSsn + " ]";
    }
    
}
