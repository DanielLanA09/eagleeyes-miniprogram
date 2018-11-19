package com.eagleshing.miniprogram.domain;

import java.util.List;

public class HomeBlockResponse {

    private int id;

    private boolean active;

    private String name;

    private String blockImg;

    private int position;

    private String blockType;

    private List<ArticleLinkResponse> links;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getBlockType() {
        return blockType;
    }

    public void setBlockType(String blockType) {
        this.blockType = blockType;
    }

    public String getBlockImg() {
        return blockImg;
    }

    public void setBlockImg(String blockImg) {
        this.blockImg = blockImg;
    }

    public List<ArticleLinkResponse> getLinks() {
        return links;
    }

    public void setLinks(List<ArticleLinkResponse> links) {
        this.links = links;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
