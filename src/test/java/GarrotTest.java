import com.zhuk.domain.aidkit.Garrot;
import com.zhuk.domain.aidkit.Notepad;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class GarrotTest {

    @Test
    public void ApplicationDateTest() {
        Notepad notepad = new Notepad(25);
        Garrot garrot = new Garrot(10, 20, notepad);
        garrot.stopBleeding();
        LocalTime localTime = LocalTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        Assert.assertEquals(formatter.format(localTime), formatter.format(garrot.getTime()));
    }
}