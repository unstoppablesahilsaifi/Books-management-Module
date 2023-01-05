/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.project;

import java.sql.*;
/**
 *
 * @author saifi
 */
// This Class is used to  handle CRUD operation
public class BooksDao {

    Connection con;

    public BooksDao(Connection con) {
        this.con = con;
    }
    // This is main mathod to perform CRUD Operation.
    // 1. Add book to database.

    // Here we are passing books type book object.
    public boolean addBook(Books book) {
        boolean test = false;
        String q = "insert into books(book_name,description,author_name,category) values(?,?,?,?)";
        try {
            PreparedStatement pst = this.con.prepareStatement(q);
            // Here we will set the data (we are getting the book name from the book object of the class books)
            pst.setString(1, book.getBookName());
            pst.setString(2, book.getBookDesc());
            pst.setString(3, book.getAuthName());
            pst.setString(4, book.getCategory());
            pst.executeUpdate();
            test = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return test;

    }
}
