package dao.impl;

import dao.Dao;
import dao.db.DBConnectionProvider;
import domain.Poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollDaoImpl implements Dao<Poll> {
   private final Connection connection = DBConnectionProvider.getInstance().getConnection();
    private final QuestionDaoImpl questionDao = new QuestionDaoImpl();
    private final ResultDaoImpl resultDao = new ResultDaoImpl();
    @Override
    public List<Poll> findAll() {
        String query = "SELECT * FROM poll";
        List<Poll>polls = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Poll poll = Poll.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .questions(questionDao.findByPollId(resultSet.getInt(1)))
                        .results(resultDao.findByPollId(resultSet.getInt(1)))
                        .build();
                polls.add(poll);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return polls;
    }

    @Override
    public Poll findById(int id) {
        String query = "SELECT * FROM poll where id = "+id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                return Poll.builder()
                        .id(resultSet.getInt(1))
                        .name(resultSet.getString(2))
                        .description(resultSet.getString(3))
                        .questions(questionDao.findByPollId(resultSet.getInt(1)))
                        .results(resultDao.findByPollId(resultSet.getInt(1)))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}