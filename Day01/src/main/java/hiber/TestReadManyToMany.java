package hiber;

import hiber.entities.PostModel;
import hiber.entities.TagModel;
import hiber.entities.UserModel;
import hiber.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.UUID;

public class TestReadManyToMany {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = null;

        System.out.println("\n\n\n");

        try {

            TagModel tag = session.get(TagModel.class, 1L);
            System.out.println("Tag Name: " + tag.getName());
            for (PostModel post : tag.getPosts()) {
                System.out.println(" * " + post.getTitle());
            }


//            UUID uuid = UUID.fromString("ab51b537-b1d1-40dd-a15f-db1aa93cbf0b");
//            PostModel postModel = session.get(PostModel.class, uuid);
//            System.out.println("\n\nPost Title: " + postModel.getTitle());
//            for(TagModel tag : postModel.getTags()) {
//                System.out.println(" * " + tag.getName());
//            }

//            UserModel user2 = session.get(UserModel.class, 12L);
//            System.out.println("\n\nUser Name: " + user2.getName());
//            for (PostModel post : user2.getPosts()) {
//                System.out.print(" * " + post.getTitle() + " ");
//                System.out.print(" tags (" + post.getTags().size() +  "): ");
//                for (TagModel tag : post.getTags()) {
//                    System.out.print(" " + tag.getName() + " ");
//                }
//                System.out.println();
//            }



        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) transaction.rollback();

        } finally {
            session.close();
        }
    }

}
