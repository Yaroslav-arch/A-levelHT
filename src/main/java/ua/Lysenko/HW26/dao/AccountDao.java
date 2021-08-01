package ua.Lysenko.HW26.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.Lysenko.HW26.entity.Account;
import ua.Lysenko.HW26.entity.User;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    public List<Account> getAll(MongoDatabase database) {
        List<Account> accountsList = new ArrayList<>();
        MongoCollection<Document> accounts = database.getCollection("accounts");
        FindIterable<Document> documents = accounts.find();
        for (Document document : documents) {
            accountsList.add(mapperFrom(document));
        }
        return accountsList;
    }


    public void bindUserToAccount(MongoDatabase database, String accountId, String userId) {
        MongoCollection<Document> accounts = database.getCollection("accounts");

        final Document filter = new Document();
        filter.append("id", accountId);

        final Document update = new Document();
        update.append("ownerId", userId);

        final Document doc = new Document();
        doc.append("$set", update);

        accounts.updateOne(filter, doc);

    }

//    public static List readAllData(MongoDatabase database) {
//        List<Account> accountList = new ArrayList<>();
//        MongoCollection<Document> accounts = database.getCollection("accounts");
//        FindIterable<Document> documents = accounts.find();
//        for (Document document : documents) {
//            accountList.add(mapperFrom(document));
//        }
//        return accountList;
//    }

    public static Document mapperTo(Account account) {
        final Document document = new Document();
        document.append("id", account.getId());
        document.append("amount", account.getAmount());
        document.append("userId", account.getUserId());
        return document;
    }

    public static Account mapperFrom(Document document) {

        final Account account = new Account(
                document.get("amount", Double.class));
        account.setId(document.get("id", String.class));
        account.setUserId(document.get("userId", String.class));
        return account;

    }
}
