package dao.impl;

import dao.FilmDao;
import entity.Film;
import utils.BaseDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FilmDaoIml implements FilmDao {
    @Override
    public List showAllFilms() {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="SELECT film_id,title,description,gua.name FROM film,LANGUAGE gua WHERE film.language_id=gua.language_id";
            ps=con.prepareStatement(sql);//3：预编译
            rs=ps.executeQuery();

            ResultSetMetaData rsm=rs.getMetaData();
            int colCount = rsm.getColumnCount();
            System.out.println(rs);
            List films = new ArrayList();
            if(rs.next()){
                while (rs.next()){

                    /*Film film=null;
                    film=new Film();
                    //从数据库中获取值设置到实体类的setter方法中
                    film.setFilmId(rs.getInt("film_id"));
                    film.setTitle(rs.getString("title"));
                    film.setDescription(rs.getString("description"));
                    film.setLanguageName(rs.getString("name"));
                    films.add(film);
                    System.out.println(rs.getString("name"));*/

                    Map<String,Object> rowData = new HashMap<>();
                    for (int i = 1; i <= colCount; i++) {
                        rowData.put(rsm.getColumnName(i), rs.getObject(i));
                    }
                    films.add(rowData);
                }
                //测试
                /*for (int i=0;i<films.size();i++){
                    System.out.println(films.get(i).toString());
                }
*/
                return films;
            }else{
                return null;
            }

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } catch (SQLException e) {

            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean addFilm(Film film) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int flag=0;
        System.out.println(film.getLanguageName());
        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="insert into film (title,description,language_id) values (?,?,?)";
            ps=con.prepareStatement(sql);//3：预编译
            ps.setString(1,film.getTitle());
            ps.setString(2,film.getDescription());
            ps.setString(3,film.getLanguageName());
            System.out.println(film.getLanguageName());
            flag=ps.executeUpdate();
            System.out.println(flag);

        } catch (SQLException e) {

            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return flag==1;
    }
}
