package com.ymj.jsoup;

import java.io.IOException;

import com.alibaba.fastjson.JSONObject;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;



/**
 * @author Yu
 *
 */
public class App 
{

    /**
     * deal with html file or html string
     */
    public HtmlDealView dealHtml(Document document){
        HtmlDealView htmlDealView = new HtmlDealView();

        //get text of html file
        String text = document.body().text();
        htmlDealView.setText(text);

        //get url of the first pic
        Elements images = document.select("img[src~=(?i)\\.(png|jpe?g|gif|svg|bmp)]");
        if(images.isEmpty()){
            htmlDealView.setPicUrl("none picture!");
        }
        htmlDealView.setPicUrl(images.first().attr("src"));

        //delete the width,height,style attr
        Elements widths = document.select("[width]");
        if(!widths.isEmpty()){
            widths.forEach(width->{
                width.removeAttr("width");
            });
        }
        Elements heights = document.select("[height]");
        if(!heights.isEmpty()){
            heights.forEach(height->{
                height.removeAttr("height");
            });
        }
        Elements styles = document.select("style");
        if(!styles.isEmpty()){
            styles.forEach(style->{
                style.remove();
            });
        }
        Elements wts = document.select("[style]");
        if(!wts.isEmpty()){
            wts.forEach(wt->{
                wt.removeAttr("style");
            });
        }
        htmlDealView.setHtmlFile(document.toString());
        return htmlDealView;
    }

    public static void main( String[] args ) throws IOException
    {
        App app = new App();

        String html = "";
//        Document document = Jsoup.parse(html);

        HtmlDealView htmlDealView = new HtmlDealView();
        Document document = Jsoup.connect("https://www.cnblogs.com/chenjfblog/p/7685579.html").get();

        //get the url of the first image
        htmlDealView = app.dealHtml(document);
        System.out.println(htmlDealView.toString());
    }
}
