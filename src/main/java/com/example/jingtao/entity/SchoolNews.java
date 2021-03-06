package com.example.jingtao.entity;

import com.example.jingtao.config.AddressConfig;

import java.util.Arrays;
import java.util.Date;

public class SchoolNews {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_news.title
     *
     * @mbggenerated
     */
    private String title;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_news.content
     *
     * @mbggenerated
     */
    private String content;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_news.time
     *
     * @mbggenerated
     */
    private Date time;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column school_news.img
     *
     * @mbggenerated
     */
    private byte[] img;

    public SchoolNews(String title, String content, Date time, byte[] img) {
        this.title = title;
        this.content = content;
        this.time = time;
        this.img = img;
    }

    @Override
    public String toString() {
        return "SchoolNews{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", time=" + time +
                ", img=" + Arrays.toString(img) +
                '}';
    }

    public SchoolNewsPlus toSchoolNewsPlus() {
        String url = AddressConfig.ip + "/news/getImg";
        return new SchoolNewsPlus(title, content, url + "?title=" + title, time);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_news.title
     *
     * @return the value of school_news.title
     * @mbggenerated
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_news.title
     *
     * @param title the value for school_news.title
     * @mbggenerated
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_news.content
     *
     * @return the value of school_news.content
     * @mbggenerated
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_news.content
     *
     * @param content the value for school_news.content
     * @mbggenerated
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_news.time
     *
     * @return the value of school_news.time
     * @mbggenerated
     */
    public Date getTime() {
        return time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_news.time
     *
     * @param time the value for school_news.time
     * @mbggenerated
     */
    public void setTime(Date time) {
        this.time = time;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column school_news.img
     *
     * @return the value of school_news.img
     * @mbggenerated
     */
    public byte[] getImg() {
        return img;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column school_news.img
     *
     * @param img the value for school_news.img
     * @mbggenerated
     */
    public void setImg(byte[] img) {
        this.img = img;
    }
}