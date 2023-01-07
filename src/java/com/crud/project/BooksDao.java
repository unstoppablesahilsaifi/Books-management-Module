/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.project;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    // Retrive book data  from table
    public List<Books> getAllBooks() {
        List<Books> book = new ArrayList<>();
        try {
            String q = "select * from books";
            PreparedStatement pt = this.con.prepareStatement(q);
            ResultSet rs = pt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String bname = rs.getString("book_name");
                String bdesc = rs.getString("description");
                String aname = rs.getString("author_name");
                String category = rs.getString("category");

                Books row = new Books(id, bname, bdesc, aname, category);
                book.add(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return book;
    }

    //    get single book information in edit page
    public Books getSingleBook(int id) {
        Books bk = null;

        try {
            String query = "select * from books where id=? ";

            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setInt(1, id);
            ResultSet rs = pt.executeQuery();

            while (rs.next()) {
                int bid = rs.getInt("id");
                String bname = rs.getString("book_name");
                String bdesc = rs.getString("description");
                String authname = rs.getString("author_name");
                String category = rs.getString("category");
                bk = new Books(bid, bname, bdesc, authname, category);
            }
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
        return bk;
    }

//    eidt book information
    public boolean editBookInfo(Books book) {
           boolean test=false;
        try {
            String query = "update books set book_name=?, description=?, author_name=?, category=? where id=?";
            PreparedStatement pt = this.con.prepareStatement(query);
            pt.setString(1, book.getBookName());
            pt.setString(2, book.getBookDesc());
            pt.setString(3, book.getAuthName());
            pt.setString(4, book.getCategory());
            pt.setInt(5, book.getId());

            pt.executeUpdate();
            test=true;
        } catch (Exception ex) {
            ex.printStackTrace();;
        }
        return test;
        

    }
    //    delete books from database
    
    
    public void deleteBook(int id){
        try{
            
           String query= "delete from books where id=?";
           PreparedStatement pt = this.con.prepareStatement(query);
           pt.setInt(1, id);
           pt.execute();
            
        }catch(Exception ex){
            ex.printStackTrace();;
        }
    }
}
