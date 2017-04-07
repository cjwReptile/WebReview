package dao;

import model.UserBean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by cjw on 2017/4/7.
 */
public class userDao {
      String driver="com.mysql.jdbc.Driver";
      String dbName="mysql";
      String passWord="root";
      String userName="root";
      String url="jdbc:mysql://localhost:3306/"+dbName;
      String sql="select * from cjw_user";
      ResultSet rs=null;
      Connection conn=null;
      PreparedStatement ps=null;
      List<UserBean> userBeanL=new ArrayList<UserBean>();

      public Connection  getConnection(){
          try {
               Class.forName(driver);
               conn= DriverManager.getConnection(url,userName,passWord);
          }catch (Exception e){
               e.printStackTrace();
          }
          return conn;
      }
      public UserBean getUserInfo(UserBean userBean){
          UserBean userBeanR =new UserBean();
          String sql="select userId as 'userId',password as 'passWord'from cjw_user where userId=?";
          Connection conn=getConnection();
          try {
              ps=conn.prepareStatement(sql);
              ps.setString(1,userBean.getUserId());
              rs=ps.executeQuery();
              while(rs.next()){
                  userBeanR.setUserId(rs.getString("userId"));
                  userBeanR.setPassWord(rs.getString("passWord"));
              }
          }catch (Exception e){
              e.printStackTrace();
          }finally {
              closeAll(rs,ps,conn);
          }

          return userBeanR;
      }
      public void closeAll(ResultSet rs,PreparedStatement ps,Connection conn){
           try {
               if(rs!=null){
                   rs.close();
               }
           }catch (Exception e){
               e.printStackTrace();
           }
          try {
              if(ps!=null){
                  ps.close();
              }
          }catch (Exception e){
              e.printStackTrace();
          }
          try {
              if(conn!=null){
                  conn.close();
              }
          }catch (Exception e){
              e.printStackTrace();
          }
      }
}
