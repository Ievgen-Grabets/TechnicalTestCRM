package evg.testt.model;

import evg.testt.validation.UniqueEmail;
import net.sf.oval.constraint.Email;
import net.sf.oval.constraint.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity(name = "contacts")
@UniqueEmail
public class Contact extends BaseModelWithVersion{


    @NotEmpty(message = "Please enter your first name")
    private String firstName;

    @NotEmpty(message = "Please enter your last name")
    private String lastName;

    @Email(message = "Invalid email")
    @NotEmpty(message = "Please enter your email")
    private String email;

    private String telephoneNumber;

    private String address1;

    private String address2;

    private String city;

    private String postCode;

    @OneToMany(mappedBy = "contact", fetch = FetchType.LAZY)
    private List<Activity> activities;

    public List<Activity> getActivities() { return activities; }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getaddress1() {
        return address1;
    }

    public void setaddress1(String address1) {
        this.address1 = address1;
    }

    public String getaddress2() {
        return address2;
    }

    public void setaddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public static Builder newBuilder() {
        return new Contact().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Contact.this.setId(id);
            return this;
        }

        public Builder setVersion(Integer version) {
            Contact.this.setVersion(version);
            return this;
        }

        public Contact build() {
            return Contact.this;
        }
    }
    
}
