package com.eagleshing.miniprogram.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

/**
 * myUnlockedProject
 */
@Entity
@NamedQuery(name = "MyUnlockedProject.findUnlockedRecord", query = "SELECT up FROM MyUnlockedProject up "
        + "where up.projectId = :projectId and up.userId = :userId")
public class MyUnlockedProject {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    
    @Column(name = "user_id")
    private int userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "project_id")
    private int projectId;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "unlocked_at")
    private Date unlockedAt;

    @Column(name = "share_times")
    private int shareTimes;


    public MyUnlockedProject() {
    }

    public MyUnlockedProject(int userId, String userName, int projectId, String projectName, Date unlockedAt, int shareTimes) {
        this.userId = userId;
        this.userName = userName;
        this.projectId = projectId;
        this.projectName = projectName;
        this.unlockedAt = unlockedAt;
        this.shareTimes = shareTimes;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getProjectId() {
        return this.projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return this.projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public Date getUnlockedAt() {
        return this.unlockedAt;
    }

    public void setUnlockedAt(Date unlockedAt) {
        this.unlockedAt = unlockedAt;
    }

    public int getShareTimes() {
        return this.shareTimes;
    }

    public void setShareTimes(int shareTimes) {
        this.shareTimes = shareTimes;
    }

    public MyUnlockedProject id(int id) {
        this.id = id;
        return this;
    }

    public MyUnlockedProject userId(int userId) {
        this.userId = userId;
        return this;
    }

    public MyUnlockedProject userName(String userName) {
        this.userName = userName;
        return this;
    }

    public MyUnlockedProject projectId(int projectId) {
        this.projectId = projectId;
        return this;
    }

    public MyUnlockedProject projectName(String projectName) {
        this.projectName = projectName;
        return this;
    }

    public MyUnlockedProject unlockedAt(Date unlockedAt) {
        this.unlockedAt = unlockedAt;
        return this;
    }

    public MyUnlockedProject shareTimes(int shareTimes) {
        this.shareTimes = shareTimes;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MyUnlockedProject)) {
            return false;
        }
        MyUnlockedProject myUnlockedProject = (MyUnlockedProject) o;
        return id == myUnlockedProject.id && userId == myUnlockedProject.userId && Objects.equals(userName, myUnlockedProject.userName) && projectId == myUnlockedProject.projectId && Objects.equals(projectName, myUnlockedProject.projectName) && Objects.equals(unlockedAt, myUnlockedProject.unlockedAt) && shareTimes == myUnlockedProject.shareTimes;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, userName, projectId, projectName, unlockedAt, shareTimes);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", userId='" + getUserId() + "'" +
            ", userName='" + getUserName() + "'" +
            ", projectId='" + getProjectId() + "'" +
            ", projectName='" + getProjectName() + "'" +
            ", unlockedAt='" + getUnlockedAt() + "'" +
            ", shareTimes='" + getShareTimes() + "'" +
            "}";
    }


}