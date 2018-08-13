package servlet;


import dao.impl.FilmDaoIml;
import entity.Film;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/Film")
public class FilmServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //引入数据交互层
        FilmDaoIml dao = new FilmDaoIml();
        List films = dao.showAllFilms();
        /*for (int i=0;i<films.size();i++){
                    System.out.println(films.get(i).toString());
                }*/
        request.setAttribute("film_list",films);
        //测试返回的值
        System.out.println(films.size());
        request.getRequestDispatcher("/showfilms.jsp").forward(request, response);
    }
}
