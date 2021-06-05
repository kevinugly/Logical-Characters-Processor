package block;

import java.util.function.*;

public interface Block {
  static String upperCaseConverterBlock(String input) {
    return input.toUpperCase();
  }

  static String lowerCaseConverterBlock(String input) {
    return input.toLowerCase();
  }

  static String multiplierBlock(String input) {
    return input.repeat(2);
  }

  static Function<String, String> createCharacterBlocker(String characterToBlock) {
    return input -> input.replace(characterToBlock, "");
  }
}