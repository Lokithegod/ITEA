package com.gmail.kss95kss.service;
import com.gmail.kss95kss.dto.model.Client;
import com.gmail.kss95kss.dto.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;



public class LoginService {

    public Logger logger = Logger.getLogger(LoginService.class.getSimpleName());
    public  Connection connection = null;
    private static final String GET_CLIENT_BY_ID = ("SELECT * FROM client WhERE client.login=?");

    public LoginService()

    {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            logger.info("connect to DB");
        } catch (Exception ex) {
            logger.info("can`t load JDBC Driver");
        }

    }
    public Connection connection() {
        try {
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost/itea?" +
                            "user=root&password=");

            // Do something with the Connection

        } catch (SQLException ex) {
            // handle any errors
            logger.info("SQLException: " + ex.getMessage());
            logger.info("SQLState: " + ex.getSQLState());
            logger.info("VendorError: " + ex.getErrorCode());
        }

        return connection;

    }



    public Client getClientByLogin (String login)
    {

        Client client = new Client();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Client> clientsList = new ArrayList<Client>();

        Connection connection = connection();

        try {
            stmt = connection.prepareStatement(GET_CLIENT_BY_ID);
            stmt.setString(1,login);
            rs = stmt.executeQuery();

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            logger.info(rs.toString());
            while (rs.next()) {


                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setSecondName(rs.getString("second_name"));
                client.setLogin(rs.getString("login"));
                client.setPassword(rs.getString("password"));
                client.setEmail(rs.getString("email"));
                client.setRole(rs.getInt("role"));
                clientsList.add(client);


                logger.info(client.toString());


            }


            // Now do something with the ResultSet ....
        } catch (SQLException ex) {
            // handle any errors
            logger.info("SQL Exception" + ex.getMessage());
        } finally {

            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                    logger.info("Error close Result Set"+ sqlEx);
                } // ignore

                rs = null;
            }

            if (stmt != null) {
                try {
                    stmt.close();
                } catch (SQLException sqlEx) {
                    logger.info("Error close statment"+ sqlEx);
                } // ignore

                stmt = null;
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException sqlEx) {
                    logger.info("Error close connection"+ sqlEx);
                } // ignore

                stmt = null;
            }
        }
        return client;

    }






}
