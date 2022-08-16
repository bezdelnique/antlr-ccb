import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorComparatorStringTest extends BaseCcbCalculatorTest {
    @Test
    void whenTwoStringsNotEqualsThanFalse() {
        ValueHolder result = evaluate("if['a'='b']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenTwoStringsEqualsThanTrue() {
        ValueHolder result = evaluate("if['a'='a']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorGtFirstGreaterSecondThanFalse() {
        ValueHolder result = evaluate("if['a'>'b']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenOperatorLtFirstGreaterSecondThanTrue() {
        ValueHolder result = evaluate("if['a'<'b']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorEqAndEqualsThanTrue() {
        ValueHolder result = evaluate("if['a'<>'b']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorEqButEqualsThanFalse() {
        ValueHolder result = evaluate("if['a'<>'a']then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }
}
