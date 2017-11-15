package ctrls;

import model.DbWork;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// восстановление тестовой БД в первоначальный вид
@WebServlet(name = "restoreDBServlet")
public class restoreDBServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DbWork.restoreDb();
        response.sendRedirect("showmainpage");
    }
}