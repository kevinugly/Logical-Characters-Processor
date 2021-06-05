package block;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ProcessorTest {
  @Test
  void noBlockProcessor() {
    assertEquals("abcd", Processor.process("abcd"));
  }

  @Test
  void upperCaseBlockProcessor() {
    assertEquals("ABCD", Processor.process("abcd", Block::upperCaseConverterBlock));
  }

  @Test
  void lowerCaseBlockProcessor() {
    assertEquals("abcd", Processor.process("abcd", Block::lowerCaseConverterBlock));
  }

  @Test
  void multiplierBlockProcessor() {
    assertEquals("aabbccdd", Processor.process("abcd", Block::multiplierBlock));
  }

  @Test
  void upperCaseBlock_ZBlockerBlock() {
    assertEquals("ABCD", Processor.process("abzcd", Block::upperCaseConverterBlock, Block.createCharacterBlocker("Z")));
  }

  @Test
  void ZBlockerBlock_upperCaseBlock() {
    assertEquals("ABZCD", Processor.process("abzcd", Block.createCharacterBlocker("Z"), Block::upperCaseConverterBlock));
  }

  @Test
  void upperCaseBlock_MultiplierBlock() {
    assertEquals("AABBZZCCDD", Processor.process("abzcd", Block::upperCaseConverterBlock, Block::multiplierBlock));
  }

  @Test
  void ZBlockerBlock_UpperCaseBlock_MultiplierBlock() {
    assertEquals("AABBZZCCDD", Processor.process("abzcd", Block.createCharacterBlocker("Z"), Block::upperCaseConverterBlock, Block::multiplierBlock));
  }
}