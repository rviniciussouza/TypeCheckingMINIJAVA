import java.util.Map;
import java.util.HashMap; 

class Table implements Cloneable{
    Map<Symbol, Type> hash;
    
    Table() {
        hash = new HashMap<>();    
    }
    
    public void put(Symbol symbol, Type type) {
        hash.put(symbol, type);
    }

    public Type get(Symbol key) {
        return hash.get(key);
    }

    /**
     * Realiza o clone de uma Table
     * Obs: Não foi necessário para esse trabalho.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Table table = (Table)super.clone();
        table.hash = copyHashMap(); 
        return table;
    }

    private HashMap<Symbol, Type> copyHashMap() {
        HashMap<Symbol, Type> hashCopy = new HashMap<>();
        for(Map.Entry<Symbol, Type> entry : this.hash.entrySet()) {
            hashCopy.put(entry.getKey(), entry.getValue());
        }
        return hashCopy;
    }
}