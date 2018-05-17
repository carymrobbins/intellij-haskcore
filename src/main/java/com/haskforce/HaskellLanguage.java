package com.haskforce;

import com.intellij.lang.Language;

public class HaskellLanguage extends Language {

  public static final String ID = "Haskell";

  public static final HaskellLanguage INSTANCE = new HaskellLanguage();

  private HaskellLanguage() {
    super(ID);
  }

  @Override
  public boolean isCaseSensitive() {
    return true;
  }
}
