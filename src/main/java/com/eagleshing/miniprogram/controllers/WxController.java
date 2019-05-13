package com.eagleshing.miniprogram.controllers;

import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eagleshing.miniprogram.domain.repository.WxTokenRepository;

@RestController
@RequestMapping("/wx")
public class WxController {

    @Autowired
    private WxTokenRepository wxTokenRepository;

    @GetMapping("/signature")
    public String getSignature(String randomStr,String timeStamp,String callurl){
        String noncestr = randomStr;
        String jsapi_ticket = wxTokenRepository.getOne(1).getWxTicket();
        String timestamp = timeStamp;
        String url=callurl;
        String ticket = "jsapi_ticket=" + jsapi_ticket +"&noncestr=" + noncestr +"&timestamp=" + timestamp +"&url="+url;
       
        return DigestUtils.sha1Hex(ticket);
    }

}
