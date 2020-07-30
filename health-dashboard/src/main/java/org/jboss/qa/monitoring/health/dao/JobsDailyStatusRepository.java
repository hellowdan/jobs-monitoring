package org.jboss.qa.monitoring.health.dao;

import org.jboss.qa.monitoring.health.model.JobsDailyStatusEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsDailyStatusRepository extends CrudRepository<JobsDailyStatusEntity, Long> {

}
