import com.example.*;
import com.example.bandages.Bandage;
import com.example.bandages.BandagingMaterial;
import com.example.bandages.GauzeNapkin;
import org.junit.Assert;
import org.junit.Test;
import org.hamcrest.collection.IsMapContaining;
import java.util.*;
import java.util.stream.Collectors;

import static com.example.FirstAidKit.getMostFrequentChildNames;
import static org.hamcrest.core.Is.is;

public class CollectionToolsTest {
    CuttingDevice scalpel = new CuttingDevice() {
        @Override
        public void cut() { System.out.println("incision was made with a scalpel");}
        @Override
        public String toString() {return "Scalpel";}
    };
    Pen pencil = new Pen() {
        @Override
        public void write(Notepad notepad, String message) {
            notepad.writePage(message);
            System.out.println("Message was written using pencil"); }
        @Override
        public String toString() {return "Pencil"; }
    };

    @Test
    public void getMostFrequentChildNamesTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.getDummyList().add(new Dummy("Rachel", new DummyDaughter(1, "John"),
                new DummyDaughter(2, "Marie")));
        firstAidKit1.getDummyList().add(new Dummy("Michael",new DummyDaughter(1, "Ivan"),
                new DummyDaughter(2, "Ivanna"),
                new DummyDaughter(2, "Ivanna"),
                new DummyDaughter(1, "John"),
                new DummyDaughter(1, "John")));
        List<String> result = getMostFrequentChildNames(firstAidKit1.getDummyList());
        List<String> expected = Arrays.asList("John", "Ivanna");
        Assert.assertEquals(result, expected);
    }

    @Test
    public void getClothMaxLengthTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK));
        List<BandagingMaterial> list = firstAidKit1.getBandages();
        int actual = FirstAidKit.getClothLengthSum(list);
        int expected = 120;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAverageLengthTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK));
        List<BandagingMaterial> list = firstAidKit1.getBandages();
        double actual = FirstAidKit.getAverageLength(list);
        double expected = 100;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getMaxLengthTest() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new GauzeNapkin(10, 50, Material.CLOTH), scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK));
        List<BandagingMaterial> list = firstAidKit1.getBandages();
        int actual = FirstAidKit.getMaxLength(list);
        int expected = 150;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGroupByMaterialAndLengthTest() {
        BandagingMaterial clothBandage = new Bandage(10, 50, Material.CLOTH);
        BandagingMaterial gauzeBandage = new Bandage(20, 100, Material.GAUZE);
        FirstAidKit firstAidKit1 = new FirstAidKit(clothBandage, scalpel, new Notepad(50), pencil, new Garrot(), new ARMask(), new Gloves(Material.RUBBER));
        firstAidKit1.add(gauzeBandage);
        List<BandagingMaterial> list = firstAidKit1.getBandages();

        Map<Boolean, List<BandagingMaterial>> actual = list.stream().
                collect(Collectors.groupingBy((p) -> p.getMaterial().equals(Material.CLOTH) && p.getLength() > 30));

        Map<Boolean, List<BandagingMaterial>> expected = new HashMap<>();
        List<BandagingMaterial> expectedFalseList = Collections.singletonList(gauzeBandage);
        List<BandagingMaterial> expectedTrueList = Collections.singletonList(clothBandage);
        expected.put(false, expectedFalseList);
        expected.put(true, expectedTrueList);

        Assert.assertEquals(expected, actual);
    }
}
