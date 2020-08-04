package org.jboss.qa.monitoring.health.data;

import java.sql.Timestamp;
import java.util.LinkedHashMap;

import org.jboss.qa.monitoring.health.definitions.SourceStatusColumns;
import org.jboss.qa.monitoring.health.model.JobsDailyStatusEntity;
import org.jboss.qa.monitoring.health.model.JobsEntity;
import org.json.simple.JSONObject;

public class JobsDailyStatusData {

    private JobsEntity jobsEntity;

    public JobsDailyStatusData(JobsEntity jobsEntity) {
        this.jobsEntity = jobsEntity;
    }

    public JobsDailyStatusEntity getParsedStatusData(JSONObject dataJsonLastBuild, JSONObject dataJsonJob){
        JobsDailyStatusRow jobsDailyStatusRow = parseJenkinsStatus(dataJsonLastBuild, dataJsonJob);

        JobsDailyStatusEntity jobsDailyStatusEntity = new JobsDailyStatusEntity(jobsDailyStatusRow, this.jobsEntity);

        return jobsDailyStatusEntity;
    }

    protected JobsDailyStatusRow parseJenkinsStatus(JSONObject dataJsonLastBuild, JSONObject dataJsonJob) {
        JobsDailyStatusRow jobsDailyStatusRow = new JobsDailyStatusRow();

        if (dataJsonLastBuild.get(SourceStatusColumns.URL.getColumn()) != null) {
            jobsDailyStatusRow.setUrl(dataJsonLastBuild.get(SourceStatusColumns.URL.getColumn()).toString());
        }
        if (dataJsonJob.get(SourceStatusColumns.LAST_BUILD.getColumn()) != null) {
            LinkedHashMap lastBuild = (LinkedHashMap) dataJsonJob.get(SourceStatusColumns.LAST_BUILD.getColumn());
            String number = lastBuild.get(SourceStatusColumns.BUILD_NUMBER.getColumn()).toString();
            jobsDailyStatusRow.setLastBuild(number);
        }
        if (dataJsonJob.get(SourceStatusColumns.LAST_SUCCESSFUL_BUILD.getColumn()) != null) {
            LinkedHashMap lastSucessfulBuild = (LinkedHashMap) dataJsonJob.get(SourceStatusColumns.LAST_SUCCESSFUL_BUILD.getColumn());
            String number = lastSucessfulBuild.get(SourceStatusColumns.BUILD_NUMBER.getColumn()).toString();
            jobsDailyStatusRow.setLastSuccessfulBuild(number);
        }
        if (dataJsonJob.get(SourceStatusColumns.LAST_FAILED_BUILD.getColumn()) != null) {
            LinkedHashMap lastFailedBuild = (LinkedHashMap) dataJsonJob.get(SourceStatusColumns.LAST_FAILED_BUILD.getColumn());
            String number = lastFailedBuild.get(SourceStatusColumns.BUILD_NUMBER.getColumn()).toString();
            jobsDailyStatusRow.setLastFailedBuild(number);
        }
        if (dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_STATUS.getColumn()) != null) {
            jobsDailyStatusRow.setLastBuildStatus(dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_STATUS.getColumn()).toString());
        }
        if (dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_TIMESTAMP.getColumn()) != null) {
            Long lastBuildDateOfExecution = Long.parseLong(dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_TIMESTAMP.getColumn()).toString());
            jobsDailyStatusRow.setLastBuildDateOfExecution(new Timestamp(lastBuildDateOfExecution));
        }
        if (dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_DURATION.getColumn()) != null) {
            Double lastBuildDuration = Double.parseDouble(dataJsonLastBuild.get(SourceStatusColumns.LAST_BUILD_DURATION.getColumn()).toString());
            jobsDailyStatusRow.setLastBuildDuration(lastBuildDuration);
        }

        return jobsDailyStatusRow;
    }
}
