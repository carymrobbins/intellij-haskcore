package com.haskforce.core;

import com.intellij.util.ResourceUtil;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.net.URL;

public abstract class HaskForceCoreMeta {
  private HaskForceCoreMeta() {}

  @NotNull
  public static String getVersion() {
    if (cachedVersion == null) {
      String fileName = "haskforce-core/version.txt";
      URL versionTxt = HaskForceCoreMeta.class.getClassLoader().getResource(fileName);
      if (versionTxt == null) throw new RuntimeException("Could not find " + fileName);
      try {
        cachedVersion = ResourceUtil.loadText(versionTxt).trim();
      } catch (IOException e) {
        throw new RuntimeException("Failed to load " + fileName, e);
      }
    }
    return cachedVersion;
  }

  private static String cachedVersion = null;
}
