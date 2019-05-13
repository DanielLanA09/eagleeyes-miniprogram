package com.eagleshing.miniprogram.domain;

import javax.persistence.*;

@Entity
@Table(name = "wx_token")
public class WxToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 255,name = "wx_access_token")
    private String wxAccessToken;

    @Column(length = 255,name = "wx_ticket")
    private String wxTicket;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWxAccessToken() {
        return wxAccessToken;
    }

    public void setWxAccessToken(String wxAccessToken) {
        this.wxAccessToken = wxAccessToken;
    }

    public String getWxTicket() {
        return wxTicket;
    }

    public void setWxTicket(String wxTicket) {
        this.wxTicket = wxTicket;
    }
}
