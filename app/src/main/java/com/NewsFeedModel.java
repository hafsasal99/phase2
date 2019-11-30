package com;

public class NewsFeedModel {
    private String caption;

    private String username;
    private int profilePhoto;
    private int photo;
    private int supportStatus;
    private String supportCount;

    public int getSupportStatus() {
        return supportStatus;
    }

    public void setSupportStatus(int supportStatus) {
        this.supportStatus = supportStatus;
    }

    public String getSupportCount() {
        return supportCount;
    }

    public void setSupportCount(String supportCount) {
        this.supportCount = supportCount;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getProfilePhoto() {
        return profilePhoto;
    }

    public void setProfilePhoto(int profilePhoto) {
        this.profilePhoto = profilePhoto;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public NewsFeedModel(String u, String c, int dp, int pic,int support,String count)
    {
        this.username=u;
        this.caption=c;
        this.profilePhoto=dp;
        this.photo=pic;
        this.supportStatus=support;
        this.supportCount=count;
    }


}

