////
//// YOU SHOULD NOT MODIFY THIS FILE
////
//// (You don't need to submit it, either.)
////

package cs3500.hw01.publication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BookTest {
  Publication rushdie = new Book("Midnight's Children", "Salman Rushdie",
                                 "Jonathan Cape", "London", 1980);

  @Test
  public void testCiteApa() {
    assertEquals("Salman Rushdie (1980). Midnight's Children. "
                   + "London: Jonathan Cape.",
                 rushdie.citeApa());
  }

  @Test
  public void testCiteMla() {
    assertEquals("Salman Rushdie. Midnight's Children. London: "
                   + "Jonathan Cape, 1980.",
                 rushdie.citeMla());
  }

  @Test
  public void testOne(){
    int a = 2;
    int b = 3;

    assertNotEquals(a, b);
  }

  @Test
  public void testTwo(){
    int a = 2;
    int b = 3;

    assertNotEquals("A equals B", a, b);
  }
}
