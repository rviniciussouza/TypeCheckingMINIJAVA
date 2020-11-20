public class BooleanValueExpression extends Expression {
    public BooleanValue value;

    @Override
    public Type accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
