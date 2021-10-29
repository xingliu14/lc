## General:
.addAll()可以把一个collection里的元素全部加到另一个collection里面  
对于List<Integer> list = new ArrayList<Interger> ()的理解：List是一个接口，而ArrayList是这个接口的实现类。那些ArrayList有的功能但是List没有的就不能用了  
Arrays.fill(someArray, -1);  
匿名比较器：intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));  
直接声明并初始化一个list：List<Integer> list = Arrays.asList(2, 3, 41, 2, 4, 2);  
set的查找时间复杂度是O(1)  
`bitCount(int i)`: 返回一个int的二进制表示的1个数  
```
// 直接break外层循环
for(int i : int[]) search: {
	for() {
		break search;
	}
}
```

## String:
#### 常用函数：
`charAt()`：减去'0'可以获得数字值  
`isEmpty()`  
`遍历`：  
- for(char c: word.toCharArray())
- for(int i = 0; i < word.length; i++)

`toUpperCase(), toLowerCase()`：记得要把它赋给另一个对象  
`string.trim()`消去空格  
`string.lastIndexOf('char')`：字面意思  
`contains(), isDigit()`：判断某一个char属不属于一个集合，先toString再contains，判断数字直接用isDigit  
`substring()`：前包后不包  
`equals(str)`：直接判断等不等于  
`indexOf()`：找到第一个出现的位置，没有返回-1。甚至可以直接判断是不是substring  
`str+str`：直接相加  
`int变String`：int+""可以直接把int变成String，或者String.valueOf(int)也可以  
`String变int`：Integer.parseInt(str)  
`split('char')`：返回一个数组  
`compareTo(String)`：可以得到按照字母排序的结果

#### 其他信息：
`StringBuilder`：.toString(), insert(). append()，可以作用于char和stringbuilder
`从charArray到String`：不能直接用charArray.toString()得到string，String result = new String(S)；

## CharArray:
#### 常用函数：
`Character.isLetterOrDigit(char)`：判断是不是alphanumeric;  
`从charArray到String`：String result = new String(S); String.valueOf(arr)  

## Map:
#### 常用函数：
`初始化`：Map<Integer, Integer> map = new HashMap<>();  
`基本操作`get(), put(key, num), getOrDefault(key, defaultNum)，putIfAbsent(), map.remove(key);  
`遍历`：for (Map.Entry<Integer, Integer> entry : map.entrySet())；  
`操作entry`：entry.getValue(), map.containsKey(entry.getKey() + k)  
`put的返回值`：map.put()返回的是该key之前的值，或者null（若之前没有这个key）  
`按照key或者value遍历`：for (int key: map.keySet()) 按照key遍历整个map，for(int val : map.values())用value遍历整个map  
`Map当函数参数`：记得带上<type, type>，就像数组要带上[]  
`直接从map变list：`new ArrayList<List<String>>(map.values());

## Set:
#### 常用函数：
`初始化`：HashSet < String > trees = new HashSet < > ();  
`遍历`：for(String str: set)  
`删除`：remove()

## List:
#### 常用函数：
`初始化`：List < String > res = new ArrayList < > (); res.toArray(new String[res.size()]);  
`三种遍历方法`：for(String tmp:list); for(int i = 0; i < list.size(); i++); Iterator<String> iter = list.iterator(), while(iter.hasNext())  
`List变array（通过stream）`：int[] array = list.stream().mapToInt(i->i).toArray();   
`array变list`：Arrays.asList(num[i], num[j], num[k]);  
`初始化Queue`：Queue<Coordinate> queue = new LinkedList<>();  
`get()和put()和add()`
`addAll()：适用于bucket sort`  

## Stack:
#### 常用函数：
`初始化`：Stack<type> stack = new Stack<Character>();  
`基本操作`：stack.push(); stack.pop(); stack.isEmpty(), stack.peek();

## Tree:
#### 常用函数：
`Preorder Traversal`

## Queue:
#### 常用函数：
`初始化`：Queue < Integer > queue = new LinkedList < > ();  
`add()，remove()`：remove()返回的是remove的那个值  
`offer(), poll()`  

## Priority Queue:
#### 常用函数：
放入优先队列的对象要实现comparable接口， 
`初始化`：PriorityQueue<E> pq = new PriorityQueue<E>(); PriorityQueue<E> pq = new PriorityQueue(int initialCapacity, Comparator<E> comparator);  
`自定义comparator, Arrays.sort()的第二个参数可以加comparator！`：
```
Comparator<String> comp = new Comparator<String>(){
	@Override
	public int compare(String str1, String str2){
		String s1 = str1 + str2;
		String s2 = str2 + str1;
		return s2.compareTo(s1); // reverse order here, so we can do append() later
	}
};
```  
`deque`：是Double ended queue的意思。  
`使用例子请见第179题！`

## THE STUPID MISTAKES:
创建一个新的array：new type[size];  
基本类型是值传递，引用类型的对象传递。  
构造函数要传参数进去  
short, char: 2bytes; int, float: 4bytes; long, double: 64  
string.length要加括号！！！  
`很关键`，数组不能直接作为map或set的key，因为它们不能直接判断相等，要用int或者string  
CharArray不能用.toString()!!!反过来到时可以用toCharArray()  
注意！String不能直接用==判断相等！  
JAVA没有bool，只有B/boolean！  

## Math:
`Math.pow()`：返回的double

## StringBuilder & StringBuffer:
String是不可改变的，每次操作都会产生新的String，这两个东西都是为了减少开销。StringBuffer是线程安全的（synchronized），所以效率比StringBuilder低。  
从jdk1.5开始，用加号拼接字符串隐式变成stringBuilder，也就是说没有性能损失  
有.delete(n, m)，.reverse()，.append(“str”)，.insert(location, “str”)，.replace(startLoc, endLoc, “str”)，.setCharAt(loc, ‘char’)，toString()等方法

## TreeMap
#### 常用函数：
他是一个ordered map
TreeMap<K, V> map = new TreeMap<> ();  
firstKey(), replace()
map.higherKey(key)：返回大于输入值的最小的值，在排序的时候很管用