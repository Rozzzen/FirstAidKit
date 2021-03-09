import com.zhuk.domain.aidkit.*;
import com.zhuk.service.BandageCollectionService;
import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class CollectionServiceTest {

    BandageCollectionService bandageCollectionService = new BandageCollectionService();

    @Test
    public void getMostFrequentBandageMaterials_TwoMostFrequentNames_True() {
        Bandage bandage = new Bandage(10, 50, Material.CLOTH, true);
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(bandage)), new Notepad(50), new Gloves(Material.RUBBER),  Collections.singletonList(new Garrot()));
        FirstAidKit firstAidKit2 = new FirstAidKit(new ArrayList<>(Collections.singletonList(bandage)), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        firstAidKit2.add(new Bandage(10, 50, Material.CLOTH, true));
        firstAidKit2.add(new Bandage(10, 50, Material.CLOTH, true));
        firstAidKit2.add(new Bandage(10, 50, Material.SILK, true));
        firstAidKit2.add(new Bandage(10, 50, Material.SILK, true));
        firstAidKit2.add(new Bandage(10, 50, Material.SILK, true));
        firstAidKit1.add(new Bandage(10, 50, Material.LEATHER, false));
        firstAidKit1.add(new Bandage(10, 50, Material.LEATHER, false));
        firstAidKit1.add(new Bandage(10, 50, Material.GAUZE, false));
        List<FirstAidKit> firstAidKitList = Arrays.asList(firstAidKit1, firstAidKit2);
        List<String> actual = bandageCollectionService.getMostFrequentBandageMaterials(firstAidKitList);
        List<String> expected = Arrays.asList("Leather", "Cloth");
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getClothMaxLength_Equals120_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(new Bandage(10, 50, Material.CLOTH, true))), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE, true));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE, true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER, true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH, true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK, true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK, true));
        int actual = bandageCollectionService.getClothLengthSum(firstAidKit1.getBandages());
        int expected = 120;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getAverageLength_Equals100_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(new Bandage(10, 50, Material.CLOTH, true))), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE, true));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE, true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER, true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH, true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK, true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK, true));
        double actual = bandageCollectionService.getAverageLength(firstAidKit1.getBandages());
        double expected = 100;
        Assert.assertEquals(actual, expected, 0);
    }

    @Test
    public void getMaxLength_Equals150_True() {
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(new Bandage(10, 50, Material.CLOTH, true))), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        firstAidKit1.add(new Bandage(20, 100, Material.GAUZE, true));
        firstAidKit1.add(new Bandage(30, 150, Material.LEATHER, true));
        firstAidKit1.add(new Bandage(10, 70, Material.CLOTH, true));
        firstAidKit1.add(new Bandage(20, 80, Material.SILK, true));
        firstAidKit1.add(new Bandage(30, 150, Material.SILK, true));
        int actual = bandageCollectionService.getMaxLength(firstAidKit1.getBandages());
        int expected = 150;
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void getGroupByMaterialAndLength_Filter_True() {
        Bandage clothBandage = new Bandage(10, 50, Material.CLOTH, true);
        Bandage gauzeBandage = new Bandage(20, 100, Material.GAUZE, true);
        FirstAidKit firstAidKit1 = new FirstAidKit(new ArrayList<>(Collections.singletonList(clothBandage)), new Notepad(50), new Gloves(Material.RUBBER), Collections.singletonList(new Garrot()));
        firstAidKit1.add(gauzeBandage);

        Map<Boolean, List<Bandage>> actual = bandageCollectionService.getGroupByMaterialAndLength(p -> p.getMaterial().equals(Material.CLOTH) && p.getLength() > 30, firstAidKit1);
        Map<Boolean, List<Bandage>> expected = new HashMap<>();

        List<Bandage> expectedFalseList = Collections.singletonList(gauzeBandage);
        List<Bandage> expectedTrueList = Collections.singletonList(clothBandage);
        expected.put(false, expectedFalseList);
        expected.put(true, expectedTrueList);

        Assert.assertEquals(expected, actual);
    }
}
