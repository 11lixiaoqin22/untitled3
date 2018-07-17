package opp.lib;

import java.sql.*;
import java.util.Scanner;


/**
 * Created by Administrator on 2018/7/17.
 */
public class chaxun {
    private Connection getConnection() {
        //1.加载驱动器
        try {
            Class.forName("com.mysql.jdbc.lib");
            //2.创建数据库连接字符串
            String dbURL = "jdbc:mysql://localhost:3306/library";
            //3.建立数据库连接
            try {
                Connection connection = DriverManager.getConnection(dbURL, "root", "root");
                return connection;

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

        public void insertData(int id, String accountValue, String password) {
            Connection connection =null;
            Statement statement =null;

            try {
                connection = getConnection();
                //2.构建添加数据的sql语句
                String sql = "insert into account values("+ id +",'"+accountValue +"','"+ password +")";
                //3.执行sql语句
                statement = connection.createStatement();
                //4.得到执行后的结果，确定是否添加成功
                int rows = statement.executeUpdate(sql);
                System.out.println("所影响的行数为：" + rows);

            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try{
                    if(statement != null) {
                        statement.close();
                    }
                    if(connection != null){
                        connection.close();

                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                close(connection, statement, null);
            }
        }
    private void updateData(int id, String account, String password) {
        Connection connection = null;
        Statement statement = null;

        try {

            connection = getConnection();
            //2.创建update sql 语句
            String sql = "Update account set" + " user_account='" + account + "',user_password='" + password + "'" + "where id=" + id + "";
            //3.执行Update语句
            statement = connection.createStatement();
            //4.得到执行结果，确定是否成功
            int rows = statement.executeUpdate(sql);
            System.out.println("更新结果为：" + (rows > 0));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try{
                if(statement != null) {
                    statement.close();
                }
                if(connection != null){
                    connection.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            close(connection, statement, null);
        }
    }

    private    void deleteData(int id){
        Connection connection =null;
        Statement statement =null;
        ResultSet resultSet=null;

        try {
            connection = getConnection();
            //2.构建删除的的sql语句
            String sql = "delete from account where id="+id+"";
            //3.执行删除语句
            statement = (Statement) connection.createStatement();
            //4.获取执行所影响的行数，判断是否执行成功
            int rows = statement.executeUpdate(sql);
            System.out.println("有" + rows +"行被删除成功！");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            try{
                if(statement != null) {
                    statement.close();
                }
                if(connection != null){
                    connection.close();

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            close(connection, statement, null);
        }
    }
    private  void  findAccountDataById(int id){
        //1.获取数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet =null;
        //2.
        String sql = "select user_account,user_password,id from account where id=" +id;
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            StringBuffer buffer = new StringBuffer();
            buffer.append("------------------------------------------");
            System.out.println(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement,resultSet);
        }
    }


    /********
     * 模糊搜索数据，根据用户输入的关键词来模糊查询
     * @param keyWord
     */
    private  void findAccountDataLikeKey(String keyWord) {
        //1.获取数据库连接
        Connection connection = getConnection();
        Statement statement = null;
        ResultSet resultSet =null;
        //2.构建查询的sql语句
        String sql = "select user_account,user_password,id from account " + "where user_account like '%'"
                + keyWord + "%' or user_password like '%" + keyWord;
        try {
            //3.执行sql语句，并获得结果集
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            //4.遍历结果集，输出每条记录的信息
            StringBuffer buffer = new StringBuffer();
            buffer.append("-----------------------------------------------------------------");
            System.out.println(buffer.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            close(connection,statement,resultSet);
        }
    }

    private void   close(Connection connection, Statement statement, ResultSet resultSet){
        try{
            if(resultSet != null){
                resultSet.close();
            }
            if(statement != null) {
                statement.close();
            }
            if(connection != null){
                connection.close();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    public  static  void  main(String[]args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("----------------------------------------------------------");
        System.out.println("---------------------书籍管理系统--------------------------");
        System.out.println("1.添加书籍  2.修改书籍  3.删除书籍  4.查询所有书籍  5.选择查询 6.退出系统");
        System.out.println("请输入你的选择：");
        while (true){
            int change=scanner.nextInt();
            while (change<1|| change>6){
                System.out.println("输入错误，再次选择");
                change=scanner.nextInt();
            }
            switch (change){
                case 1:
                    System.out.println("添加书籍请输入id,书籍名，出版社");
                    break;
                case 2:
                    System.out.println("请输入你要修改的书籍名，");
                    break;

                case 3:
                    System.out.println("-----------------------------------");
                    break;
                case 4:
                    System.out.println("-----------------------------------");
                    break;
                case 5:
                    System.out.println("-----------------------------------");
                    break;
                case 6:
                    System.out.println("退出系统");
                    System.exit(-1);
                    break;

            }
        }
    }
}
