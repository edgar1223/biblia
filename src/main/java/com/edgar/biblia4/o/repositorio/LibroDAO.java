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
}
