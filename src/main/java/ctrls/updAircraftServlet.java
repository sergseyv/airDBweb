package ctrls;

import model.Input;
import model.mainObjects.Aircraft;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Изменение значения Aircraft в таблице, по ID
@WebServlet(name = "updAircraftServlet")
public class updAircraftServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Aircraft aircraft = new Aircraft();

        //читаем с формы введенные значения
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String passengers = request.getParameter("passengers");
        String maxweight = request.getParameter("maxweight");
        String maxrange = request.getParameter("maxrange");

        /*
        Обработка введенных данных.
        Если строковое значение не указано, отправляем NULL, как флаг того,
        что данное поле остается без изменений.
        Если числовое значение не указано, отправляем -1, как флаг того,
        что данное поле остается без изменений.
         */
        aircraft.setIdAircraft(Integer.parseInt(id)); // ID всегда верное, т.к. выбирается из списка
        aircraft.setName(Input.correct(name) ? name : null);
        aircraft.setPassengers(Input.correct(passengers) ? Integer.parseInt(passengers) : -1);
        aircraft.setMaxWeightKg(Input.correct(maxweight) ? Integer.parseInt(maxweight) : -1);
        aircraft.setMaxRangeKm(Input.correct(maxrange) ? Integer.parseInt(maxrange) : -1);

        Aircraft.upd(aircraft);// запись в базу

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll());
        request.getRequestDispatcher("view/updAircraft.jsp").forward(request, response);
    }
}
