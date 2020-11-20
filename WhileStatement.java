public class WhileStatement extends Statement {
    public Expression condition;
    public Statement body;

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

