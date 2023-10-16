/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;
import com.mycompany.mavenproject1.LoginGUI;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class MainRunner 
{
  // a few pre-wired recipes we can insert into the database as examples.
    
    public static void main(String[] args) 
    {
        LoginGUI frame = new LoginGUI();
        frame.display();
    }
    
    public static boolean comparestring(String a , String b )
    {
         for(int i = 0 ; i < a.length() ; i++)
                 if(a.charAt(i) != b.charAt(i))
                     return false;
         return true;

    }

  // POJO (Plain Old Java Object) class defining a recipe. This class is a POJO because it contains getters and
  // setters for every member variable as well as an empty constructor.
  
}

