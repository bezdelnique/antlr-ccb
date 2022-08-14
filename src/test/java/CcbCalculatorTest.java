import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.ccb.CCBEvalVisitor;
import org.example.ccb.CCBLexer;
import org.example.ccb.CCBParser;
import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorTest {
    @Test
    void whenTwoIntegerNotEqualsThanFalse() {
        ValueHolder result = evaluate("if[1=2]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenTwoIntegerEqualsThanTrue() {
        ValueHolder result = evaluate("if[1=1]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTwoIntegerEqualsThanTrueTokenUpperCase() {
        ValueHolder result = evaluate("IF[1=1]THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    private static ValueHolder evaluate(String expr) {
        CharStream in = CharStreams.fromString(expr);
        CCBLexer lexer = new CCBLexer(in);
        CCBParser parser = new CCBParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        CCBEvalVisitor visitor = new CCBEvalVisitor();
        ValueHolder result = visitor.visit(tree);
        return result;
    }
}
