import java.util.ArrayList;
import java.util.List;

public class Lab {
   
    public static void main(String[] args) {

        /** 
        public boolean solve(int A) {
            int C;
            boolean ans;
            C = (A - 10) * 2;
            if(C < 20) {
                ans = true;
            }
            else {
                ans = false;
            }
            return ans;
        }
        */
        FunctionDeclaration fun = new FunctionDeclaration();

        fun.returnType = new TypeBoolean();
        fun.functionName = new ID("solve");
        
            VariableExpression returnExpression = new VariableExpression();
            returnExpression.varName = new ID("ans");
            fun.returnExpression = returnExpression;

        VariableDeclaration declareC = new VariableDeclaration();
        declareC.variableName = new ID("C"); declareC.variableType = new TypeInt();
        
        /* Erro - Redeclarando a variavel C */
        // VariableDeclaration declareC2 = new VariableDeclaration();
        // declareC2.variableName = new ID("C"); declareC2.variableType = new TypeInt();

        VariableDeclaration declareAns = new VariableDeclaration();
        declareAns.variableName = new ID("ans"); declareAns.variableType = new TypeBoolean();
        
        fun.variableDeclarationList = new ArrayList<>();
        fun.variableDeclarationList.add(declareC);
        /* Erro */
        // fun.variableDeclarationList.add(declareC2);
        fun.variableDeclarationList.add(declareAns);

        VariableDeclaration declareA = new VariableDeclaration();
        declareA.variableName = new ID("A"); declareA.variableType = new TypeInt();
        fun.parameterList = new ArrayList<>();
        fun.parameterList.add(declareA);

        AttributionStatement attributionStatement = new AttributionStatement();
            TimesExpression timesExpression = new TimesExpression();
                MinusExpression minusExpression = new MinusExpression();
                    VariableExpression minusLeft = new VariableExpression();
                    minusLeft.varName = new ID("A");
                    minusExpression.left = minusLeft;
                    minusExpression.right = new NumberDecimalExpression();
                timesExpression.left = minusExpression;
                timesExpression.right = new NumberDecimalExpression();
            attributionStatement.leftSide = new ID("C");
            attributionStatement.rightSide = timesExpression;
            // attributionStatement.rightSide = new BooleanValueExpression();
            

        IfStatement IF = new IfStatement();
            LessExpression lessExpression = new LessExpression();
                VariableExpression leftLess = new VariableExpression();
                    leftLess.varName = new ID("C");
                lessExpression.left = leftLess;
                lessExpression.right = new NumberDecimalExpression(); 
            // TimesExpression timesExpression2 = new TimesExpression();
            //     MinusExpression minusExpression2 = new MinusExpression();
            //         VariableExpression minusLeft2 = new VariableExpression();
            //         minusLeft2.varName = new ID("A");
            //         minusExpression2.left = minusLeft;
            //         minusExpression2.right = new NumberDecimalExpression();
            //     timesExpression2.left = minusExpression2;
            //     timesExpression2.right = new NumberDecimalExpression();  
            IF.condition = lessExpression;

            StatementList statementList = new StatementList();
            statementList.statementList = new ArrayList<>();
                AttributionStatement attributionAns = new AttributionStatement();
                attributionAns.leftSide = new ID("ans");
                attributionAns.rightSide = new BooleanValueExpression();
            statementList.statementList.add(attributionAns);
            IF.thenStatement = statementList;
            IF.elseStatement = statementList;
        
        List<Statement> bodyStatement = new ArrayList<>();
        bodyStatement.add(IF);
        bodyStatement.add(attributionStatement);
        fun.functionBody = bodyStatement;

        System.out.println(new CheckType().correctTypes(fun));
    }
}
