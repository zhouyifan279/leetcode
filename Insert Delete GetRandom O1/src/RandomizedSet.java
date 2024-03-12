import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

class RandomizedSet {

  private Map<Integer, Integer> valToIndex = new HashMap<>();
  private List<Integer> valList = new ArrayList<>();
  private Random random = new Random();

  public RandomizedSet() {

  }

  public boolean insert(int val) {
    if (valToIndex.containsKey(val)) {
      return false;
    } else {
      valToIndex.put(val, valList.size());
      valList.add(val);
      return true;
    }
  }

  public boolean remove(int val) {
    Integer index = valToIndex.remove(val);
    if (index != null) {
      Integer lastVal = valList.remove(valList.size() - 1);
      if (val != lastVal) {
        valToIndex.put(lastVal, index);
        valList.set(index, lastVal);
      }
      return true;
    } else {
      return false;
    }
  }

  public int getRandom() {
    int n = random.nextInt(valList.size());
    return valList.get(n);
  }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */