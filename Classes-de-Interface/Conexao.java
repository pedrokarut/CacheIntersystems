package ClassesDeInterface;
import com.intersys.objects.CacheDatabase;
import com.intersys.objects.CacheException;
import com.intersys.objects.Database;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Conexao 
{
    private Database dbconnection;
 

        
    public Conexao()
    {
        String url = "jdbc:Cache://localhost:1972/USER";
        String username = "_SYSTEM";
        String password = "root";

       
    
   
        try 
        {
            dbconnection = CacheDatabase.getDatabase(url, username, password);
        } 
        catch (CacheException ex) 
        {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }     
   
    public Database getDbconnection() {
        return dbconnection;
    }

    public void setDbconnection(Database dbconnection) {
        this.dbconnection = dbconnection;
    }
}


