package ctrls;

import model.DBConnection;
import model.Input;
import model.mainObjects.Aircraft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Seyvach Serg on 09.11.2017.
 */
@WebServlet(name = "updAircraftServlet")
public class updAircraftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Aircraft aircraft = new Aircraft();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String passengers = request.getParameter("passengers");
        String maxweight = request.getParameter("maxweight");
        String maxrange = request.getParameter("maxrange");

        aircraft.setIdAircraft(Integer.parseInt(id));
        aircraft.setName(Input.correct(name) ? name : null);
        aircraft.setPassengers(Input.correct(passengers) ? Integer.parseInt(passengers) : -1);
        aircraft.setMaxWeightKg(Input.correct(maxweight) ? Integer.parseInt(maxweight) : -1);
        aircraft.setMaxRangeKm(Input.correct(maxrange) ? Integer.parseInt(maxrange) : -1);

        Aircraft.upd(aircraft);











/*




        int id1 = aircraft.getIdAircraft();
        String name1 = aircraft.getName();
        int passengers1 = aircraft.getPassengers();
        int maxweight1 = aircraft.getMaxWeightKg();
        int maxrange1 = aircraft.getMaxRangeKm();

        if ( ( name1 != null ) || ( passengers1 >= 0 ) || ( maxweight1 >= 0 ) || ( maxrange1 >= 0 ) ) {

            StringBuilder query = new StringBuilder("UPDATE `aircrafts` SET ");

            if ( name1 != null )
                query.append("name = `").append(name1).append("`, ");
            if ( passengers1 >= 0 )
                query.append("passengers = `").append(passengers1).append("`, ");
            if ( maxweight1 >= 0 )
                query.append("max_weight__kg = `").append(maxweight1).append("`, ");
            if ( maxrange1 >= 0 )
                query.append("max_range__km = `").append(maxrange1).append("`, ");

        }


*/



















        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getIstance().getConnection();

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll(conn));
        request.getRequestDispatcher("view/updAircraft.jsp").forward(request, response);
    }
}
