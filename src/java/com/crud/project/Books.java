/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.project;

/**
 *
 * @author saifi
 */
public class Books {
    int id;
    String bookName;
    String bookDesc;
    String authName;
    String category;

    public Books() {
    }

    public Books(int id, String bookName, String bookDesc, String authName, String category) {
        this.id = id;
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.authName = authName;
        this.category = category;
    }

    public Books(String bookName, String bookDesc, String authName, String category) {
        this.bookName = bookName;
        this.bookDesc = bookDesc;
        this.authName = authName;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookDesc() {
        return bookDesc;
    }

    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc;
    }

    public String getAuthName() {
        return authName;
    }

    public void setAuthName(String authName) {
        this.authName = authName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Books{" + "id=" + id + ", bookName=" + bookName + ", bookDesc=" + bookDesc + ", authName=" + authName + ", category=" + category + '}';
    }
    
}
