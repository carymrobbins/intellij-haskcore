package com.haskforce.core;

import com.intellij.openapi.util.io.FileUtilRt;
import junit.framework.TestCase;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

public class HaskForceCoreMetaTest extends TestCase {

  public void testGetVersion() {
    String expected;
    try {
      expected = FileUtilRt.loadFile(new File("version.txt")).trim();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    String actual = HaskForceCoreMeta.VERSION;
    assertMatchesRegex(versionPattern, expected);
    assertEquals(expected, actual);
  }

  private static Pattern versionPattern = Pattern.compile("^\\d+\\.\\d+\\.\\d+(-SNAPSHOT(-.*)?)$");

  private void assertMatchesRegex(Pattern p, String s) {
    if (!p.matcher(s).matches()) {
      throw new AssertionError("Regex " + p + " not matched by string: " + s);
    }
  }
}
