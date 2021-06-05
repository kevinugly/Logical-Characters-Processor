package block;

import java.util.function.*;
import java.util.stream.*;

public interface Processor {
  @SafeVarargs
  static String process(String input, Function<String, String>... blocks) {
    Function<String, String> combinedBlocks = Stream.of(blocks)
      .reduce(Function.identity(), Function::andThen);

    return Stream.of(input.split(""))
      .map(combinedBlocks)
      .collect(Collectors.joining(""));
  }
}