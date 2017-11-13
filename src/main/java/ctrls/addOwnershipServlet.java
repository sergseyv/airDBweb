package ctrls;

import model.DbConnection;
import model.Input;
import model.mainObjects.Ownership;

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
@WebServlet(name = "addOwnershipServlet")
public class addOwnershipServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id_companies = request.getParameter("id_companies");

        if (Input.correct(id_companies)) {

            Ownership ownership = new Ownership();
            ownership.setIdCompany(Integer.parseInt(id_companies));

            String id_aircraft = request.getParameter("id_aircraft");
            String quantity = request.getParameter("quantity");

            if (Input.correct(id_aircraft)) ownership.setIdAircraft (Integer.parseInt(id_aircraft));
            if (Input.correct(quantity)) ownership.setQuantity (Integer.parseInt(quantity));

            Ownership.add(ownership);
        }
        doGet(request, response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DbConnection.getIstance().getConnection();

        request.setAttribute("ownershipArrayList", Ownership.selectAll(conn));
        request.getRequestDispatcher("view/addOwnership.jsp").forward(request, response);

    }
}
