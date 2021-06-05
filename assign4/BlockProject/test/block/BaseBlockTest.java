package block;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.util.stream.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public interface BaseBlockTest {
  String blockFunction(String character);
  Stream<Arguments> specificCaseArguments();

  @ParameterizedTest
  @MethodSource({"specificCaseArguments"})
  default void testBlock(String character, String expected) {
    assertEquals(expected, blockFunction(character));
  }
}