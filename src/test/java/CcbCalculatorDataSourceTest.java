import org.example.ccb.ValueHolder;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;


public class CcbCalculatorDataSourceTest extends BaseCcbCalculatorTest {
    @Test
    void whenContextObjectAndStringEqualsThanTrue() {
        Mockito.when(ccbDatasource.getContextObjectValue(Mockito.any()))
                .thenReturn(new ValueHolder("APH"));
        ValueHolder result = evaluate("IF[SA[EO:EO-TYPE]='APH']THEN[TRUE]ELSE[FALSE]");
        assertThat(result.asBoolean()).isEqualTo(Boolean.TRUE);
    }

    @Test
    void whenTrueThanMultidimensionalBillFactorReturn100() {
        Mockito.when(ccbDatasource.getMultidimensionalBillFactorValue(Mockito.any()))
                .thenReturn(new ValueHolder(new BigDecimal(100)));
        ValueHolder result = evaluate("IF[TRUE=TRUE]THEN[MDBF[PRIC-SA2;4:RKWH;8:SCZ]]ELSE[0]");
        assertThat(result.asNumber()).isEqualTo(new BigDecimal(100));
    }
}
