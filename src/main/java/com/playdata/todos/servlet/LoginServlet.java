package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.Login;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("views/login.html").forward(req, resp);
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = new User(null, username, password, "name", null);
        UserDao userDao = new UserDao();
        userDao.insert(user);
        userDao.login("id","pw");
        resp.sendRedirect("/user");
        super.doPost(req, resp);
    }
}
