package org.jboss.qa.monitoring.health.service;

import java.security.NoSuchAlgorithmException;
import java.util.List;

import org.jboss.qa.monitoring.health.dao.JobsDailyStatusRepository;
import org.jboss.qa.monitoring.health.data.JobsDailyStatusData;
import org.jboss.qa.monitoring.health.model.JobsDailyStatusEntity;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class JobsDailyStatusService {

    @Autowired
    JobsDailyStatusRepository jobsDailyStatusRepository;

    @Autowired
    JobsService jobsService;

    @Autowired
    private RestTemplate restTemplate;

    private List<JobsEntity> jobsEntities;

    public String runStatus() {
        this.jobsEntities = jobsService.getAllJobs();

        try {
        jobsEntities.forEach(j -> {
            if (j.getActive() > 0) {
                JSONObject dataJsonLastBuild = getJsonContentFromHTTPS(j.getLastBuildApiUrl());
                JSONObject dataJsonJob = getJsonContentFromHTTPS(j.getApiUrl());

                JobsDailyStatusData jobsDailyStatusData = new JobsDailyStatusData(j);
                JobsDailyStatusEntity jobsDailyStatusEntity = jobsDailyStatusData.getParsedStatusData(dataJsonLastBuild, dataJsonJob);
                jobsDailyStatusRepository.save(jobsDailyStatusEntity);
            }
        });
        } catch (Exception e) {
            return e.getMessage();
        }
        return "SUCCESS";
    }

    public JSONObject getJsonContentFromHTTPS(String url) {
        return this.restTemplate.getForObject(url, JSONObject.class);
    }
}
