package com.earaujo.poc.myapplication;

import java.io.Serializable;

/**
 * Created by hersonrodrigues on 28/10/17.
 */

public class Brand implements Serializable {

    public static final int FOLLOW_INACTIVE = 0;
    public static final int FOLLOW_PROCESS = 1;
    public static final int FOLLOW_ACTIVE = 2;

    private String id;
    private String name;
    private String schemeUrl;
    private String icon;
    private String phone1;
    private String phone2;
    private String site;
    private int domainId;
    private String lastvisitedAt;
    private String customerProfile;
    private int following;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchemeUrl() {
        return schemeUrl;
    }

    public void setSchemeUrl(String schemeUrl) {
        this.schemeUrl = schemeUrl;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public int getDomainId() {
        return domainId;
    }

    public void setDomainId(int domainId) {
        this.domainId = domainId;
    }

    public String getLastvisitedAt() {
        return lastvisitedAt;
    }

    public void setLastvisitedAt(String lastvisitedAt) {
        this.lastvisitedAt = lastvisitedAt;
    }

    public String getCustomerProfile() {
        return customerProfile;
    }

    public void setCustomerProfile(String customerProfile) {
        this.customerProfile = customerProfile;
    }

    public int getFowllowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

}