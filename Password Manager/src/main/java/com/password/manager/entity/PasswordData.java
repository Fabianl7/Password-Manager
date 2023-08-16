package com.password.manager.entity;

import java.util.Objects;

/**
 * @author XDSSWAR
 * Created on 03/16/2023
 */
public class PasswordData {
   private String title;
   private String username;
   private String password;
   private String url;

    public PasswordData() {
    }

    public PasswordData(String title, String username, String password, String url) {
        this.title = title;
        this.username = username;
        this.password = password;
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    //public String getPasswordField(){
    //    return getPasswordField();
    //}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PasswordData that = (PasswordData) o;
        return Objects.equals(title, that.title) && Objects.equals(username, that.username) && Objects.equals(password, that.password) && Objects.equals(url, that.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, username, password, url);
    }

    @Override
    public String toString() {
        return "PasswordData{" +
                "title='" + title + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
