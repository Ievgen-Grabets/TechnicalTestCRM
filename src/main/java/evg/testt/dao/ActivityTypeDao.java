package evg.testt.dao;

import evg.testt.model.Activity;
import evg.testt.model.ActivityType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityTypeDao extends JpaRepository<ActivityType, Integer> {

}
