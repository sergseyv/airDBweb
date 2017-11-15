package ctrls;

import model.mainObjects.Aircraft;
import model.mainObjects.Company;
import model.mainObjects.Ownership;
import model.resultObjects.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//получение текущих значений из всех таблиц, для вывода на главной странице
@WebServlet(name = "showMainPageServlet")
public class showMainPageServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("aircraftsArrayList", Aircraft.selectAll());
        request.setAttribute("companiesArrayList", Company.selectAll());
        request.setAttribute("ownershipArrayList", Ownership.selectAll());

        request.setAttribute("select1ArrayList", ResSelect1.selectAll());
        request.setAttribute("select2ArrayList", ResSelect2.selectAll());
        request.setAttribute("select3ArrayList", ResSelect3.selectAll());
        request.setAttribute("select4ArrayList", ResSelect4.selectAll());

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);

    }
}
