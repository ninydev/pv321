package hiber;

import hiber.entities.UserModel;
import hiber.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestUser {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Создаем нового пользователя
            UserModel user = new UserModel("Иван Иванов", "ivan6@example.com", "123456");
            session.persist(user); // Сохраняем в БД

            transaction.commit();
            System.out.println("Пользователь сохранен: " + user);
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}