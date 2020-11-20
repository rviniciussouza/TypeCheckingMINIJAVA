public class AttributionStatement extends Statement {
    public ID leftSide;
    public Expression rightSide;
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

