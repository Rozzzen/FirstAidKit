package com.example;

import com.example.components.Gloves;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class FirstAidKitIT {

    Gloves gloves = Mockito.mock(Gloves.class);
    FirstAidKit firstAidKitWithGloves = new FirstAidKit(gloves);

    @Test
    public void GlovesOn_EqualsTrue_True() {
        final boolean expected = true;
        Mockito.doReturn(true).when(gloves).isON();
        boolean actual = firstAidKitWithGloves.isGlovesOn();
        Assert.assertEquals(actual, expected);
    }
}
