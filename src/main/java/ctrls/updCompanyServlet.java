package ctrls;

import model.Input;
import model.mainObjects.Company;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// Изменение значения Company в таблице, по ID
@WebServlet(name = "updCompanyServlet")
public class updCompanyServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Company company = new Company();

        //читаем с формы введенные значения
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String country = request.getParameter("country");

        /*
        Обработка введенных данных.
        Если строковое значение не указано, отправляем NULL, как флаг того,
        что данное поле остается без изменений.
         */
        company.setIdCompany(Integer.parseInt(id));// ID всегда верное, т.к. выбирается из списка
        company.setName(Input.correct(name) ? name : null);
        company.setCountry(Input.correct(country) ? country : null);

        Company.upd(company);// запись в базу

        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("companiesArrayList", Company.selectAll());
        request.getRequestDispatcher("view/updCompany.jsp").forward(request, response);
    }

}
