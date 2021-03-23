package com.sifunit.lanwei.domain;

public class Perm {
    private Integer permId;

    private String permUrl;

    private String permDescription;

    public Perm(Integer permId, String permUrl, String permDescription) {
        this.permId = permId;
        this.permUrl = permUrl;
        this.permDescription = permDescription;
    }

    public Perm() {
        super();
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

    public String getPermUrl() {
        return permUrl;
    }

    public void setPermUrl(String permUrl) {
        this.permUrl = permUrl == null ? null : permUrl.trim();
    }

    public String getPermDescription() {
        return permDescription;
    }

    public void setPermDescription(String permDescription) {
        this.permDescription = permDescription == null ? null : permDescription.trim();
    }
}