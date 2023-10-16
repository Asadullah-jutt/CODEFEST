/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.mongodb.client.model.Filters;
import static com.mongodb.client.model.Filters.eq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.FindOneAndUpdateOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertManyResult;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.bson.conversions.Bson;
import org.bson.Document;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.FindIterable;



import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

/**
 *
 * @author apple
 */
public class database {
    public MongoDatabase database;
    
    static database obj = new database();
    
    public void insertuserdataindb(Userdata data)
    {
        MongoCollection<Userdata> collection = database.getCollection("Userdata", Userdata.class);
        collection.insertOne(data);
    }
    
    public static database getInstance()
    {
        return obj;
    }
            
    
    public Userdata isHavingUserData(String username)
    {
        MongoCollection<Userdata> collection = database.getCollection("Userdata", Userdata.class);
//        FindIterable<Userdata> findIterable = ;

// Check if any documents were found
//        MongoCursor<Userdata> cursor = findIterable.iterator();
    System.out.println("The value in jTextField1 is: " + username);

    Bson finduser = Filters.eq("username", username);
 
      Userdata user = collection.find(finduser).first();
      return user;
//        if (collection.find(new Document("username", username))== null) 
//        {
//            System.out.println("No documents found.");
//            return false;
//        }
//        System.out.println("documents found.");
//        return true;
    }
 
    
    private database()
    {
        start();
    }
    
    public void start() 
    {
        // Start code here, similar to Start() in Unity
        Logger.getLogger( "org.mongodb.driver" ).setLevel(Level.WARNING);
    // TODO:
    // Replace the placeholder connection string below with your
    // Altas cluster specifics. Be sure it includes
    // a valid username and password! Note that in a production environment,
    // you do not want to store your password in plain-text here.
    ConnectionString mongoUri = new ConnectionString("mongodb+srv://admin:admin@mongodb.wos6mf4.mongodb.net/");

    // Provide the name of the database and collection you want to use.
    // If they don't already exist, the driver and Atlas will create them
    // automatically when you first write data.
    String dbName = "CODEFESTDB";
    String collectionName = "Userdata";

    // a CodecRegistry tells the Driver how to move data between Java POJOs (Plain Old Java Objects) and MongoDB documents
    CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
            fromProviders(PojoCodecProvider.builder().automatic(true).build()));

    // The MongoClient defines the connection to our MongoDB datastore instance (Atlas) using MongoClientSettings
    // You can create a MongoClientSettings with a Builder to configure codecRegistries, connection strings, and more
    MongoClientSettings settings = MongoClientSettings.builder()
            .codecRegistry(pojoCodecRegistry)
            .applyConnectionString(mongoUri).build();

    MongoClient mongoClient = null;
    try {
       mongoClient = MongoClients.create(settings);
    } catch (MongoException me) {
      System.err.println("Unable to connect to the MongoDB instance due to an error: " + me);
      System.exit(1);
    }

    // MongoDatabase defines a connection to a specific MongoDB database
     database = mongoClient.getDatabase(dbName);
    // MongoCollection defines a connection to a specific collection of documents in a specific database
    MongoCollection<Userdata> collection = database.getCollection(collectionName, Userdata.class);
    
   
    }


  
//  public static void main(String[] args) 
//  {
    
//    start();
     //    frame.displayoff();

        // Convert the JSON to a BSON Document and insert it into MongoDB


    /*      *** INSERT DOCUMENTS ***
     *
     * You can insert individual documents using collection.insert().
     * In this example, we're going to create 4 documents and then
     * insert them all in one call with insertMany().
     */

//    try {
//      // recipes is a static variable defined above
//      InsertManyResult result = collection.insertMany(recipes);
//      System.out.println("Inserted " + result.getInsertedIds().size() + " documents.\n");
//    } catch (MongoException me) {
//      System.err.println("Unable to insert any recipes into MongoDB due to an error: " + me);
//      System.exit(1);
//    }

    /*      *** FIND DOCUMENTS ***
     *
     * Now that we have data in Atlas, we can read it. To retrieve all of
     * the data in a collection, we call find() with an empty filter. We can
     * retrieve an iterator to return the results from our call to the find()
     * method. Here we use the try-with-resources pattern to automatically
     * close the cursor once we finish reading the recipes.
     */

//    try (MongoCursor<Recipe> cursor = collection.find().iterator()) {
//      while (cursor.hasNext()) {
//        Recipe currentRecipe = cursor.next();
//        System.out.printf("%s has %d ingredients and takes %d minutes to make\n", currentRecipe.getName(), currentRecipe.getIngredients().size(), currentRecipe.getPrepTimeInMinutes());
//      }
//    } catch (MongoException me) {
//      System.err.println("Unable to find any recipes in MongoDB due to an error: " + me);
//    }

    // We can also find a single document. Let's find the first document
    // that has the string "potato" in the ingredients list. We
    // use the Filters.eq() method to search for any values in any
    // ingredients list that match the string "potato":

//    Bson findPotato = Filters.eq("ingredients", "potato");
//    try {
//      Recipe firstPotato = collection.find(findPotato).first();
//      if (firstPotato == null) {
//        System.out.println("Couldn't find any recipes containing 'potato' as an ingredient in MongoDB.");
//        System.exit(1);
//      }
//    } catch (MongoException me) {
//      System.err.println("Unable to find a recipe to update in MongoDB due to an error: " + me);
//      System.exit(1);
//    }

    /*      *** UPDATE A DOCUMENT ***
     *
     * You can update a single document or multiple documents in a single call.
     *
     * Here we update the PrepTimeInMinutes value on the document we
     * just found.
     */
//    Bson updateFilter = Updates.set("prepTimeInMinutes", 72);
//
//    // The following FindOneAndUpdateOptions specify that we want it to return
//    // the *updated* document to us. By default, we get the document as it was *before*
//    // the update.
//    FindOneAndUpdateOptions options = new FindOneAndUpdateOptions().returnDocument(ReturnDocument.AFTER);
//
//    // The updatedDocument object is a Recipe object that reflects the
//    // changes we just made.
//    try {
//      Recipe updatedDocument = collection.findOneAndUpdate(findPotato,
//              updateFilter, options);
//      if (updatedDocument == null) {
//        System.out.println("Couldn't update the recipe. Did someone (or something) delete it?");
//      } else {
//        System.out.println("\nUpdated the recipe to: " + updatedDocument);
//      }
//    } catch (MongoException me) {
//      System.err.println("Unable to update any recipes due to an error: " + me);
//    }

    /*      *** DELETE DOCUMENTS ***
     *
     *      As with other CRUD methods, you can delete a single document
     *      or all documents that match a specified filter. To delete all
     *      of the documents in a collection, pass an empty filter to
     *      the deleteMany() method. In this example, we'll delete 2 of
     *      the recipes.
     */
//    Bson deleteFilter = Filters.in("name", Arrays.asList("elotes", "fried rice"));
//    try {
//      DeleteResult deleteResult = collection
//              .deleteMany(deleteFilter);
//      System.out.printf("\nDeleted %d documents.\n", deleteResult.getDeletedCount());
//    } catch (MongoException me) {
//      System.err.println("Unable to delete any recipes due to an error: " + me);
//    }
//
//    // always close the connection when done working with the client
//    mongoClient.close();
//  }
    public static class Userdata 
    {
    public String name;
    public String username;
    public String role;   
    public String email;
    public String password;
    
    public Userdata()
    {
        username = null ;
    }
    
    public Userdata(String name,String username,String role , String email , String password) 
    {
      this.name = name;
      this.username = username;
      this.role = role;
      this.email = email;
      this.password = password;

      
    }

    // empty constructor required when we fetch data from the database -- getters and setters are later used to
    // set values for member variables
    

    

    public String getName() {
      return name;
    }

    public void setName(String name) {
      this.name = name;
    }

    
  }
    
}


