package com.example;

import com.example.components.Garrot;
import com.example.components.Gloves;
import com.example.components.Notepad;
import com.example.exceptions.FirstAidKitException;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class FirstAidKitIT {

    Gloves gloves = Mockito.mock(Gloves.class);
    Notepad notepad = Mockito.mock(Notepad.class);
    Garrot garrot = Mockito.mock(Garrot.class);
    FirstAidKit firstAidKitWithGloves = new FirstAidKit(gloves);
    FirstAidKit firstAidKitWithGarrots = new FirstAidKit(garrot);
    FirstAidKit firstAidKit = Mockito.mock(FirstAidKit.class);

    @Test
    public void GlovesOn_EqualsTrue_True_Test() {
        final boolean expected = true;
        Mockito.doReturn(true).when(gloves).isON();
        boolean actual = firstAidKitWithGloves.isGlovesOn();
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void When_ReadAll_Expect_HelloTest() {
        Mockito.doAnswer(invocationOnMock -> "Hello test").when(notepad).readAll();
        Assert.assertEquals(notepad.readAll(), "Hello test");
    }

    @Test
    public void GetTime_EqualsCurrentTime_Test() {
        Mockito.doReturn(LocalTime.now()).when(firstAidKitWithGarrots.getFirstGarrot()).getTime();
        Assert.assertEquals(firstAidKitWithGarrots.getFirstGarrot().getTime().format(DateTimeFormatter.ofPattern("HH:mm")),
                            LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm")));
    }

    @Test(expected = FirstAidKitException.class)
    public void whenGetBandageThrowException() {
        Mockito.doThrow(new FirstAidKitException("Missing Bandage")).when(firstAidKit).getBandage();
        firstAidKit.getBandage();
    }

}
