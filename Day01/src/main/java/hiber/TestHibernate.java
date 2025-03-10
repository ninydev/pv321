package hiber;

import hiber.utils.HibernateUtil;
import org.hibernate.Session;

public class TestHibernate {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        System.out.println("Соединение с базой установлено!");
        session.close();
    }
}