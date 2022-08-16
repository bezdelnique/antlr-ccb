import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorIfReturnTest extends BaseCcbCalculatorTest {
    @Test
    void whenEqualsReturnTrue() {
        ValueHolder result = evaluate("if[1=1]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenNotEqualsReturnFalse() {
        ValueHolder result = evaluate("if[1!=1]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenEqualsReturnOne() {
        ValueHolder result = evaluate("if[1=1]then[1]else[2]");
        assertThat(result.asNumber()).isEqualTo(ValueHolder.fromInt(1).asNumber());
    }

    @Test
    void whenNotEqualsReturnTwo() {
        ValueHolder result = evaluate("if[1!=1]then[1]else[2]");
        assertThat(result.asNumber()).isEqualTo(ValueHolder.fromInt(2).asNumber());
    }
}
