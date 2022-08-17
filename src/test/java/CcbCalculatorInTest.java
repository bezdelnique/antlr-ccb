import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorInTest extends BaseCcbCalculatorTest {
    @Test
    void whenNumberInRangeThenTrue() {
        ValueHolder result = evaluate("return[1 in (1,2,3)]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }


    @Test
    void whenStringInRangeThenTrue() {
        ValueHolder result = evaluate("return['heman' in ('olgago', 'veralo', 'heman')]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }
}
