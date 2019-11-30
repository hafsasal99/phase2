package com.Model;

public class newsfeedModel {
    private String caption;
    private String username;
    private int profilePic;
    private int photo;
    newsfeedModel(String u,String c, int p, int photo)
    {
        this.caption=c;
        this.username=u;
        this.profilePic=p;
        this.photo=photo;

    }
    public void setCaption(String c)
    {
        this.caption=c;
    }
    public void setUsername(String u)
    {
        this.username=u;
    }
    public void setProfilePic(int n)
    {
        profilePic=n;
    }
    public void setPhoto(int n)
    {
        photo=n;
    }
    public int getProfilePic()
    {
        return profilePic;
    }
    public int getPhoto()
    {
        return photo;
    }
    public String getUsername()
    {
        return username;
    }
    public String getCaption()
    {
        return caption;
    }
}
