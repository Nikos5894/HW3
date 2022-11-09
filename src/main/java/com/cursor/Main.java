package com.cursor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        try (var connection = DriverManager.getConnection(DBConnection.URL, DBConnection.USERNAME, DBConnection.PASSWORD)) {

            var statement = connection.prepareStatement(SqlQueries.UPDATE_USER_AGE);
            var prepareStatement = connection.prepareStatement(SqlQueries.UPDATE_USER_AGE);

            statement.execute(SqlQueries.CREATE_TABLE);
//          statement.execute(SqlQueries.INSERT_USERS);

//            prepareStatement.setInt(1, 100);
//            prepareStatement.setInt(2, 1);
//
//            prepareStatement.executeUpdate();

            ShowUsersLess18(connection);
            ShowUserNameFinishO(connection);
            ShowUserAgeBetween18And60(connection);
            ShowCountUsersNameHaveA(connection);
            ShowCountUsersLess18(connection);

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void ShowCountUsersLess18(Connection connection) throws SQLException {
        var prepareStatement = connection.prepareStatement(SqlQueries.SELECT_USERS_LESS_18);
        var resultSet = prepareStatement.executeQuery();

        int users = 0;

        while (resultSet.next()) {

            users++;
        }
        System.out.println("Кількість  неповньолітніх юзерів: " + users);
    }

    private static void ShowCountUsersNameHaveA(Connection connection) throws SQLException {

        var prepareStatement = connection.prepareStatement(SqlQueries.SELECT_USERS_NAME_HAVE_A);
        var resultSet = prepareStatement.executeQuery();

        int users = 0;

        while (resultSet.next()) {

            users++;
        }
        System.out.println("Кількість юзерів які містять а: " + users);
    }

    private static void ShowUserAgeBetween18And60(Connection connection) throws SQLException {

        var prepareStatement = connection.prepareStatement(SqlQueries.SELECT_USERS_BETWEEN_18_AND_60);
        var resultSet = prepareStatement.executeQuery();

        var users = new ArrayList<>();

        while (resultSet.next()) {

            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));

            users.add(user);
        }
        System.out.println("Юзери вік між 18 і 60");
        users.forEach(System.out::println);
    }

    private static void ShowUserNameFinishO(Connection connection) throws SQLException {

        var prepareStatement = connection.prepareStatement(SqlQueries.SELECT_USERS_NAME_FINISH_O);
        var resultSet = prepareStatement.executeQuery();

        var users = new ArrayList<>();

        while (resultSet.next()) {

            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));

            users.add(user);
        }
        System.out.println("Юзери ім'я закінчується на o");
        users.forEach(System.out::println);
    }

    private static void ShowUsersLess18(Connection connection) throws SQLException {

        var prepareStatement = connection.prepareStatement(SqlQueries.SELECT_USERS_LESS_18);
        var resultSet = prepareStatement.executeQuery();

        var users = new ArrayList<>();

        while (resultSet.next()) {

            User user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirstName(resultSet.getString(2));
            user.setLastName(resultSet.getString(3));
            user.setAge(resultSet.getInt(4));

            users.add(user);
        }
        System.out.println("Юзери молодші 18 років");
        users.forEach(System.out::println);
    }


}
