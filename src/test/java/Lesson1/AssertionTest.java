package Lesson1;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class AssertionTest {
    class user{
        private String name;
        private int age;
        public user(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    @Test
    public void Assert_Junit()
    {
        int a = 5;
        int b=5;
        //1. assertEquals - Kiem tra 2 gia tri co giong nhau khong?
        assertEquals(a, b); //a la expected
        //2. assertTrue(dk) - Kiem tra dk co dung hay khong?
        //assertTrue(a==b);
        //assertFalse(a!=b);
        //3. assertNull(val) - Kiem tra val co la nul hay khong?
        // assertNotNull(val)
        //assertNull(null);
        //4. assertSame
//        user s1 = new user("samsung",10);
//        user s2 = s1;
//        user s3 = s1;
//        assertSame(s2, s3);
        //5. assertArrayEqual
        int[] arr1 = {1,2,3};
        int[] arr2 = {1,2,3};
        assertArrayEquals(arr1, arr2);

        //6. assertThrow - Kiem tra 1 exception co dc throw ra ko?
        //assertThrows(AssertionError.class, ()->functionUnderTest);
        //Neu muon assert content cua exception thi
        //Exception ex = assertThrows(AssertionError.class, ()->functionUnderTest);
        //Sau do assert ex.getMessage()

    }

    @Test
    public void Asssert_Hamrest()
    {
        String s = null;
        int a = 5;
        int b=5;
        //Tat ca assert deu la assertThat, nhung tuy thuoc vao muc dich se co su dung
        //mot matcher tuong ung phia sau
        //1. tuong ung vs assertEquals, thi co matcher equalTo(value)
        assertThat(a, equalTo(b)); //a la cai can kiem tra, b la mong muon
        assertThat(a, is(b)); //
        //2.
        boolean c = a==b;
        assertThat(c, is(true)); //is la matcher hay su dung vs boolean, object
        //3. assert Null
        //assertThat(s, is(null));
        //assertThat(s, not(is(null)));

        //assertArrayEqual
        Integer[] arr1 = {1,2,3};
        Integer[] arr2 = {3,2,1};
        //so sanh 2 mang giong nhau (giong assertArrayEquals trong junit)
        //assertThat(arr1, is(arr2));
        //so sanh 2 mang khong can giong nhau o cac vi tri tuong ung
        assertThat(arr1, arrayContainingInAnyOrder(arr2));
        //arrayContaining - kiem tra cac phan tu co trong mang khong?
        assertThat(Arrays.asList(arr1), anyOf(hasItem(1), hasItem(4)));
    }
}
