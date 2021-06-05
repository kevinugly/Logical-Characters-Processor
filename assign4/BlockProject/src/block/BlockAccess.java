package block;

import java.lang.reflect.*;
import java.util.function.*;

@SuppressWarnings("unchecked")
public interface BlockAccess {
  static <T> Function<String, T> getBlock(String className, String methodName) throws Exception {
    Method method = Class.forName(className).getMethod(methodName, String.class);

    return input -> {
      try {
        return (T) method.invoke(null, input);
      }
      catch (Exception ex) {
        throw new RuntimeException("Invalid input");
      }
    };
  }

  static Function<String, String> getBlock(String className, String methodName, String arg) throws Exception {
    return (Function<String, String>) getBlock(className, methodName).apply(arg);
  }
}
