import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorComparatorTest extends BaseCcbCalculatorTest {
    @Test
    void whenTwoIntegersNotEqualsThanFalse() {
        ValueHolder result = evaluate("if[1=2]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.FALSE);
    }

    @Test
    void whenTwoIntegersEqualsThanTrue() {
        ValueHolder result = evaluate("if[1=1]then[true]else[false]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTwoIntegersEqualsThanTrueTokenUpperCase() {
        ValueHolder result = evaluate("IF[1=1]THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTwoStringsEqualsThanTrue() {
        ValueHolder result = evaluate("IF[\"APH\"='APH']THEN[TRUE]ELSE[FALSE]");

        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }
}
