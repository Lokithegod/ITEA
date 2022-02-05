package com.gmail.kss95kss.service;



import com.gmail.kss95kss.dto.model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class ProductService {
    public static final String ALL_PRODUCTS = "SELECT * FROM products";
    public static final String GET_PRODUCTS_BY_CATEGODY = "SELECT * FROM product_to_category JOIN products  ON product_to_category.product_id=products.id JOIN categories ON product_to_category.category_id=categories.id WHERE categories.name = ?";
    public static final String GET_PRODUCTS_BY_ID = "SELECT * FROM products WhERE products.id=?";
    public Logger logger = Logger.getLogger(ProductService.class.getSimpleName());
    public Connection connection = null;


    public ProductService() {


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

    public List<Product> getAllProducts() {

        Statement stmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<Product>();

        Connection connection = connection();

        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery(ALL_PRODUCTS);

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            logger.info(rs.toString());
            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setText(rs.getString("description"));
                productList.add(product);


                logger.info(product.toString());


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
        return productList;
    }

    public List<Product> getProductsByCategory(String categoryName) {

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<Product>();

        Connection connection = connection();

        try {
            stmt = connection.prepareStatement(GET_PRODUCTS_BY_CATEGODY);
            stmt.setString(1,categoryName);
            rs = stmt.executeQuery();

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            logger.info(rs.toString());
            while (rs.next()) {

                Product product = new Product();

                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setText(rs.getString("description"));
                productList.add(product);


                logger.info(product.toString());


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
        return productList;
    }

    public Product getByID (Integer id)
    {

        Product product = new Product();

        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Product> productList = new ArrayList<Product>();

        Connection connection = connection();

        try {
            stmt = connection.prepareStatement(GET_PRODUCTS_BY_ID);
            stmt.setInt(1,id);
            rs = stmt.executeQuery();

            // or alternatively, if you don't know ahead of time that
            // the query will be a SELECT...
            logger.info(rs.toString());
            while (rs.next()) {


                product.setId(rs.getInt("id"));
                product.setName(rs.getString("name"));
                product.setPrice(rs.getDouble("price"));
                product.setText(rs.getString("description"));
                productList.add(product);


                logger.info(product.toString());


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
        return product;

    }

}
