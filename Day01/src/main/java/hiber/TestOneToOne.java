package hiber;

import hiber.entities.UserModel;
import hiber.entities.UserProfileModel;
import hiber.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestOneToOne {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();

        try {
            // Создаем нового пользователя
            UserModel user = new UserModel("Oleksandr Nykytin", "keeper@ninydev.com", "123456");
            UserProfileModel userProfile = new UserProfileModel("Odesa","0987654321");

            // Связываем объекты
            user.setUserProfile(userProfile);
            userProfile.setUser(user);

            // Сохраняем в БД
            session.persist(user);
            session.persist(userProfile);

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
