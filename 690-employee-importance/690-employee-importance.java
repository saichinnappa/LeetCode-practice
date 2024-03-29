/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int result = 0;
    Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        for(Employee e: employees){
            map.put(e.id, e);
        }
        if(!map.containsKey(id))
            return 0;
        helper(map.get(id));
        return result;  
    }
    
    void helper(Employee e){
        result += e.importance;
        if(e.subordinates.size() > 0){
            for(int e1 : e.subordinates){
                helper(map.get(e1));
            }    
        }
    }
}