package org.shuvava.helloworld;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.*;

public class HelloWorldTest {
  private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
  private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
  private final PrintStream originalOut = System.out;
  private final PrintStream originalErr = System.err;

  @Before
  public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
  }

  @After
  public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
  }

  @Test
  public void Main(){
    HelloWorld.main(null);
    String out = outContent.toString();

    Assert.assertFalse(out.isBlank());
  }
}
