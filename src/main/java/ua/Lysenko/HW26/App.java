package ua.Lysenko.HW26;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.Lysenko.HW26.dao.AccountDao;
import ua.Lysenko.HW26.dao.UserDao;
import ua.Lysenko.HW26.entity.Account;
import ua.Lysenko.HW26.entity.User;
import ua.Lysenko.HW26.utils.MongoUtils;

import java.util.Arrays;
import java.util.List;

public class App {

    static UserDao userDao = new UserDao();
    static AccountDao accountDao = new AccountDao();

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
        List<Document> documentsUsers = Arrays.asList(document1, document2, document3, document4, document5);
        users.insertMany(documentsUsers);

        Account account1 = new Account(1355.31);
        Account account2 = new Account(5067.70);
        Account account3 = new Account(9351.00);
        Account account4 = new Account(107.55);
        Account account5 = new Account(4588.12);
        Account account6 = new Account(2526.68);

        final Document acc1 = AccountDao.mapperTo(account1);
        final Document acc2 = AccountDao.mapperTo(account2);
        final Document acc3 = AccountDao.mapperTo(account3);
        final Document acc4 = AccountDao.mapperTo(account4);
        final Document acc5 = AccountDao.mapperTo(account5);
        final Document acc6 = AccountDao.mapperTo(account6);

        MongoCollection<Document> accounts = database.getCollection("accounts");
        List<Document> documentsAccounts = Arrays.asList(acc1, acc2, acc3, acc4, acc5, acc6);
        users.insertMany(documentsAccounts);

        System.out.println(userDao.findUserByAge(database, 30).toString());

        accountDao.bindUserToAccount(database, account1.getId(), user1.getId());
        accountDao.bindUserToAccount(database, account2.getId(), user1.getId());
        accountDao.bindUserToAccount(database, account3.getId(), user2.getId());
        accountDao.bindUserToAccount(database, account4.getId(), user2.getId());
        accountDao.bindUserToAccount(database, account5.getId(), user3.getId());
        accountDao.bindUserToAccount(database, account6.getId(), user4.getId());

//        userDao.deleteAll(database);
    }


}
