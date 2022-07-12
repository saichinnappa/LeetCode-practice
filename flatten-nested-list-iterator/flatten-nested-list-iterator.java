/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> list;
    int idx = 0;
    List<Integer> result;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.list = nestedList;
        this.idx = 0;
        this.result = new ArrayList<>();
        flat(list);
    }

    @Override
    public Integer next() {
        // if(hasNext()){
            return result.get(idx++);
        // }
    }

    @Override
    public boolean hasNext() {
        if(idx < result.size())
            return true;
        else
            return false;
        
        
    }
    
    void flat(List<NestedInteger> l){
        for(int i = 0; i < l.size(); i++){
            if(l.get(i).isInteger()){
                result.add(l.get(i).getInteger());
            } else{
                flat(l.get(i).getList());
            }
        }
    }
    
    
    
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */