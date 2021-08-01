package ua.Lysenko.HW26.dao;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.Lysenko.HW26.entity.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    public List<Account> getAll(MongoDatabase database) {
        List<Account> accounts = new ArrayList<>();
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find();
        for (Document document : documents) {
            accounts.add(mapperTo(document));
        }
        return accounts;
    }

    public static Document mapperFrom(Account account) {
        final Document document = new Document();
        document.append("id", account.getId());
        document.append("amount", account.getAmount());
        document.append("userId", account.getUserId());
        return document;
    }

    public static Account mapperTo(Document document) {

        final Account account = new Account(
                document.get("amount", Double.class));
        account.setId(document.get("id", String.class));
        account.setUserId(document.get("userId", String.class));
        return account;

    }
}
