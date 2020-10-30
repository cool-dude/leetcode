/*LC71. Simplify Path
Given an absolute path for a file (Unix-style),
simplify it. Or in other words, convert it to the canonical path.

In a UNIX-style file system, a period . refers to the
current directory. Furthermore, a double period ..
moves the directory up a level. For more information,
see: Absolute path vs relative path in Linux/Unix

Example 1:
Input: "/home/"
Output: "/home"
Explanation: Note that there is no trailing slash after
the last directory name.

Example 2:
Input: "/../"
Output: "/"
Explanation: Going one level up from the root directory is a no-op,
as the root level is the highest level you can go.

Example 3:
Input: "/home//foo/"
Output: "/home/foo"
Explanation: In the canonical path, multiple consecutive slashes
are replaced by a single one.

Example 4:
Input: "/a/./b/../../c/"
Output: "/c"

Example 5:
Input: "/a/../../b/../c//.//"
Output: "/c"

Example 6:
Input: "/a//b////c/d//././/.."
Output: "/a/b/c"*/
/*Algo:
Initialize a stack, S that we will be using for
* our implementation.
Split the input string using / as the delimiter.
* This step is really important because no matter what,
* the given input is a valid path and we simply have
* to shorten it. So, that means that whatever we
* have between two / characters is either a directory
* name or a special character and we have to process them accordingly.
Once we are done splitting the input path, we
* will process one component at a time.
If the current component is a . or an empty string,
* we will do nothing and simply continue. Well if you think
* about it, the split string array for the string /a//b would
* be [a,,b]. yes, that's an empty string in between a and b.
* Again, from the perspective of the overall path, it doesn't mean anything.
If we encounter a double-dot .., we have to do some processing.
* This simply means go one level up in the current directory path.
* So, we will pop an entry from our stack if it's not empty.
Finally, if the component we are processing right now is not
* one of the special characters, then we will simply add it
* to our stack because it's a legitimate directory name.
Once we are done processing all the components, we simply have
* to connect all the directory names in our stack together using
* / as the delimiter and we will have our shortest path that leads
* us to the same directory as the one provided as an input.*/
class Sln {
    public String simplifyPath(String path) {
        // Handle empty string
        if (path.isEmpty()) {
            return path;
        }
        // Initialize a stack
        Stack<String> stack = new Stack<String>();
        String[] comps = path.split("/");
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
                stack.add(dir);
            }
        }
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }
        return result.length() > 0 ? result.toString() : "/" ;
    }
}