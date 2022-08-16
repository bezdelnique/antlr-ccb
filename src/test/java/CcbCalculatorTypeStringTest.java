import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorTypeStringTest extends BaseCcbCalculatorTest {
    @Test
    void whenInSingleQuotesEquals() {
        ValueHolder result = evaluate("if['a'='a']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenInDoubleQuotesEquals() {
        ValueHolder result = evaluate("if[\"a\"=\"a\"]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }
}
