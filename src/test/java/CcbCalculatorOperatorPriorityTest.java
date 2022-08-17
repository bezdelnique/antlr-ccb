import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorOperatorPriorityTest extends BaseCcbCalculatorTest {
    @Test
    void whenSumThen3() {
        ValueHolder result = evaluate("return[1=1]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }
}
