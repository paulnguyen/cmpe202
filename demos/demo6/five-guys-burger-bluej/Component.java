
   
import java.util.ArrayList;
         
public interface Component {

     void doPrint() ;
     String getDescription() ;
     void addChild(Component c);
     void removeChild(Component c);
     Component getChild(int i);

}
 
