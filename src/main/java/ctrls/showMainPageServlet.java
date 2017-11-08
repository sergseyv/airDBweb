package ctrls;

import model.*;
import model.mainObjects.Aircraft;
import model.mainObjects.Company;
import model.mainObjects.Ownership;
import model.resultObjects.*;
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

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll(conn));
        request.setAttribute("companiesArrayList", Company.selectAll(conn));
        request.setAttribute("ownershipArrayList", Ownership.selectAll(conn));

        request.setAttribute("select1ArrayList", ResSelect1.selectAll(conn));
        request.setAttribute("select2ArrayList", ResSelect2.selectAll(conn));
        request.setAttribute("select3ArrayList", ResSelect3.selectAll(conn));
        request.setAttribute("select4ArrayList", ResSelect4.selectAll(conn));

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);

    }
}
