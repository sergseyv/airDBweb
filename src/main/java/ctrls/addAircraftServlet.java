package ctrls;

import model.DBConnection;
import model.resultObjects.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Seyvach Serg on 07.11.2017.
 */
@WebServlet(name = "addAircraftServlet")
public class addAircraftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ObjAircraft aircraft = new ObjAircraft();
        aircraft.setName(request.getParameter("name"));
        aircraft.setPassengers(Integer.parseInt(request.getParameter("passengers")));
        aircraft.setMaxWeightKg(Integer.parseInt(request.getParameter("maxweight")));
        aircraft.setMaxRangeKm(Integer.parseInt(request.getParameter("maxrange")));

        ObjAircraft.add(aircraft);

        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getIstance().getConnection();

        request.setAttribute("aircraftsArrayList", ObjAircraft.selectAll(conn));
        request.getRequestDispatcher("view/addAirCraft.jsp").forward(request, response);
    }
}
