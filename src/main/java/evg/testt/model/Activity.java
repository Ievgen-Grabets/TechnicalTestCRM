package evg.testt.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "activities")
public class Activity extends BaseModelWithVersion{

    @ManyToOne
    @JoinColumn(name = "contact_id", nullable = false)
    private Contact contact;

    private String title;

    private String notes;

    private Calendar dueDate;

    @ManyToOne
    @JoinColumn(name = "activity_type_id", nullable = false)
    private ActivityType type;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Calendar getDueDate() {
        return dueDate;
    }

    public void setDueDate(Calendar dueDate) {
        this.dueDate = dueDate;
    }

    public ActivityType getType() {
        return type;
    }

    public void setType(ActivityType type) {
        this.type = type;
    }

    public static Builder newBuilder() {
        return new Activity().new Builder();
    }

    public class Builder {

        private Builder() {
        }

        public Builder setId(Integer id) {
            Activity.this.setId(id);
            return this;
        }

        public Builder setVersion(Integer version) {
            Activity.this.setVersion(version);
            return this;
        }

        public Builder setContact(Contact contact) {
            Activity.this.setContact(contact);
            return this;
        }

        public Activity build() {
            return Activity.this;
        }
    }

}
