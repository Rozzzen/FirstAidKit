import com.example.Garrot;
import com.example.Notepad;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalTime;

public class GarrotTest {

    @Test
    public void ApplicationDateTest() {
        Garrot garrot = new Garrot();
        Notepad notepad = new Notepad(25);
        garrot.stopBleeding(notepad);
        LocalTime localTime = LocalTime.now();
        Assert.assertEquals(localTime, garrot.getTime());
    }
}
