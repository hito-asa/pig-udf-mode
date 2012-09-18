package pig.udf;

import java.io.IOException;
import java.util.Map;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;
import org.apache.pig.EvalFunc;
import org.apache.pig.data.Tuple;
import org.apache.pig.data.DataBag;

public class Mode extends EvalFunc<String> {
  @Override
  public String exec(Tuple input) throws IOException {
    if (input == null && input.size() != 0) {
      return null;
    }
    DataBag bag = (DataBag) input.get(0);
    Integer index = (Integer) input.get(1);
    Map<Object, AtomicLong> count = new HashMap<Object, AtomicLong>();
    Object maxKey = null;
    long maxValue = 0L;
    for (Tuple item : bag) {
      Object key = item.get(index);
      AtomicLong num = null;
      if (count.containsKey(key)) {
        num = count.get(key);
      } else {
        num = new AtomicLong(0L);
        count.put(key, num);
      }
      long value = num.incrementAndGet();
      if (value > maxValue) {
        maxValue = value;
        maxKey = key;
      }
    }
    return maxKey != null ? maxKey.toString() : "";
  }
}

