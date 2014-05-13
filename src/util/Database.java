package util;

import java.sql.*;

/**
 * Created with IntelliJ IDEA.
 * domain.User: sujan.sarkar
 * Date: 4/28/14
 * Time: 1:49 PM
 * To change this template use File | Settings | File Templates.
 */
public class Database {

    private static Connection connection;
    Database()
    {
        DbConnectionManager dbConnectionManager = new DbConnectionManager();
        Connection con = dbConnectionManager.getConnection();
    }


    public static ResultSet executeQuery(String query, Object... values) {
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DbConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            putValues(statement, values);
            resultSet = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println(e.getMessage());
        }

        return resultSet;
    }

    public static void insertUpdateDeleteQuery(String query, Object... values) {
        PreparedStatement statement = null;

        try {
            connection = DbConnectionManager.getConnection();
            statement = connection.prepareStatement(query);
            putValues(statement, values);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void putValues(PreparedStatement statement, Object... values) throws SQLException {
        int i = 1;
        for (Object parameter : values) {
            if (parameter instanceof String) {
                statement.setString(i, (String) parameter);
            } else if (parameter instanceof Integer) {
                statement.setInt(i, (Integer) parameter);
            } else if (parameter instanceof Long) {
                statement.setLong(i, (Long) parameter);
            } else if (parameter instanceof Float) {
                statement.setFloat(i, (Float) parameter);
            } else if (parameter instanceof Double) {
                statement.setDouble(i, (Double) parameter);
            } else if (parameter instanceof Date) {
                statement.setDate(i, (Date) parameter);
            } else if (parameter instanceof Blob) {
                statement.setBlob(i, (Blob) parameter);
            }
            i++;
        }
    }

    public static void closeConnection() {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
