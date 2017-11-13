package ctrls;

import model.Input;
import model.mainObjects.Ownership;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "updOwnershipServlet")
public class updOwnershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ownership ownership = new Ownership();

        String idOwnership = request.getParameter("id");
        String idCompany = request.getParameter("id_companies");
        String idAircraft = request.getParameter("id_aircraft");
        String quantity = request.getParameter("quantity");

        ownership.setIdOwnership(Integer.parseInt(idOwnership));
        ownership.setIdCompany(Input.correct(idCompany) ? Integer.parseInt(idCompany) : -1);
        ownership.setIdAircraft(Input.correct(idAircraft) ? Integer.parseInt(idAircraft) : -1);
        ownership.setQuantity(Input.correct(quantity) ? Integer.parseInt(quantity) : -1);

        Ownership.upd(ownership);

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("ownershipArrayList", Ownership.selectAll());
        request.getRequestDispatcher("view/updOwnership.jsp").forward(request, response);
    }
}
