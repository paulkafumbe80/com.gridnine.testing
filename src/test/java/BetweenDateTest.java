import com.Assertions;
import com.gridnine.testing.DataFiltering;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.LocalTime;

public class BetweenDateTest<DataFfiltering> {
    @Test
    public void betweenTimeTest() {

        DataFfiltering df = (DataFfiltering) new DataFiltering();
        LocalTime time = LocalTime.now();
        LocalDateTime nowPlusTwoHour = LocalDateTime.now().plusHours(2);
        int actual;
        actual = ((DataFiltering) df).between(nowPlusTwoHour);


    }
}