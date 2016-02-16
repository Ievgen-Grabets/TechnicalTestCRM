package evg.testt.model;

import javax.persistence.Entity;

@Entity(name = "activity_types")
public class ActivityType extends BaseModel{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
