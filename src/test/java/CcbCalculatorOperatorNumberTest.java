import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorOperatorNumberTest extends BaseCcbCalculatorTest {
    @Test
    void whenTwoNumbersNotEqualsThanFalse() {
        ValueHolder result = evaluate("if[1=2]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenTwoNumbersEqualsThanTrue() {
        ValueHolder result = evaluate("if[1=1]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorGtFirstGreaterSecondThanFalse() {
        ValueHolder result = evaluate("if[5>10]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenOperatorLtFirstGreaterSecondThanTrue() {
        ValueHolder result = evaluate("if[5<10]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorEqAndEqualsThanTrue() {
        ValueHolder result = evaluate("if[5<>10]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOperatorEqButEqualsThanTrue() {
        ValueHolder result = evaluate("if[5<>5]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }
}
