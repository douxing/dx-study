/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    int dfs(Map<Integer, Employee> m, int id) {
        Employee emp = m.get(id);
        int res = emp.importance;
        for (int i = 0; i < emp.subordinates.size(); i += 1) {
            res += dfs(m, emp.subordinates.get(i));
        }
        return res;
    }

    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> m = new HashMap();
        for (int i = 0; i < employees.size(); i += 1) {
            Employee emp = employees.get(i);
            m.put(emp.id, emp);
        }
        return dfs(m, id);
    }
}
