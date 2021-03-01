package com.theekshana.codefestexam.Model;

public class NewsModel {

    String newsTitle;
    String newsDescription;
    String newslocation;
    String newstime;
    String newsImage;

    public NewsModel() {
    }

    public NewsModel(String newsTitle, String newsDescription, String newslocation, String newstime, String newsImage) {
        this.newsTitle = newsTitle;
        this.newsDescription = newsDescription;
        this.newslocation = newslocation;
        this.newstime = newstime;
        this.newsImage = newsImage;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsDescription() {
        return newsDescription;
    }

    public void setNewsDescription(String newsDescription) {
        this.newsDescription = newsDescription;
    }

    public String getNewslocation() {
        return newslocation;
    }

    public void setNewslocation(String newslocation) {
        this.newslocation = newslocation;
    }

    public String getNewstime() {
        return newstime;
    }

    public void setNewstime(String newstime) {
        this.newstime = newstime;
    }

    public String getNewsImage() {
        return newsImage;
    }

    public void setNewsImage(String newsImage) {
        this.newsImage = newsImage;
    }
}
