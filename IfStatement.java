public class IfStatement extends Statement {
    public Expression condition;
    public Statement thenStatement;
    public Statement elseStatement;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}

