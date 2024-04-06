import java.util.ArrayList;
import java.util.List;

public class TreeAncestor {

  private List<int[]> ancestors;

  public TreeAncestor(int n, int[] parent) {
    ancestors = new ArrayList<>();
    ancestors.add(parent);
    for(int i = 1; i < n; i++) {
      int[] ancestor = new int[n];
      boolean stop = true;
      for(int j = 0; j < n; j++) {
        int index = ancestors.get(i - 1)[j];
        if (index < 1) {
          ancestor[j] = -1;
        } else {
          stop = false;
          ancestor[j] = ancestors.get(i - 1)[index];
        }
      }
      if (stop) {
        break;
      } else {
        ancestors.add(ancestor);
      }
    }
  }

  public int getKthAncestor(int node, int k) {
    if (k < 1 || k > (1 << (ancestors.size() - 1))) {
      return -1;
    }
    for(int j = 0; j < ancestors.size(); j++) {
      if (((k >> j) & 1) != 0) {
        node = ancestors.get(j)[node];
        if (node == -1) {
          return node;
        }
      }
    }
    return node;
  }

  public static void main(String[] args) {
    TreeAncestor treeAncestor = new TreeAncestor(10, new int[]{-1,0,0,1,2,0,1,3,6,1});
    System.out.println(treeAncestor.getKthAncestor(7, 3));
  }
}