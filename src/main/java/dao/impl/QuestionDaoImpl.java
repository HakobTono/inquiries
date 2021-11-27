package dao.impl;

import dao.QuestionDao;
import dao.db.DBConnectionProvider;
import domain.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDaoImpl implements QuestionDao {
    private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final AnswerDaoImpl answerDao = new AnswerDaoImpl();

    @Override
    public List<Question> findAll() {
        List<Question> questions = new ArrayList<>();
        String query = "SELECT * FROM question";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Question question = Question.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .answers(answerDao.findByQuestionId(resultSet.getInt(1)))
                        .build();
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questions;
    }

    @Override
    public Question findById(int id) {
        String query = "SELECT * FROM question where id =" + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return Question.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .answers(answerDao.findByQuestionId(resultSet.getInt(1)))
                        .build();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Question> findByPollId(int pollId) {
        String query = "SELECT * FROM question where poll_id=" + pollId;
        List<Question>questions = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Question question = Question.builder()
                        .id(resultSet.getInt(1))
                        .text(resultSet.getString(2))
                        .answers(answerDao.findByQuestionId(resultSet.getInt(1)))
                        .build();
                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}