import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorIfConditionBlockCombineLogicalOperatorsTest extends BaseCcbCalculatorTest {
    @Test
    void whenAndEqualsThenTrue() {
        ValueHolder result = evaluate("if[(1=1)&&('a'='a')]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenOrEqualsThenTrue() {
        ValueHolder result = evaluate("if[(1=1)||('a'='a')]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenAndLeftNotEqualsThenFalse() {
        ValueHolder result = evaluate("if[(1=2)&&('a'='a')]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenOrLeftNotEqualsThenTrue() {
        ValueHolder result = evaluate("if[(1=2)||('a'='a')]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenNumberNotEqualsButNegationThenTrue() {
        ValueHolder result = evaluate("if[!(1=2)]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenNumberNotEqualsButNegationWordThenTrue() {
        ValueHolder result = evaluate("if[not(1=2)]then[true]else[false]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }
}
