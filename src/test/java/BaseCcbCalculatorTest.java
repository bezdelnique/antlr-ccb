import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.example.ccb.CCBDatasource;
import org.example.ccb.CCBEvalVisitor;
import org.example.ccb.CCBLexer;
import org.example.ccb.CCBParser;
import org.example.ccb.ValueHolder;
import org.mockito.Mockito;


abstract public class BaseCcbCalculatorTest {
    protected final CCBDatasource ccbDatasource = Mockito.mock(CCBDatasource.class);


    protected ValueHolder evaluate(String expr) {
        CharStream in = CharStreams.fromString(expr);
        CCBLexer lexer = new CCBLexer(in);
        CCBParser parser = new CCBParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.parse();
        CCBEvalVisitor visitor = new CCBEvalVisitor(this.ccbDatasource);
        return visitor.visit(tree);
    }
}
