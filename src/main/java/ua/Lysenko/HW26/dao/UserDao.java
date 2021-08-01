package ua.Lysenko.HW26.dao;

import com.google.gson.Gson;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import ua.Lysenko.HW26.entity.User;
import ua.Lysenko.HW26.entity.UserFields;

import java.util.ArrayList;
import java.util.List;

import static com.mongodb.client.model.Filters.*;

public class UserDao {

    Gson gson = new Gson();

    public void createData(MongoDatabase database, User user) {
        final Document document = mapperFrom(user);
        MongoCollection<Document> users = database.getCollection("users");
        users.insertOne(document);
    }

    public List<User> findUserByName(MongoDatabase database, String nameToFind) {
        List<User> usersList = new ArrayList<>();
        MongoCollection<Document> users = database.getCollection("users");
        users.find(or(eq("firstName", nameToFind), eq("lastName", nameToFind)))
                .map(x -> gson.fromJson(x.toJson(), User.class))
                .into(new ArrayList<>());

        return usersList;

    }

    public List<User> findUserByAge(MongoDatabase database, int age) {
        List<User> usersList = new ArrayList<>();
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(lte("age", age));
        for (Document document : documents) {
            usersList.add(mapperTo(document));
        }
        return usersList;
    }

    public List<User> findUserByCity(MongoDatabase database, String city) {
        List<User> usersList = new ArrayList<>();
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(eq("city", city));
        for (Document document : documents) {
            usersList.add(mapperTo(document));
        }
        return usersList;
    }

    private static void readData(MongoDatabase database, UserFields fieldName, String fieldValue) {
        final Document filter = new Document();
        filter.append(String.valueOf(fieldName), fieldValue);
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find(filter);
        for (Document document : documents) {
            System.out.println(document);
        }

    }

    public static void readAllData(MongoDatabase database) {
        MongoCollection<Document> users = database.getCollection("users");
        FindIterable<Document> documents = users.find();
        for (Document document : documents) {
            System.out.println(document);
        }

    }

    public static void updateData(MongoDatabase database, UserFields fieldName, String fieldValueOld, String fieldValueNew) {
        final Document filter = new Document();
        filter.append(String.valueOf(fieldName), fieldValueOld);

        final Document newData = new Document();
        newData.append(fieldName.toString(), fieldValueNew);

        final Document updateObject = new Document();
        updateObject.append("$set", newData);

        MongoCollection<Document> users = database.getCollection("users");
        users.updateOne(filter, updateObject);
    }

    public static void deleteData(MongoDatabase database, UserFields fieldName, String fieldValue) {
        final Document filter = new Document();
        filter.append(fieldName.toString(), fieldValue);

        MongoCollection<Document> users = database.getCollection("users");
        users.deleteOne(filter);
    }

    public static void deleteAll(MongoDatabase database) {
        final Document filter = new Document();
        MongoCollection<Document> users = database.getCollection("users");
        users.deleteMany(gt("age", 0));
    }

    public static Document mapperFrom(User user) {
        final Document document = new Document();
        document.append("id", user.getId());
        document.append("firstName", user.getFirstName());
        document.append("lastName", user.getLastName());
        document.append("age", user.getAge());
        document.append("workPlace", user.getWorkPlace());
        document.append("city", user.getCity());
        return document;
    }

    public static User mapperTo(Document document) {

        final User user = new User(
                document.get("firstName", String.class),
                document.get("lastName", String.class),
                document.get("age", Integer.class),
                document.get("workPlace", String.class),
                document.get("city", String.class)
        );
        user.setId(document.get("id",String.class));
        return user;

    }

}
