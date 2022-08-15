import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.ccb.CCBDatasource;
import org.example.ccb.CCBEvalVisitor;
import org.example.ccb.CCBLexer;
import org.example.ccb.CCBParser;
import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorTest {
    private final CCBDatasource ccbDatasource = new CCBDatasource();


    @Test
    void whenTwoIntegersNotEqualsThanFalse() {
        ValueHolder result = evaluate("if[1=2]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenTwoIntegersEqualsThanTrue() {
        ValueHolder result = evaluate("if[1=1]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTwoIntegersEqualsThanTrueTokenUpperCase() {
        ValueHolder result = evaluate("IF[1=1]THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTwoStringsEqualsThanTrue() {
        ValueHolder result = evaluate("IF[\"APH\"='APH']THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenContextObjectAndStringEqualsThanTrue() {
        ValueHolder result = evaluate("IF[SA[EO:EO-TYPE]='APH']THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    private ValueHolder evaluate(String expr) {
        CharStream in = CharStreams.fromString(expr);
        CCBLexer lexer = new CCBLexer(in);
        CCBParser parser = new CCBParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        CCBEvalVisitor visitor = new CCBEvalVisitor(this.ccbDatasource);
        ValueHolder result = visitor.visit(tree);
        return result;
    }
}
