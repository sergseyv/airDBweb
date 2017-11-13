package ctrls;

import model.DbConnection;
import model.Input;
import model.mainObjects.Company;

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
@WebServlet(name = "updCompanyServlet")
public class updCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        Company company = new Company();

        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        company.setIdCompany(Integer.parseInt(id));
        company.setName(Input.correct(name) ? name : null);
        company.setCountry(Input.correct(country) ? country : null);

        Company.upd(company);

        doGet(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DbConnection.getIstance().getConnection();

        request.setAttribute("companiesArrayList", Company.selectAll(conn));
        request.getRequestDispatcher("view/updCompany.jsp").forward(request, response);


    }
}
