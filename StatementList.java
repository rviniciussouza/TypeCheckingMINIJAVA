import java.util.List;

public class StatementList extends Statement {
    public List<Statement> statementList;
   
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

