/*LC71:Simplify Path
Given an absolute path for a file (Unix-style),
* simplify it. Or in other words,
* convert it to the canonical path.

In a UNIX-style file system, a period .
* refers to the current directory.
*Furthermore, a double period ..
*  moves the directory up a level.
* For more information, see:
* Absolute path vs relative path in Linux/Unix

Note that the returned canonical
* path must always begin with a slash /,
*and there must be only a single slash
* / between two directory names.
* The last directory name (if it exists)
* must not end with a trailing /.
*  Also, the canonical path must
* be the shortest string representing the absolute path.


Example 1:

Input: "/home/"
Output: "/home"
Explanation: Note that there is no
* trailing slash after the last directory name.
Example 2:

Input: "/../"
Output: "/"
Explanation: Going one level up from the root
* directory is a no-op, as the root level is the highest level you can go.
Example 3:

Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path,
* multiple consecutive slashes are replaced by a single one.
Example 4:

Input: "/a/./b/../../c/"
Output: "/c"
Example 5:

Input: "/a/../../b/../c//.//"
Output: "/c"
Example 6:

Input: "/a//b////c/d//././/.."
Output: "/a/b/c"*/
class Solution {
    public String simplifyPath(String path) {
        // Handle empty string
        if (path.isEmpty()) {
            return path;
        }
        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] comps = path.split("/");

        // Split the input string on "/" as the delimiter
        // and process each portion one by one
        for (String dir : comps) {
            // A no-op for a "." or an empty string
            if (dir.equals(".") || dir.isEmpty()) {
                continue;
            }
            else if (dir.equals("..")) {
                // If the current component is a "..", then
                // we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else {
                // Finally, a legitimate directory name, so we add it
                // to our stack
                stack.add(dir);
            }
        }
        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() > 0 ? result.toString() : "/" ;
    }
}

class Sln{
    public String simplyfyPath(String path){
        if(path.isEmpty()){
            return path;
        }
        Stack<String> st=new Stack<String>();
        String[] comps=path.split("/");

        for(String dir:comps){
            if(dir.equals(".")||dir.isEmpty()){
                continue;
            }
            else if(dir.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else {
                st.push(dir);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String dir:st){
            sb.append("/");
            sb.append(dir);
        }
        return sb.length()>0?sb.toString():"/";
    }
}