import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorReturnTest extends BaseCcbCalculatorTest {
    @Test
    void whenSumThen3() {
        ValueHolder result = evaluate("return[1+2*3]");
        assertThat(result.asNumber()).isEqualTo(new BigDecimal(7));
    }
}
