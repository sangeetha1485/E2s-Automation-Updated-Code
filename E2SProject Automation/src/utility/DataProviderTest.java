package utility;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class DataProviderTest {
  @Test(dataProvider = "Authentication")
  public void f(Integer n, String s) {
  }

  @DataProvider
  public Object[][] dp() {
    return new Object[][] {
      new Object[] { 1, "a" },
      new Object[] { 2, "b" },
    };
  }
}
