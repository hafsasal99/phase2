package com.Model;

public class profileModel {


    private String  date;
    private String postcontent;
    private static String name;
    private static int profilepic;

    public profileModel(String date, String postcontent){

        this.date=new String(date);
        this.postcontent=new String(postcontent);

    }

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        profileModel.name = name;
    }

    public static int getProfilepic() {
        return profilepic;
    }

    public static void setProfilepic(int profilepic) {
        profileModel.profilepic = profilepic;
    }

   public String getDate(){
        return date;
    }

   public String getPostcontent(){
        return postcontent;
    }

   public void setDate(String date1){
        this.date= date1;
    }

   public void setPostcontent(String postcontent1){
        this.postcontent=postcontent1;
    }

}
