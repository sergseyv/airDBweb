package ctrls;

import model.Input;
import model.mainObjects.Ownership;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Добавление Ownership в таблицу
@WebServlet(name = "addOwnershipServlet")
public class addOwnershipServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_companies = request.getParameter("id_companies");

        // Добавление происходит, только если ID компании не пустое
        if (Input.correct(id_companies)) {

            Ownership ownership = new Ownership();
            ownership.setIdCompany(Integer.parseInt(id_companies));

            //читаем с формы введенные значения
            String id_aircraft = request.getParameter("id_aircraft");
            String quantity = request.getParameter("quantity");

            // добавляем не пустые значения
            if (Input.correct(id_aircraft))
                ownership.setIdAircraft (Integer.parseInt(id_aircraft));
            if (Input.correct(quantity))
                ownership.setQuantity (Integer.parseInt(quantity));

            Ownership.add(ownership);  // запись в базу
        }

        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // обновление страницы с обновленными данными
        request.setAttribute("ownershipArrayList", Ownership.selectAll());
        request.getRequestDispatcher("view/addOwnership.jsp").forward(request, response);
    }
}
