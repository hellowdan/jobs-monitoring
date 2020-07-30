package org.jboss.qa.monitoring.health.service;

import java.io.IOException;
import java.util.List;

import org.jboss.qa.monitoring.health.dao.JobsDailyStatusRepository;
import org.jboss.qa.monitoring.health.data.JobsDailyStatusData;
import org.jboss.qa.monitoring.health.exceptions.ExceptionsConstants;
import org.jboss.qa.monitoring.health.model.JobsDailyStatusEntity;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobsDailyStatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(JobsDailyStatusService.class);

    @Autowired
    JobsDailyStatusRepository jobsDailyStatusRepository;

    @Autowired
    JobsService jobsService;

    private List<JobsEntity> jobsEntities;

    private String result = "";

    private void setResult(String result) {
        this.result = result;
    }

    private String getResult(){
        return this.result;
    }

    public String runStatus(){
        this.jobsEntities = jobsService.getAllJobs();
        setResult("FAIL");

        jobsEntities.forEach(j -> {
            try {
                JobsDailyStatusData jobsDailyStatusData = new JobsDailyStatusData(j);
                JobsDailyStatusEntity jobsDailyStatusEntity = jobsDailyStatusData.getStatusData();
                jobsDailyStatusRepository.save(jobsDailyStatusEntity);
                setResult("SUCCESS");
            } catch (IOException e) {
                setResult(e.toString());
                LOGGER.debug(String.format(ExceptionsConstants.FAILED_SAVING_TO_DATABASE, jobsDailyStatusRepository.getClass().getCanonicalName()), e);
            }
        });

        return getResult();
    }

}
