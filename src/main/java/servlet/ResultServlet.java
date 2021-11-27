package servlet;

import dao.impl.QuestionDaoImpl;
import dao.impl.ResultDaoImpl;
import domain.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/result")
public class ResultServlet extends HttpServlet {
    QuestionDaoImpl questionDao=new QuestionDaoImpl();
    ResultDaoImpl resultDao =new ResultDaoImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pollId = req.getParameter("pollId");
        int score=0;
        for (Question question : questionDao.findAll()) {
            String parameter = req.getParameter("" + question.getId());
            if (parameter!=null){
                score+=Integer.parseInt(parameter);
            }

        }
        req.setAttribute("result",resultDao.findByScore(Integer.parseInt(pollId),score));
        req.getRequestDispatcher("result.jsp").forward(req,resp);
    }
}
