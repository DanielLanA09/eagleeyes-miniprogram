package com.eagleshing.miniprogram.payload;

/**
 * UnlockProjectRequest
 */
public class UnlockProjectRequest {

    private int projectId;

    private int userId;

    public int getProjectId() {
        return this.projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}