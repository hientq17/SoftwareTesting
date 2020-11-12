import org.junit.*;
import static org.junit.Assert.*;
public class CheckTriangleTest {
    @Test
    public void test1() {
        assertEquals("Equilateral triangle", new CheckTriangle().checkAll(3,3,3));
    }
    @Test
    public void test2() {
        assertEquals("Isosceles triangle", new CheckTriangle().checkAll(3,3,4));
    }
    @Test
    public void test3() {
        assertEquals("Not triangle", new CheckTriangle().checkAll(12,27,80));
    }
    @Test
    public void test4() {
        assertEquals("Triangle", new CheckTriangle().checkAll(19,26,40));
    }
    @Test
    public void test5() {
        assertEquals("Input again", new CheckTriangle().checkAll(0,2,3));
    }
    @Test
    public void test6() {
        assertEquals("Input again", new CheckTriangle().checkAll(8,101,2));
    }
    @Test
    public void test7() {
        assertEquals("Input again", new CheckTriangle().checkAll(5,19,-4));
    }
    @Test
    public void test8() {
        assertEquals("Not triangle", new CheckTriangle().checkAll(92,27,10));
    }
    @Test
    public void test9() {
        assertEquals("Not triangle", new CheckTriangle().checkAll(12,82,22));
    }
    @Test
    public void test10() {
        assertEquals("Right triangle", new CheckTriangle().checkAll(3,4,5));
    }
    @Test
    public void test11() {
        assertEquals("Right triangle", new CheckTriangle().checkAll(12,13,5));
    }
    @Test
    public void test12() {
        assertEquals("Right triangle", new CheckTriangle().checkAll(10,6,8));
    }
}
