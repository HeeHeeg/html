package com.playdata.todos.servlet;

import com.playdata.todos.dao.UserDao;
import com.playdata.todos.dto.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        req.getRequestDispatcher("views/user.html").forward(req, resp);  // 페이지를 보여주겠다~

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String name = req.getParameter("name");
//        System.out.println(username);
//        System.out.println(password);
//        System.out.println(name);
        User user = new User(null, username, password, name, null);
        UserDao userDao = new UserDao();
        userDao.insert(user);

        resp.sendRedirect("/user"); // 추가 후 재실행 해봄  이 서버로 보내버리는것.? 그럼 다시 doget으로 가서 페이지를 다시 보여주는 것.
        resp.setStatus(201);

    }
}