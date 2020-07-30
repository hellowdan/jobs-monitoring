package org.jboss.qa.monitoring.health.model;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.jboss.qa.monitoring.health.data.JobsDailyStatusRow;

@Entity
@Table(name = "jobs_daily_status")
public class JobsDailyStatusEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="last_build_number")
    private String lastBuildNumber;

    @Column(name="last_successful_build_number")
    private String lastSuccessfulBuildNumber;

    @Column(name="last_failed_build_number")
    private String lastFailedBuildNumber;

    @Column(name="last_build_url")
    private String lastBuildUrl;

    @Column(name="last_build_status")
    private String lastBuildStatus;

    @Column(name="last_build_status_flag")
    private int lastBuildStatusFlag;

    @Column(name="last_build_duration")
    private Double lastBuildDuration;

    @Column(name="last_build_date_of_execution")
    private Timestamp lastBuildDateOfExecution;

    @Column(name="day")
    private int day;

    @Column(name="month")
    private int month;

    @Column(name="year")
    private int year;

    @Column(name="date_of_record")
    private LocalDateTime dateOfRecord;

    @Column(name="date_of_recordts")
    private Timestamp dateOfRecordTS;

    @ManyToOne
    @JoinColumn(name = "jobs_id")
    private JobsEntity jobsEntity;

    public JobsDailyStatusEntity() {
    }

    public JobsDailyStatusEntity(JobsDailyStatusRow jobsDailyStatusRow, JobsEntity jobsEntity) {
        LocalDate localDate = LocalDate.now();
        this.lastBuildUrl = jobsDailyStatusRow.getUrl();
        this.lastBuildNumber = jobsDailyStatusRow.getLastBuild();
        this.lastSuccessfulBuildNumber = jobsDailyStatusRow.getLastSuccessfulBuild();
        this.lastFailedBuildNumber = jobsDailyStatusRow.getLastFailedBuild();
        this.lastBuildStatus = jobsDailyStatusRow.getLastBuildStatus();
        this.lastBuildStatusFlag = jobsDailyStatusRow.getLastBuildStatusFlag();
        this.lastBuildDuration = jobsDailyStatusRow.getLastBuildDuration();
        this.lastBuildDateOfExecution = jobsDailyStatusRow.getLastBuildDateOfExecution();
        this.day = localDate.getDayOfMonth();
        this.month = localDate.getMonthValue();
        this.year = localDate.getYear();
        this.dateOfRecord = LocalDateTime.now();
        this.dateOfRecordTS = new Timestamp(System.currentTimeMillis());
        this.jobsEntity = jobsEntity;
    }

    @Override
    public String toString() {
        return "DroolsJenkinsDailyStatusEntity{" +
                "lastBuildNumber='" + lastBuildNumber + '\'' +
                ", lastSuccessfulBuildNumber=" + lastSuccessfulBuildNumber +
                ", lastFailedBuildNumber=" + lastFailedBuildNumber +
                ", lastBuildUrl=" + lastBuildUrl +
                ", lastBuildStatus=" + lastBuildStatus +
                ", lastBuildStatusFlag=" + lastBuildStatusFlag +
                ", lastBuildDuration=" + lastBuildDuration +
                ", lastBuildDateOfExecution=" + lastBuildDateOfExecution +
                ", jobsEntity=" + jobsEntity.toString() +
                '}';
    }
}

