package ctrls;

import model.*;
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

        request.setAttribute("aircraftsArrayList", ResAircraft.selectAll(conn));
        request.setAttribute("companiesArrayList", ResCompany.selectAll(conn));
        request.setAttribute("ownershipArrayList", ResOwnership.selectAll(conn));

        request.setAttribute("select1ArrayList", ResSelect1.selectAll(conn));
        request.setAttribute("select2ArrayList", ResSelect2.selectAll(conn));
        request.setAttribute("select3ArrayList", ResSelect3.selectAll(conn));
        request.setAttribute("select4ArrayList", ResSelect4.selectAll(conn));

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);

    }
}
