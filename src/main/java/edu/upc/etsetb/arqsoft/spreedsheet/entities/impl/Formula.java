import edu.upc.etsetb.arqsoft.spreedsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Value;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Formula implements Content {
    
    private Value value;
    
    private List<Component> components;
    
    private String string;
    
    public static Formula getInstance(Value value, List<Component> components, String string){ // se puede llamar desde fabrica
        
        return new Formula(value,components,string);
    }
    protected Formula(Value value, List<Component> components, String string){
           this.value=value;
           this.components=components;
           this.string=string;
            
    }

    @Override
    public Content getContent() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setContent(Content content) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Double getAsDouble() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAsString() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
