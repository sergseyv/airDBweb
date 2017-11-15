package ctrls;

import model.Input;
import model.mainObjects.Ownership;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Изменение значения Ownership в таблице, по ID
@WebServlet(name = "updOwnershipServlet")
public class updOwnershipServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ownership ownership = new Ownership();

        //читаем с формы введенные значения
        String idOwnership = request.getParameter("id");
        String idCompany = request.getParameter("id_companies");
        String idAircraft = request.getParameter("id_aircraft");
        String quantity = request.getParameter("quantity");

        /*
        Обработка введенных данных.
        Если числовое значение не указано, отправляем -1, как флаг того,
        что данное поле остается без изменений.
         */
        ownership.setIdOwnership(Integer.parseInt(idOwnership));// ID всегда верное, т.к. выбирается из списка
        ownership.setIdCompany(Input.correct(idCompany) ? Integer.parseInt(idCompany) : -1);
        ownership.setIdAircraft(Input.correct(idAircraft) ? Integer.parseInt(idAircraft) : -1);
        ownership.setQuantity(Input.correct(quantity) ? Integer.parseInt(quantity) : -1);

        Ownership.upd(ownership);// запись в базу

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("ownershipArrayList", Ownership.selectAll());
        request.getRequestDispatcher("view/updOwnership.jsp").forward(request, response);
    }
}
