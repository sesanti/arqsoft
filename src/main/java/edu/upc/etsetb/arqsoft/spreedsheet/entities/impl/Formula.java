import edu.upc.etsetb.arqsoft.spreedsheet.enties.Component;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Content;
import edu.upc.etsetb.arqsoft.spreedsheet.enties.Value;
import java.util.List;

/**
 *
 * @author sesan
 */
public class Formula implements Content {
    
    private Value value; //resultado para presentarlo por pantalla
    
    private List<Component> components; //list Component que nos da el PostfixGenerator y es la entrada al PostifxCalculator
    
    private String string; //string para guardarlo en la celda
    
    
    
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
       return this;
    }
    
    @Override
    public Value getValue(){
        return this.value;
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
