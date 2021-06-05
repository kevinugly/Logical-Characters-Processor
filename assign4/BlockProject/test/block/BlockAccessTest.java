package block;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class BlockAccessTest {
  @Test
  void BuiltinBlocks_upperCase() throws Exception {
    assertEquals(Block.upperCaseConverterBlock("abzcd"), BlockAccess.getBlock("block.Block", "upperCaseConverterBlock").apply("abzcd"));
  }

  @Test
  void BuiltinBlocks_multiplier() throws Exception {
    assertEquals(Block.multiplierBlock("abzcd"), BlockAccess.getBlock("block.Block", "multiplierBlock").apply("abzcd"));
  }

  @Test
  void BuiltinBlocks_makeBlocker_Z() throws Exception {
    assertEquals(Block.createCharacterBlocker("Z").apply("abzcd"), BlockAccess.getBlock("block.Block", "createCharacterBlocker", "Z").apply("abzcd"));
  }

  @Test
  void BuiltinBlocks_makeBlocker_k() throws Exception {
    assertEquals(Block.createCharacterBlocker("k").apply("abzcd"), BlockAccess.getBlock("block.Block", "createCharacterBlocker", "k").apply("abzcd"));
  }

  @Test
  void invalidBlockError() throws Exception {
    try {
      BlockAccess.getBlock("block.Block", "multiplierBlock").apply(null);
      fail("Exception was not thrown");
    } catch(RuntimeException ex) {
      assertTrue(ex.toString().contains("Invalid"), "Invalid input");
    }
  }
}