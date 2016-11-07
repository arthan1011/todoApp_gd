package org.arthan.todo.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by arthan on 07.11.2016. | Project todoApp_gd
 */

@WebServlet(urlPatterns = "/all")
public class ToDoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setAttribute("items", "All Items here");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/jsp/all.jsp");
        dispatcher.forward(req, resp);
    }
}
