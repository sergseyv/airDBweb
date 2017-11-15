package ctrls;

import model.Input;
import model.mainObjects.Aircraft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "addAircraftServlet")
public class addAircraftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        if (Input.correct(name)) {

            Aircraft aircraft = new Aircraft();
            aircraft.setName(name);

            String passengers = request.getParameter("passengers");
            String maxweight = request.getParameter("maxweight");
            String maxrange = request.getParameter("maxrange");
            if (Input.correct(passengers)) aircraft.setPassengers(Integer.parseInt(passengers));
            if (Input.correct(maxweight)) aircraft.setMaxWeightKg(Integer.parseInt(maxweight));
            if (Input.correct(maxrange)) aircraft.setMaxRangeKm(Integer.parseInt(maxrange));

            Aircraft.add(aircraft);
        }

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll());
        request.getRequestDispatcher("view/addAircraft.jsp").forward(request, response);
    }
}
