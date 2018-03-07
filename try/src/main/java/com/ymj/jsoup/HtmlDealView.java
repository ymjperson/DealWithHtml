package com.ymj.jsoup;

public class HtmlDealView {

    private String picUrl;
    private String text;
    private String htmlFile;

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getHtmlFile() {
        return htmlFile;
    }

    public void setHtmlFile(String htmlFile) {
        this.htmlFile = htmlFile;
    }

    public String toString(){
        return "picUrl:" + this.picUrl + "\ntext:" + this.text + "\nhtmlFile:\n" + this.htmlFile;
    }

}
