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
@WebServlet(name = "addCompanyServlet")
public class addCompanyServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        if (Input.correct(name)) {

            Company company = new Company();
            company.setName(name);

            String country = request.getParameter("country");

            if (Input.correct(country)) company.setCountry(country);

            Company.add(company);
        }
        doGet(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DbConnection.getIstance().getConnection();

        request.setAttribute("companiesArrayList", Company.selectAll());
        request.getRequestDispatcher("view/addCompany.jsp").forward(request, response);

    }
}
