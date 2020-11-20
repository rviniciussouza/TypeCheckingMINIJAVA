public class MinusExpression extends Expression {
    public Expression left;
    public Expression right;

    @Override
    public Type accept(Visitor visitor) {
        return visitor.visit(this);
    }
}
