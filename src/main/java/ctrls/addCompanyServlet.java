package ctrls;

import model.Input;
import model.mainObjects.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


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

        request.setAttribute("companiesArrayList", Company.selectAll());
        request.getRequestDispatcher("view/addCompany.jsp").forward(request, response);

    }
}
