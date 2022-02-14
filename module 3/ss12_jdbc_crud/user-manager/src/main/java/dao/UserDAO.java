package dao;

import model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO{
    private String jdbcURL = "jdbc:mysql://localhost:3306/thi_ket_thuc_module?useSSL=false";
    private String jdbcUsername = "root";
    private String jdbcPassword = "123456789";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (dien_tich, trang_thai, tang, loai_van_phong, gia_tien, ngay_bat_dau, ngay_ket_thuc) VALUES " +
            " (?, ?, ?);";

    private static final String SELECT_USER_BY_ID = "select dien_tich, trang_thai, tang, loai_van_phong, gia_tien, ngay_bat_dau, ngay_ket_thuc from users where ma_mat_bang =?";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String DELETE_USERS_SQL = "delete from users where ma_mat_bang = ?;";
    private static final String UPDATE_USERS_SQL = "update users set dien_tich = ?, trang_thai = ?, tang =?, loai_van_phong = ?, gia_tien = ?, ngay_bat_dau = ?, ngay_ket_thuc = ? where ma_mat_bang = ?;";

    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        // try-with-resource statement will auto close the connection.
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public User selectUser(int ma_mat_bang) {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, ma_mat_bang);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String dien_tich = rs.getString("dien_tich");
                String trang_thai = rs.getString("trang_thai");
                String tang = rs.getString("tang");
                String loai_van_phong = rs.getString("loai_van_phong");
                String gia_tien = rs.getString("gia_tien");
                String ngay_bat_dau = rs.getString("ngay_bat_dau");
                String ngay_ket_thuc = rs.getString("ngay_ket_thuc ");
                user = new User(ma_mat_bang, dien_tich, trang_thai, tang, loai_van_phong,gia_tien, ngay_bat_dau, ngay_ket_thuc);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return user;
    }

    public List<User> selectAllUsers() {

        // using try-with-resources to avoid closing resources (boiler plate code)
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = getConnection();

             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int ma_mat_bang = rs.getInt("ma_mat_bang");
                String dien_tich = rs.getString("dien_tich");
                String trang_thai = rs.getString("trang_thai");
                String tang = rs.getString("tang");
                String loai_van_phong = rs.getString("loai_van_phong");
                String gia_tien = rs.getString("gia_tien");
                String ngay_bat_dau = rs.getString("ngay_bat_dau");
                String ngay_ket_thuc = rs.getString("ngay_ket_thuc ");
                users.add(new User(ma_mat_bang, dien_tich, trang_thai, tang, loai_van_phong, gia_tien, ngay_bat_dau, ngay_ket_thuc ));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
            statement.setString(1, user.getName());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getCountry());
            statement.setInt(4, user.getId());

            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
