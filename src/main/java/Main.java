import dao.impl.PollDaoImpl;

public class Main {
    public static void main(String[] args) {
        PollDaoImpl pollDao=new PollDaoImpl();
        System.out.println(pollDao.findAll());
    }
}
