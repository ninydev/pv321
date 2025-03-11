package hiber;

import hiber.entities.PostModel;
import hiber.entities.UserModel;
import hiber.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class TestReadOneToMany {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        try {

//            UserModel user = session.get(UserModel.class, 12L);
//            System.out.println("User Find by Id: " + user.getName());
//
//            PostModel post1 = new PostModel();
//            post1.setTitle("Post Title1");
//            post1.setAuthor(user);

//            transaction = session.beginTransaction();
//            session.save(post1);
//            // transaction.commit();
//
//            PostModel post2 = new PostModel("Post Title2", user);
//
//            // transaction = session.beginTransaction();
//            session.save(post2);
//            transaction.commit();

            UserModel user2 = session.get(UserModel.class, 12L);

            System.out.println("Post Query: ");
            for (PostModel post : user2.getPosts()) {
                System.out.println(post.getTitle());
            }



        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();

        } finally {
            session.close();
        }
    }

}
