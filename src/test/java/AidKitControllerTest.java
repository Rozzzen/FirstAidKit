import com.zhuk.controller.AidKitController;
import com.zhuk.domain.aidkit.Bandage;
import com.zhuk.domain.aidkit.FirstAidKit;
import com.zhuk.domain.aidkit.Material;
import com.zhuk.exception.aidkit.AidKitAlreadyExistsException;
import com.zhuk.exception.aidkit.AidKitNotFoundException;
import com.zhuk.repo.FakeAidKitDataAcess;
import com.zhuk.service.AidKitService;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AidKitControllerTest {

    private final AidKitController aidKitController;

    public AidKitControllerTest() {
        List<FirstAidKit> aidKits = new ArrayList<>();
        aidKits.add(new FirstAidKit(1L,null, null, null, null));
        aidKits.add(new FirstAidKit(2L,null, null, null, null));
        aidKits.add(new FirstAidKit(3L,null, null, null, null));
        aidKits.add(new FirstAidKit(4L,null, null, null, null));
        FakeAidKitDataAcess fakeAidKitDataAcess = new FakeAidKitDataAcess(aidKits);
        aidKitController = new AidKitController(new AidKitService(fakeAidKitDataAcess));
    }

    @Test
    public void shouldReturnAllAidKitsTest() {
        List<FirstAidKit> expected = new ArrayList<>();
        expected.add(new FirstAidKit(1L,null, null, null, null));
        expected.add(new FirstAidKit(2L,null, null, null, null));
        expected.add(new FirstAidKit(3L,null, null, null, null));
        expected.add(new FirstAidKit(4L,null, null, null, null));

        List<FirstAidKit> actual = aidKitController.AidkitList();

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAidKitWithIdOne() throws AidKitNotFoundException {
        FirstAidKit expected = new FirstAidKit(1L,null, null, null, null);

        FirstAidKit actual = aidKitController.AidKitById(1L);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldEditExistingAidKitWithIdOne() {
        List<FirstAidKit> expected = new ArrayList<>();

        FirstAidKit updateAidKit = new FirstAidKit(1L,
                Collections.singletonList(new Bandage(1L, 10, 20, Material.LEATHER,
                        true)), null, null, null);

        expected.add(updateAidKit);
        expected.add(new FirstAidKit(2L,null, null, null, null));
        expected.add(new FirstAidKit(3L,null, null, null, null));
        expected.add(new FirstAidKit(4L,null, null, null, null));

        List<FirstAidKit> actual = aidKitController.updateAidKit(1L, updateAidKit);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldCreateNewAidKitWithIdFive() {
        List<FirstAidKit> expected = new ArrayList<>();

        FirstAidKit updateAidKit = new FirstAidKit(1L,
                Collections.singletonList(new Bandage(1L, 10, 20, Material.LEATHER,
                        true)), null, null, null);

        expected.add(new FirstAidKit(1L,null, null, null, null));
        expected.add(new FirstAidKit(2L,null, null, null, null));
        expected.add(new FirstAidKit(3L,null, null, null, null));
        expected.add(new FirstAidKit(4L,null, null, null, null));
        expected.add(updateAidKit);

        List<FirstAidKit> actual = aidKitController.updateAidKit(5L, updateAidKit);

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldDeleteAidKitWithIdOne() {
        List<FirstAidKit> expected = new ArrayList<>();
        expected.add(new FirstAidKit(2L,null, null, null, null));
        expected.add(new FirstAidKit(3L,null, null, null, null));
        expected.add(new FirstAidKit(4L,null, null, null, null));
        
        List<FirstAidKit> actual = aidKitController.deleteAidKit(1L);

        Assert.assertEquals(expected, actual);
    }

    @Rule
    public final ExpectedException expectedException = ExpectedException.none();


    @Test
    public void shouldAddAidKitAndSetIdToFive() throws AidKitAlreadyExistsException {
        List<FirstAidKit> expected = new ArrayList<>();
        expected.add(new FirstAidKit(1L,null, null, null, null));
        expected.add(new FirstAidKit(2L,null, null, null, null));
        expected.add(new FirstAidKit(3L,null, null, null, null));
        expected.add(new FirstAidKit(4L,null, null, null, null));
        expected.add(new FirstAidKit(5L,null, null, null, null));

        List<FirstAidKit> actual = aidKitController.saveAidKit(new FirstAidKit(5L,null, null, null, null));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void shouldThrowAlreadyExistingException() throws AidKitAlreadyExistsException {
        expectedException.expect(AidKitAlreadyExistsException.class);
        List<FirstAidKit> temp = aidKitController.saveAidKit(new FirstAidKit(4L,null, null, null, null));
    }
}
