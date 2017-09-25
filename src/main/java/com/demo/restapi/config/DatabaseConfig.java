package com.demo.restapi.config;

import com.mongodb.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Singleton;
import java.net.UnknownHostException;

@Singleton
public class DatabaseConfig {

    /**
     * Logger reference
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(DatabaseConfig.class);


    /**
     *creates connection with database
     *
     * @return DBCollection
     */
    public DBCollection createConnection() {
        try {
            /** MongoClient to connect to the database**/
            MongoClient mongo = new MongoClient("localhost", 27017);

            /** Get database **/
            // if database doesn't exists, MongoDB will creates it
            DB db = mongo.getDB("testdb");

            /** Get collection / table from 'testdb' **/
            // if collection doesn't exists, MongoDB will create it
            return db.getCollection("user");

        } catch (UnknownHostException | MongoException e) {
            LOGGER.warn("Error while creating connection with MongoDB", e);
        }
        return null;
    }
}
