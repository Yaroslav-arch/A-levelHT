package ua.Lysenko.HW26;

import com.mongodb.MongoCredential;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.Lysenko.HW26.dao.UserDao;
import ua.Lysenko.HW26.entity.User;
import ua.Lysenko.HW26.entity.UserFields;
import ua.Lysenko.HW26.utils.MongoUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {

    static UserDao userDao = new UserDao();

    private static final MongoDatabase database = MongoUtils.connect("alevel");

    public static void main(String[] args) {

        User user1 = new User("Jack", "Sparrow", 35, "Black pearl", "Isla de Muerte");
        User user2 = new User("Max", "Payne", 45, "NYPD", "New York");
        User user3 = new User("Thomas", "Anderson", 28, "Matrix", "Zion");
        User user4 = new User("Gordon", "Freeman", 30, "Black Mesa", "New Mexico");
        User user5 = new User("Yuri", "Gagarin", 27, "Vostok", "Baikonur");

        final Document document1 = UserDao.mapperFrom(user1);
        final Document document2 = UserDao.mapperFrom(user2);
        final Document document3 = UserDao.mapperFrom(user3);
        final Document document4 = UserDao.mapperFrom(user4);
        final Document document5 = UserDao.mapperFrom(user5);

        MongoCollection<Document> users = database.getCollection("users");
        List<Document> documents = Arrays.asList(document1, document2, document3, document4, document5);
        users.insertMany(documents);

        System.out.println(userDao.findUserByAge(database,30).toString());
        userDao.deleteAll(database);
    }


}
