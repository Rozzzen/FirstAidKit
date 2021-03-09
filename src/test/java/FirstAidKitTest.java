import com.zhuk.domain.aidkit.*;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;

public class FirstAidKitTest {
    @Test
    public void EqualsTest() {
        Bandage bandage = new Bandage(10, 50, Material.CLOTH, true);
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(bandage)), new Notepad(50), new Gloves(Material.RUBBER),  Collections.singletonList(new Garrot()));
        FirstAidKit firstAidKit2 = new FirstAidKit(new ArrayList<>(Collections.singletonList(bandage)), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        Assert.assertTrue(firstAidKit1.equals(firstAidKit2) && firstAidKit2.equals(firstAidKit1));
        Assert.assertEquals(firstAidKit1.hashCode(), firstAidKit2.hashCode());
    }

    @Rule
    public ExpectedException expectedEx = ExpectedException.none();

    @Test
    public void ShouldThrowExceptionIfMissingAidKitComponent() {
        expectedEx.expect(RuntimeException.class);
        expectedEx.expectMessage("Missing bandage");
        Bandage bandage = new Bandage(10, 50, Material.CLOTH, true);
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(bandage)), new Notepad(50), new Gloves(Material.RUBBER),  Collections.singletonList(new Garrot()));

        firstAidKit1.getBandage();
        firstAidKit1.getBandage();
    }

    @Test
    public void BandagingMaterialTest() {

        Bandage bandagingMaterial = new Bandage(10, 50, Material.CLOTH,true);
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(new Bandage(10, 50, Material.CLOTH, true))), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new Bandage(10, 50, Material.LEATHER,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new Bandage(20, 40, Material.GAUZE,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);

        bandagingMaterial = new Bandage(10, 10, Material.GAUZE,true);
        firstAidKit1.add(bandagingMaterial);
        Assert.assertEquals(firstAidKit1.getBandage(), bandagingMaterial);
    }

}
