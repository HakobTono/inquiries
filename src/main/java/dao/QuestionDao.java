package dao;


import domain.Question;

import java.util.List;

public interface QuestionDao extends Dao<Question> {

    List<Question> findByPollId(int pollId);
}