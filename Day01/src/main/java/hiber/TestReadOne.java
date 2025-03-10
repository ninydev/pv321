package hiber;

import hiber.entities.UserModel;
import hiber.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestReadOne {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {

            UserModel user = session.get(UserModel.class, 12L);
            System.out.println("User Find by Id: " + user.getName());
            // System.out.println("user Address   : " + user.getUserProfile().getAddress());

            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}
