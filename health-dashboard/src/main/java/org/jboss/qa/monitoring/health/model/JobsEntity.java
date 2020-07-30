package org.jboss.qa.monitoring.health.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "jobs")
public class JobsEntity {

    public Long getId() {
        return id;
    }

    public String getJob() {
        return job;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getProduct() {
        return product;
    }

    public String getBranch() {
        return branch;
    }

    public String getUrl() {
        return url;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getLastBuildApiUrl() {
        return lastBuildApiUrl;
    }

    public int getActive() {
        return active;
    }

    public String getFolder() {
        return folder;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="job")
    private String job;

    @Column(name="product")
    private String product;

    @Column(name="branch")
    private String branch;

    @Column(name="folder")
    private String folder;

    @Column(name="url")
    private String url;

    @Column(name="api_Url")
    private String apiUrl;

    @Column(name="last_build_api_url")
    private String lastBuildApiUrl;

    @Column(name="active")
    private int active;

    @OneToMany(mappedBy = "jobsEntity", cascade = CascadeType.ALL)
    private List<JobsDailyStatusEntity> jobsDailyStatusEntityList;

    public JobsEntity() {
    }

    @Override
    public String toString() {
        return "JobsStatusEntity{" +
                "job='" + job + '\'' +
                ", product='" + product + '\'' +
                ", branch='" + branch + '\'' +
                ", folder='" + folder + '\'' +
                ", url='" + url + '\'' +
                ", apiUrl=" + apiUrl +
                ", lastBuildApiUrl=" + lastBuildApiUrl +
                ", active=" + active +
                '}';
    }

}
