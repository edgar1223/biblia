package com.edgar.biblia4.o.repositorio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.edgar.biblia4.o.models.libromodels;


@Repository
public class LibroDAO {

	private static final String DB_URL = "jdbc:mysql://cristo.c5u8hy3hxco4.us-east-1.rds.amazonaws.com/biblia?serverTimezone=UTC";
    private static final String DB_USER = "admin";
    private static final String DB_PASSWORD = "mucikaa12";
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public List<libromodels> obtenerRangoVersiculos(int bookId, int chapter, int startVerse, int endVerse) throws ClassNotFoundException {
        List<libromodels> versiculos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM verses WHERE book_id = ? AND chapter = ? AND verse BETWEEN ? AND ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.setInt(2, chapter);
                statement.setInt(3, startVerse);
                statement.setInt(4, endVerse);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int resultBookId = resultSet.getInt("book_id");
                        int resultChapter = resultSet.getInt("chapter");
                        int resultVerse = resultSet.getInt("verse");
                        String resultText = resultSet.getString("text");

                        libromodels versiculo = new libromodels(resultBookId, resultChapter, resultVerse, resultText);
                        versiculos.add(versiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versiculos;
    }
    
    public List<libromodels> obtenercap(int bookId, int chapter) throws ClassNotFoundException {
        List<libromodels> versiculos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM verses WHERE book_id = ? AND chapter = ? ";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.setInt(2, chapter);
               

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int resultBookId = resultSet.getInt("book_id");
                        int resultChapter = resultSet.getInt("chapter");
                        int resultVerse = resultSet.getInt("verse");
                        String resultText = resultSet.getString("text");

                        libromodels versiculo = new libromodels(resultBookId, resultChapter, resultVerse, resultText);
                        versiculos.add(versiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versiculos;
    }
    public int obtenerNumeroCapitulos(int bookId) throws ClassNotFoundException {
        int numeroCapitulos = 0;

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT MAX(chapter) as numeroCapitulos FROM verses WHERE book_id = ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        numeroCapitulos = resultSet.getInt("numeroCapitulos");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return numeroCapitulos;
    }
    public List<libromodels> obtenerRangocapitulos(int bookId, int starchapter, int endchapter) throws ClassNotFoundException {
        List<libromodels> versiculos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM verses WHERE book_id = ? AND chapter BETWEEN ? AND ? ";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                statement.setInt(2, starchapter);
                statement.setInt(3, endchapter);

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int resultBookId = resultSet.getInt("book_id");
                        int resultChapter = resultSet.getInt("chapter");
                        int resultVerse = resultSet.getInt("verse");
                        String resultText = resultSet.getString("text");

                        libromodels versiculo = new libromodels(resultBookId, resultChapter, resultVerse, resultText);
                        versiculos.add(versiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versiculos;
    }
    public List<libromodels> obtenerapitulo(int bookId) throws ClassNotFoundException {
        List<libromodels> versiculos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM verses WHERE book_id = ? ";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, bookId);
                

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int resultBookId = resultSet.getInt("book_id");
                        int resultChapter = resultSet.getInt("chapter");
                        int resultVerse = resultSet.getInt("verse");
                        String resultText = resultSet.getString("text");

                        libromodels versiculo = new libromodels(resultBookId, resultChapter, resultVerse, resultText);
                        versiculos.add(versiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versiculos;
    }
    public List<libromodels> buscarVersiculosConPalabra(String palabra) throws ClassNotFoundException {
        List<libromodels> versiculos = new ArrayList<>();

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD)) {
            String query = "SELECT * FROM verses WHERE  text LIKE ?";
            
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setString(1, "%" + palabra + "%"); // El símbolo '%' se usa para buscar coincidencias parciales

                try (ResultSet resultSet = statement.executeQuery()) {
                    while (resultSet.next()) {
                        int resultBookId = resultSet.getInt("book_id");
                        int resultChapter = resultSet.getInt("chapter");
                        int resultVerse = resultSet.getInt("verse");
                        String resultText = resultSet.getString("text");

                        libromodels versiculo = new libromodels(resultBookId, resultChapter, resultVerse, resultText);
                        versiculos.add(versiculo);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return versiculos;
    }

}
