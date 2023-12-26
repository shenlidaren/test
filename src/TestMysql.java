import java.sql.*;

public class TestMysql {
    public static void main(String[] args) {
        // 连接数据库
        try {
            String url = "jdbc:mysql://localhost/test";  // 数据库连接URL
            String username = "root";
            String password = "123";
            Connection conn = DriverManager.getConnection(url, username, password);
            System.out.println("数据库连接成功！");

            // 创建表
            Statement stmt = conn.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS test (id INT PRIMARY KEY, name VARCHAR(50), age INT)";
            stmt.executeUpdate(createTableQuery);
            System.out.println("表创建成功！");

            // 插入数据
            String insertDataQuery = "INSERT INTO test (id, name, age) VALUES (1, 'Alice', 20)";
            stmt.executeUpdate(insertDataQuery);
            System.out.println("数据插入成功！");

            // 查询数据
            String selectDataQuery = "SELECT * FROM test";
            ResultSet resultSet = stmt.executeQuery(selectDataQuery);
            System.out.println("查询结果：");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                System.out.println("ID: " + id + ", Name: " + name + ", Age: " + age);
            }

            // 关闭连接
            resultSet.close();
            stmt.close();
            conn.close();
            System.out.println("数据库连接已关闭！");
        } catch (SQLException e) {
            System.out.println("数据库连接失败！");
            e.printStackTrace();
        }
    }
}