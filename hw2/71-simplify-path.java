public class Solution {
    /*
    parse string by /
    case: "", . .. dir 
	intuition: empty path - return "/" 
		deal with empty case at begining and at end of validation
    */
    public String simplifyPath(String path) {
        String[] list = path.split("/");
        String result = new String();
        
        if (list.length == 0){
            return result+"/";
        }
        
        Deque<String> pathList = new ArrayDeque<>();
        for (String s: list){
            if (s.equals(".") || s.length() == 0){
                continue;
            }
            else if (s.equals("..")){
                if (!pathList.isEmpty()) {
                    pathList.pollLast();
                }
            }
            else {
                s = "/" + s;
                pathList.offerLast(s);
            }
        }
        
        if (pathList.size() == 0){
            return result+"/";
        }
        
        for (String s: pathList){
            result = result + s;      
        }
        
        return result;
    }
}