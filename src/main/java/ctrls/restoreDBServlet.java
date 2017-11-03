package ctrls;

import model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.util.List;

/**
 * Created by Seyvach Serg on 31.10.2017.
 */
@WebServlet(name = "restoreDBServlet")
public class restoreDBServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DBConnection dbConnection = DBConnection.getIstance();
        Connection conn = dbConnection.getConnection();

        RestoreDB.restore(conn);

        List <entityAircraft> listAircrafts = entityAircraft.selectAll(conn);  //TODO селект в скобки сразу засунуть

        request.setAttribute("st1", listAircrafts);
        request.getRequestDispatcher("view/restore.jsp").forward(request, response);






        dbConnection.closeConnection();
    }
}