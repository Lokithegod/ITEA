package com.gmail.kss95kss.service;

import com.gmail.kss95kss.dto.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationService {
    public static final String SET_USER_IN_DB = "INSERT INTO client (id, name, second_name, login, password, email, role) VALUES (NULL,?, NULL,?,?,?, NULL)";
    public Logger logger = Logger.getLogger(RegistrationService.class.getSimpleName());
    public Connection connection = null;


    public RegistrationService()

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


    public String validate (String name,String login , String password,String rePassword, String email,String gender,String address,String agree)
    {
        String errorText = "<ul>";
        Pattern patlatletter = Pattern.compile("[a-zA-Z]{1}");
        Matcher matlatletter ;
        Matcher matcher ;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern emailPattern=  Pattern.compile(EMAIL_PATTERN);
        int uperFlag =0;
        int lowerFlag =0;
        int digitFlag =0;
        boolean onlyLatinAlphabet = true;

        Character ch ;
        // errorText += "</ul>";
        boolean isError = false;
        boolean isShowForm = true;

        if(!Objects.isNull(login)){
            if(login.length() < 1){
                isError = true;
                errorText += "<li> login is empty </li>";
            }
            matcher = emailPattern.matcher(login);
            if(!matcher.matches()){
                isError = true;
                errorText += "<li> invalid login name </li>";
            }
            if(password.length() < 1) {
                isError = true;
                errorText += "<li> password is empty </li>";
            }
            if (password.length() <= 8) {
                isError = true;
                errorText += "<li> password must contain 8+ symblos </li>";
            }
            char[]character = password.toCharArray();

            for (int i = 0; i < character.length; i++) {
                ch = character[i];
                if (Character.isUpperCase(ch)) {
                    isError = true;
                    uperFlag =+1;
                }
                if (Character.isLowerCase(ch)) {
                    isError = true;
                    lowerFlag =+1;
                }
                if (Character.isDigit(ch)) {
                    isError = true;
                    digitFlag = +1;
                }
            }
            if (uperFlag == 0){
                errorText += "<li> password must contain Upper case character </li>";
            }
            if (lowerFlag == 0){
                errorText += "<li> password must contain Lower case character  </li>";
            }
            if (digitFlag == 0){
                errorText += "<li> password must contain digit character </li>";
            }
            matlatletter = patlatletter.matcher(password);
            //if (!Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.BASIC_LATIN)) {
            if(matlatletter.matches()){
                isError = true;
                errorText += "<li> password must contain only lat character </li>";
                //errorText += "<li>"+ ch +" - is not lat character </li>";

            }
//		onlyLatinAlphabet= password.matches("^[a-zA-Z0-9]+$");
//		if (onlyLatinAlphabet = false ){
//			errorText += "<li> password must contain only lat character </li>";
//		}



            if(rePassword.length() < 1){
                isError = true;
                errorText += "<li> re-password is empty </li>";
            }
            if(!Objects.equals(password,rePassword)){
                isError = true;
                errorText += "<li> Those passwords do not match. Try again:  </li>";
            }
            if(name.length() < 1){
                isError = true;
                errorText += "<li> name is empty </li>";
            }
            if(Objects.isNull(gender) || gender.length() < 1 ){
                isError = true;
                errorText += "<li> gender is empty </li>";
            }
            if(address.length() < 1){
                isError = true;
                errorText += "<li> address is empty </li>";
            }
            if(Objects.isNull(agree)){
                isError = true;
                errorText += "<li> agree is empty </li>";
            }
            if(!isError){
                errorText +="success";
                isShowForm = false;
            }
        }
        return errorText;
    }


    public String insert (String name,String login , String password, String email) {
        Client client = new Client();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Client> clientsList = new ArrayList<Client>();

        Connection connection = connection();

        try {
            stmt = connection.prepareStatement(SET_USER_IN_DB);
            stmt.setString(1,name);
            stmt.setString(2,login);
            stmt.setString(3,password);
            stmt.setString(4,email);
            rs = stmt.executeQuery();

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...

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

        return "success";
    }

}
