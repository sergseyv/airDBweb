package ctrls;

import model.Input;
import model.mainObjects.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Добавление Company в таблицу
@WebServlet(name = "addCompanyServlet")
public class addCompanyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        // Добавление происходит, только если имя не пустое
        if (Input.correct(name)) {

            Company company = new Company();
            company.setName(name);

            //читаем с формы введенное значение
            String country = request.getParameter("country");

            // добавялем не пустое значение
            if (Input.correct(country))
                company.setCountry(country);

            Company.add(company); // запись в базу
        }

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // обновление страницы с обновленными данными
        request.setAttribute("companiesArrayList", Company.selectAll());
        request.getRequestDispatcher("view/addCompany.jsp").forward(request, response);
    }
}
