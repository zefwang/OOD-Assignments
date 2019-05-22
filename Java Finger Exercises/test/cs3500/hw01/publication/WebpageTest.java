package cs3500.hw01.publication;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This class is used to test the Webpage class and its two methods.
 */
public class WebpageTest {
  Publication handin = new Webpage("Handin Server", "https://handins.ccs.neu.edu",
          "May 9, 2019");

  @Test
  public void testCiteApa() {
    assertEquals("Handin Server. Retrieved May 9, 2019, from https://handins.ccs.neu.edu.",
            handin.citeApa());
  }

  @Test
  public void testCiteMla() {
    assertEquals("\"Handin Server.\" Web. May 9, 2019 <https://handins.ccs.neu.edu>.",
            handin.citeMla());
  }
}