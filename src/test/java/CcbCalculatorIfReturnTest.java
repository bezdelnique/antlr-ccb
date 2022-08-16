import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

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
        assertThat(result.asNumber()).isEqualTo(new BigDecimal(1));
    }

    @Test
    void whenNotEqualsReturnTwo() {
        ValueHolder result = evaluate("if[1!=1]then[1]else[2]");
        assertThat(result.asNumber()).isEqualTo(new BigDecimal(2));
    }

    @Test
    void whenEqualsReturnAbc() {
        ValueHolder result = evaluate("if[1=1]then['abc']else['cba']");
        assertThat(result.asString()).isEqualTo("abc");
    }

    @Test
    void whenNotEqualsReturnCba() {
        ValueHolder result = evaluate("if[1!=1]then['abc']else['cba']");
        assertThat(result.asString()).isEqualTo("cba");
    }
}
