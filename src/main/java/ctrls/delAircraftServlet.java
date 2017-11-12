package ctrls;

import model.DBConnection;
import model.mainObjects.Aircraft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Seyvach Serg on 12.11.2017.
 */
@WebServlet(name = "delAircraftServlet")
public class delAircraftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Aircraft.del(request.getParameter("id"));
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getIstance().getConnection();

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll(conn));
        request.getRequestDispatcher("view/delAircraft.jsp").forward(request, response);
    }
}
