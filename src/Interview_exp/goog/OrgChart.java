/*How will you implement organizational chart?
Implement two methods - isPeer - Should return true
if two employees have same managers. isManager - should
return true if manager is management chain of given employee.
*/
class Sln{
    boolean isManager(String empId, String managerId,
                      map<String,String> mp){
        if(mp[empId]==managerId)
            return true;
        else if(mp[empId]==null)
            return false;
        else return isManager(mp[empId],managerId,mp);
    }
}