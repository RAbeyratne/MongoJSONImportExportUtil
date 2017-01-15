package mongojsonimportexportutil.Model;

import java.util.ArrayList;

/**
 *
 * @author Ramitha
 */
public class DatabaseObj {
    private String databseName;
    private ArrayList<String> collectionList;
        
    public DatabaseObj(String databaseName){
        this.databseName = databaseName;   
    }
    
    public DatabaseObj(String databaseName, ArrayList<String> collectionList){
        this.databseName = databaseName;
        this.collectionList = collectionList;
    }

    public String getDatabseName() {
        return databseName;
    }

    public void setDatabseName(String databseName) {
        this.databseName = databseName;
    }

    public ArrayList<String> getCollectionList() {
        return collectionList;
    }

    public void setCollectionList(ArrayList<String> collectionList) {
        this.collectionList = collectionList;
    }
}
