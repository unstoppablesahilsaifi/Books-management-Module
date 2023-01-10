<%-- 
    Document   : index
    Created on : 05-Jan-2023, 4:44:36 pm
    Author     : saifi
--%>

<%@page import="com.crud.project.Books"%>
<%@page import="java.util.List"%>
<%@page import="com.crud.project.Books"%>
<%@page import="com.crud.project.ConnectionDao"%>
<%@page import="com.crud.project.BooksDao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%
    BooksDao bookData = new BooksDao(ConnectionDao.getCon());
    List<Books> book = bookData.getAllBooks();
    request.setAttribute("BOOKS_LIST", book);
%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

        <title>CRUD Application</title>

        <style>
            .inner{
                margin: 15px 0;
            }
        </style>
    </head>
    <body>
        <div  class="container-fluid">
            <nav class="navbar navbar-light" style="background-color: #e3f2fd;">
                <a class="navbar-brand" >Book Store</a>
            </nav>
        </div>
        <div class="container">
            <div class="inner">
                <div class="row">
                    <div class="col-md-3">
                        <h3>
                            Input Book Information</h3>
                        <form action="AddBookServlet" method="post">
                            <div class="form-group">
                                <label>Book Name</label>
                                <input class="form-control" name="bname" place-holder="Book Name" required>
                            </div>
                            <div class="form-group">
                                <label>Description</label>
                                <input class="form-control" name="bdesc" place-holder="Book Name" required>
                            </div>
                            <div class="form-group">
                                <label>Author Name</label>
                                <input class="form-control" name="authname" place-holder="Book Name" required>
                            </div>
                            <div class="form-group" >
                                <label>Category</label>
                                <select id="inputState" class="form-control" name="category" required>
                                    <option selected disabled>Choose Category</option>
                                    <option value="Novel">Novel</option>
                                    <option value="Science Fiction">Science Fiction</option>
                                    <option value="Drama">Drama</option>
                                    <option value="Programming & Development">Programming & Development</option>
                                </select>
                            </div>
                            <button type="submit" class="btn btn-primary">Submit</button>
                            <button type="reset" class="btn btn-primary">Reset</button>
                        </form>
                    </div>
                    <div class="col-md-9">
                        <h3>
                            Book Information From Database</h3>
                        <table class="table">
                            <thead class="bg-light">
                                <tr>
                                    <th scope="col">Book Name</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Category</th>
                                    <th scope="col">Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="tempBook" items="${BOOKS_LIST}">
                                    <tr>
                                        <td>${tempBook.bookName }</td>
                                        <td>${tempBook.bookDesc }</td>
                                        <td>${tempBook.authName }</td>
                                        <td>${tempBook.category}</td>
                                        <td><a href="editbook.jsp?id=${tempBook.id }">Edit</a> 
                                            <a href="DeleteBookServlet?id=${tempBook.id}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
    </body>
</html>