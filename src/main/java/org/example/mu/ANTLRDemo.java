package org.example.mu;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public class ANTLRDemo {
    public static void main(String[] args) throws Exception {
//        CharStream in = CharStreams.fromString("12*(5-6)");
//        ExpLexer lexer = new ExpLexer(in);
//        CommonTokenStream tokens = new CommonTokenStream(lexer);
//        ExpParser parser = new ExpParser(tokens);
//        System.out.println(parser.eval()); // print the value


        CharStream in = CharStreams.fromString("""
                n = 9;
                                
                while n > 0 {
                                
                  # expressions can be surrounded by parenthesis, of course
                  if (n % 2 == 0) {
                    log n + " -> even";
                  }
                  else {
                    log n + " -> odd";
                  }
                                
                  n = n - 1;
                }
                """);
        MuLexer lexer = new MuLexer(in);
        MuParser parser = new MuParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
