package dao.impl;

import dao.UserDao;
import entity.User;
import utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImpl implements UserDao {

    @Override
    public User login(User user) {
        Connection con=null;
        PreparedStatement ps=null;
        ResultSet rs=null;

        try {
            con=BaseDao.getCon();//1:获取数据库的连接
            //2:书写sql语句
            String sql="select * from actor where first_name=?";
            ps=con.prepareStatement(sql);//3：预编译
            //4：设置值
            /*System.out.println(user.getFirstName());
            System.out.println(user.getActorId());*/

            ps.setString(1, user.getFirstName());
            rs=ps.executeQuery();//5:执行sql语句
            User users=null;
            System.out.println(rs);
            if(rs.next()){
                users=new User();
                //从数据库中获取值设置到实体类的setter方法中
                users.setActorId(rs.getInt("actor_id"));
                users.setFirstName(rs.getString("first_name"));
                users.setLastName(rs.getString("last_name"));
                users.setLastUpdate(rs.getTimestamp("last_update"));

                return users;
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
}
