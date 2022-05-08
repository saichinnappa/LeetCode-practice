class FileSystem {
Map<String, Integer> map;
​
public FileSystem() {
map = new HashMap<>();
}
public boolean createPath(String path, int value) {
if(path == "" || path == "/" || map.containsKey(path))
return false;
int lastIndex = path.lastIndexOf("/");
if(lastIndex == 0){
map.put(path, value);
return true;
} else{
String subStr = path.substring(0, lastIndex);
if(map.containsKey(subStr)){
map.put(path, value);
return true;
}
}
return false;
}