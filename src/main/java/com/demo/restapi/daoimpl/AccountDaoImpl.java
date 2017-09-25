package com.demo.restapi.daoimpl;

import com.demo.restapi.config.DatabaseConfig;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.util.JSON;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.util.Date;

@Singleton
public class AccountDaoImpl {

    /**
     * Gets database collection
     */
    private DatabaseConfig databaseConfig;

    @Inject
    public AccountDaoImpl(DatabaseConfig databaseConfig){
        this.databaseConfig = databaseConfig;
    }

    /**
     * Get user data present in a table
     *
     * @return String
     */
    public String getAll() {
        String serialize = null;

        DBCollection table = databaseConfig.createConnection();

        /** display data from the table **/
        DBCursor cursor = table.find();
        serialize = JSON.serialize(cursor);
        return serialize;
    }

    /**
     * Save user data in a table
     *
     * @return
     */
    public void save() {
        DBCollection table = databaseConfig.createConnection();
        /** Insert **/
        // create a document to store key and value
        BasicDBObject document = new BasicDBObject();
        document.put("name", "testing");
        document.put("age", 30);
        document.put("createdDate", new Date());
        table.insert(document);
    }
}
