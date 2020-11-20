public class PrintStatement extends Statement {
    public Expression printValue;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
    
}

