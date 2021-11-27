package dao.impl;


import dao.AnswerDao;
import dao.db.DBConnectionProvider;
import domain.Answer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AnswerDaoImpl implements AnswerDao {

    private final Connection connection = DBConnectionProvider.getInstance().getConnection();

    @Override
    public List<Answer> findAll() {
        String query = "SELECT * FROM answer";
        List<Answer> answers = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Answer answer = Answer.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .weight(resultSet.getInt(3))
                        .build();
                answers.add(answer);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return answers;
    }

    @Override
    public Answer findById(int id) {
        String query = "SELECT * FROM answer where id = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                return Answer.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .weight(resultSet.getInt(3))
                        .build();

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Answer> findByQuestionId(int questionId) {
        String query = "SELECT * FROM answer where question_id = " + questionId;
        List<Answer> answers = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Answer answer = Answer.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .weight(resultSet.getInt(3))
                        .build();
                answers.add(answer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }return answers;

    }
}