package mongojsonimportexportutil;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.client.ListCollectionsIterable;
import com.mongodb.client.ListDatabasesIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;
import javax.swing.JOptionPane;
import mongojsonimportexportutil.Model.DatabaseObj;
import org.bson.Document;

/**
 *
 * @author Ramitha
 */
public class MongoJSONImportExportUtil {

    public static void main(String[] args) {
      
        // Connection mongo and DB
        MongoClient mongoClient = new MongoClient("localhost", 27017);

        ArrayList<DatabaseObj> databaseObjarray = new ArrayList<DatabaseObj>();
        
        ListDatabasesIterable<Document> databaseDocList = mongoClient.listDatabases(); 
        
        for (Document databaseDocument : databaseDocList){
            String databaseName = databaseDocument.get("name").toString();
            ArrayList<String> collectionNameList = new ArrayList<String>();
   
            MongoDatabase database = mongoClient.getDatabase(databaseName);  
      
            ListCollectionsIterable<Document> list = database.listCollections();
            for (Document d : list){
                String name = d.get("name").toString();        
                collectionNameList.add(name);                        
            }
            databaseObjarray.add(new DatabaseObj(databaseName, collectionNameList));           
        }

        
        //JOptionPane.showMessageDialog(null,"Eggs are not supposed to be green.","Inane error",JOptionPane.ERROR_MESSAGE);
    
    
    MainUserInterface mui = new MainUserInterface(databaseObjarray);
    mui.go();
    
    }  
    
    
}
