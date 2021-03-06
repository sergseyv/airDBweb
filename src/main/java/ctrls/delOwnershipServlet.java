package ctrls;

import model.mainObjects.Ownership;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


// удаление Ownership по ID
@WebServlet(name = "delOwnershipServlet")
public class delOwnershipServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ownership.del(request.getParameter("id"));
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("ownershipArrayList", Ownership.selectAll());
        request.getRequestDispatcher("view/delOwnership.jsp").forward(request, response);
    }
}
