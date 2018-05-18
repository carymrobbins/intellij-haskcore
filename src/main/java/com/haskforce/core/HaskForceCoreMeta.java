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
      URL versionTxt = HaskForceCoreMeta.class.getClassLoader().getResource("version.txt");
      if (versionTxt == null) throw new RuntimeException("Could not find HaskForce-Core version.txt");
      try {
        cachedVersion = ResourceUtil.loadText(versionTxt).trim();
      } catch (IOException e) {
        throw new RuntimeException("Failed to load HaskForce-Core version", e);
      }
    }
    return cachedVersion;
  }

  private static String cachedVersion = null;
}
