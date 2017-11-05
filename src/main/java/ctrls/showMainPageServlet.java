package ctrls;

import model.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Seyvach Serg on 05.11.2017.
 */
@WebServlet(name = "showMainPageServlet")
public class showMainPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getIstance().getConnection();

        request.setAttribute("aircraftsArrayList", entityAircraft.selectAll(conn));
        request.setAttribute("companiesArrayList", entityCompany.selectAll(conn));
        request.setAttribute("ownershipsArrayList", entityOwnership.selectAll(conn));

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);

    }
}