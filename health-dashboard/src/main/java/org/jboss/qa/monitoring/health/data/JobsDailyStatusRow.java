package org.jboss.qa.monitoring.health.data;

import java.sql.Timestamp;

import org.jboss.qa.monitoring.health.definitions.JobStatus;

public class JobsDailyStatusRow {

    private String url;
    private String lastBuild;
    private String lastSuccessfulBuild;
    private String lastFailedBuild;
    private String lastBuildStatus;
    private int lastBuildStatusFlag;
    private Double lastBuildDuration;
    private Timestamp lastBuildDateOfExecution;

    public JobsDailyStatusRow() {
    }

    public String getLastBuild() {
        return lastBuild;
    }

    public void setLastBuild(String lastBuild) {
        this.lastBuild = lastBuild;
    }

    public String getLastSuccessfulBuild() {
        return lastSuccessfulBuild;
    }

    public void setLastSuccessfulBuild(String lastSuccessfulBuild) {
        this.lastSuccessfulBuild = lastSuccessfulBuild;
    }

    public String getLastFailedBuild() {
        return lastFailedBuild;
    }

    public void setLastFailedBuild(String lastFailedBuild) {
        this.lastFailedBuild = lastFailedBuild;
    }

    public String getLastBuildStatus() {
        return lastBuildStatus;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setLastBuildStatus(String lastBuildStatus) {
        this.lastBuildStatus = lastBuildStatus;
        if (this.lastBuildStatus.equals(JobStatus.SUCCESS.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.SUCCESS.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.FAILURE.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.FAILURE.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.ABORTED.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.ABORTED.getStatusFlag();
        } else if (this.lastBuildStatus.equals(JobStatus.UNSTABLE.getStatus())) {
            this.lastBuildStatusFlag = JobStatus.UNSTABLE.getStatusFlag();
        }
    }

    public int getLastBuildStatusFlag() {
        return lastBuildStatusFlag;
    }

    public Double getLastBuildDuration() {
        return lastBuildDuration;
    }

    public void setLastBuildDuration(Double lastBuildDuration) {
        this.lastBuildDuration = lastBuildDuration;
    }

    public Timestamp getLastBuildDateOfExecution() {
        return lastBuildDateOfExecution;
    }

    public void setLastBuildDateOfExecution(Timestamp lastBuildDateOfExecution) {
        this.lastBuildDateOfExecution = lastBuildDateOfExecution;
    }

    @Override
    public String toString() {
        return "TestResults{" +
                "url='" + url + '\'' +
                "lastBuild='" + lastBuild + '\'' +
                "lastSuccessfulBuild='" + lastSuccessfulBuild + '\'' +
                "lastFailedBuild='" + lastFailedBuild + '\'' +
                "lastBuildStatus='" + lastBuildStatus + '\'' +
                "lastBuildStatusFlag='" + lastBuildStatusFlag + '\'' +
                "lastBuildDateOfExecution='" + lastBuildDateOfExecution + '\'' +
                '}';
    }
}
