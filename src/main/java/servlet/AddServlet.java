package servlet;

import dao.impl.FilmDaoIml;
import entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Film film = new Film();
        film.setTitle(request.getParameter("title"));
        film.setDescription(request.getParameter("description"));
        film.setLanguageName(request.getParameter("language"));
        //引入数据交互层
        System.out.println(request.getParameter("language"));
        FilmDaoIml dao = new FilmDaoIml();
        boolean flag = dao.addFilm(film);
        HttpSession session=request.getSession();
        if (flag){
            System.out.println("添加成功");
            session.setAttribute("sucess", "添加成功！");
            request.getRequestDispatcher("Film").forward(request, response);
        }else{

            request.setAttribute("message", "添加失败！");
            request.getRequestDispatcher("/showfilms.jsp").forward(request, response);
        }

    }
}
