package ctrls;

import model.*;
import model.resultObjects.ObjAircraft;
import model.resultObjects.ObjCompany;
import model.resultObjects.ObjOwnership;
import model.resultObjects.ObjSelect1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;

/**
 * Created by Seyvach Serg on 05.11.2017.
 */
@WebServlet(name = "showMainPageServlet")
public class showMainPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Connection conn = DBConnection.getIstance().getConnection();

        request.setAttribute("aircraftsArrayList", ObjAircraft.selectAll(conn));
        request.setAttribute("companiesArrayList", ObjCompany.selectAll(conn));
        request.setAttribute("ownershipsArrayList", ObjOwnership.selectAll(conn));

        request.setAttribute("select1ArrayList", ObjSelect1.selectAll(conn));

        request.getRequestDispatcher("view/mainPage.jsp").forward(request, response);

    }
}
