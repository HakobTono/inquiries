package servlet;

import dao.impl.PollDaoImpl;
import dao.impl.QuestionDaoImpl;
import domain.Question;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/question")
public class QuestionServlet extends HttpServlet {
    QuestionDaoImpl questionDao = new QuestionDaoImpl();
    PollDaoImpl pollDao = new PollDaoImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        List<Question> byPollId = questionDao.findByPollId(Integer.parseInt(id));
        req.setAttribute("question",byPollId);
        req.setAttribute("poll",pollDao.findById(Integer.parseInt(id)));
        req.getRequestDispatcher("question.jsp").forward(req,resp);
    }
}
