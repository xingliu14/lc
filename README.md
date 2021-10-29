## SB-Leetcode
Legacy notes

#### Union Find
首先需要一个UnionFind类，里面有一个parent和一个rank数组，存对应点的parant和rank。还有一个count来存有多少不连通的component。

initialize的时候parent全部是自己，rank全部是0，count是总共有多少个点。还有两个方程union(n1, n2)和find(n)

在原方程里直接对着每个为1的点的周围的点call union(n1, n1)，union先call find(n)来找到对应的最后的parent。小rank的parent就被大rank的parent当爸爸，rank一样的话随便选一个当爸爸，rank再加1，count再减1。

#### Tree Traversal
如果curr pointer或者stack一个不为空就继续，区别在于是push进去还是pop出来的时候读curr的值，post order的话直接用addFirst和左右颠倒实现。

#### 457. Circular Array Loop
题目描述太奇怪了，只能forword or backward

#### 475. Heaters
这道题题意有点奇怪，最终就是不要从heater出发来考虑，而要从house来考虑即可

#### 482. License Key Formatting
关键是取mod的时候的小技巧

#### 486. Predict the Winner
不能简单的用某一种可行的方案，因为对面是会用最好的方案的。必须用DP从后往前算

#### 505. The Maze II
死亡dfs，根本不管终点，只把全部地图走完，最后查步数

#### 524. Longest Word in Dictionary through Deleting
就是最朴素的做法，一个一个比

#### 549. Binary Tree Longest Consecutive Sequence II
二叉树还是得用递归，最开始处理root为空的情况，对于有很多种情况取最值的问题，用一个全局变量存

#### 562. Longest Line of Consecutive One in Matrix
这种短距离dp可以极限省空间，但是需要看哪些量需要提前保存

#### 568. Maximum Vacation Days
用HashMap做DP

#### 616. Add Bold Tag in String
对于这种题，关键是要想出中间转换最重要的点，这里面只需把一个char标记为需不需要括起来即可

#### 659. Split Array into Consecutive Subsequences.
用三个int表示终结在这个数字的总的sequence有多少

#### 676. Implement Magic Dictionary
白板mock过，非常简单暴力

#### 679. 24 Game
这种题本质上就是遍历全部情况，那么就可以用backtrack

#### 681. Next Closest Time
用simulation即可

#### 683. K Empty Slots
注意他最开始的数组的定义，以及coner case，比如0

#### 686. Repeated String Match
做出assumption之前一定要三思，这道题就是不论什么情况，可能的值都有两个

#### 723. Candy Crush
硬怼

#### 731. My Calendar II
用两个list，注意判断是否overlap的条件是start小于结束并且end大于开始

#### 734. Sentence Similarity
转换输入的数据结构是经常使用的方法

#### 750. Number Of Corner Rectangles
首先确定从下往上的算法，然后是利用数组长度上限把pair变成一个数，最后是确定每一个新的pair只和之前出现过的其他pair有关

#### 753. Cracking the Safe
奇奇怪怪的数学题

#### 766. Toeplitz Matrix
关键不用直接一行扫完，随便怎么扫都行，只要全部的点扫到了

#### 769. Max Chunks To Make Sorted
哈哈哈哈，直接比较最大值是否匹配即可

#### 771. Jewels and Stones
Straight forward hashset

#### 774. Minimize Max Distance to Gas Station
妈的传统就用heap，奇怪的就用binary search找全部答案空间，竟然是唯一能过的方法

#### 776. Split BST
一看到二叉树就要想到递归，想到递归就要定义递归最后输出值是什么，先处理最简单的情况（null），然后根据分析判断一般情况怎么进入分支，最后从分支的结果结合现在这一点的情况，向上返回。

#### 777. Swap Adjacent in LR String
手动双指针，外面和里面的循环分别判断边界，用xor简化代码

#### 800. Similar RGB Color
Integer.parseInt(<Integer>, 16)和String.format("%02x", <Integer>)可以再16进制和string间灵活转化

#### 809. Expressive Words
双指针怎么走，在for和while之间的艰难抉择

#### 815. Bus Routes
因为这道题是要找最短的路径（深度），所以用BFS，注意因为是从一个点到另一个点，所以用站当Key

#### 833. Find And Replace in String
TreeMap和TreeSet真好用

#### 844. Backspace String Compare
用最基本的栈可行，但因为删除发生在未来，所以必须要用空间来储存。如果从最后开始算，可以提前把删除存起来，空间复杂度为O(1)

#### 846. Hand of Straights
用TreeMap很容易做

#### 849. Maximize Distance to Closest Person
就注意下最开始和最后两种情况

#### 850. Rectangle Area II
有点难，没看完

#### 855. Exam Room
学到了一个新的数据结构TreeSet，好像是一个可以方便删减的list

#### 857. Minimum Cost to Hire K Workers
首先分析题意，工资/能力，越高的人越难满足。先对比例排序，把比例最低的K个人找出来，用最高的比例算总工资，然后每次把K个人能力最强的去除，加进新的比较。

#### 858. Mirror Reflection
数学题

#### 859. Buddy Strings
分情况讨论即可

#### 865. Smallest Subtree with all the Deepest Nodes
关键想清楚最小父节点的特点，就是左右都有最深点

#### 866. Prime Palindrome
硬解

#### 867. Transpose Matrix
直接做

#### 869. Reordered Power of 2
找到最简单的共同点

#### 870. Advantage Shuffle
找比每一个大的最小的数

#### 872. Leaf-Similar Trees
dfs构建list直接equals比较

#### 873. Length of Longest Fibonacci Subsequence
首先，如果想找得快，那就重新用map；另外，如果想用一个数表示二维数组，那就某一个乘总个数加第二个，

#### 874. Walking Robot Simulation
直接模拟走，但是注意需要注意如何保存所有障碍物，如何用一个数表示二维坐标

#### 876. Middle of the Linked List
快慢指针即可，注意一起从第一个开始

#### 877. Stone Game
玩游戏的题只能用终极dp或者奇妙直接解

#### 879. Profitable Schemes
Linkedin面经：这道题是一道hard dp题。需要把所有受益超过P的统一归为P，这样答案空间才有限。最外层是遍历每一个任务；因为人数并没有特殊处理，第二层遍历所有人数，因为加上了这个任务至少有g个人，并且为了先用干净的数据更新，所以从G到g；因为受益空间进行了压缩，所以受益等于P的要单独考虑，然后再已递减顺序从P-1到p把全部的更新了。最终在合并所有受益是P的数。

#### 880. Decoded String at Index
考虑从后往前和从前往后应该都可以

#### 881. Boats to Save People
排序加雙指針

#### 883. Projection Area of 3D Shapes
空间想象找规律

#### 884. Uncommon Words from Two Sentences
经典的用HashMap计数

#### 885. Spiral Matrix III
怎么样用代码分步执行是关键

#### 886. Possible Bipartition
就只要先把相關聯的塗色就很容易

#### 900. RLE Iterator
还是有很多corner case没有考虑

#### 901. Online Stock Span
最近有好几道题都是需要在做之前先想清楚里面的规律，不然就会陷入非常麻烦的思维里。这道题就是，想清楚了答案空间事实上很小。

#### 904. Fruit Into Baskets
GG OA。先分割，再一段一段找最大。

#### 911. Online Election
这种题要想好怎么预处理，最后找结果用二分即可

#### 929. Unique Email Addresses
google oa，主要要会用string的各种函数

#### 939. Minimum Area Rectangle
用一个TreeMap顺序存每一个x坐标对应的y坐标。再用一个map存y pair对应x坐标，而且每次都只需把最近的y pair更新

#### 947. Most Stones Removed with Same Row or Column
这道题本质和Union-Find一致，需要注意的是这里把行和列单独作为对象，并且不用rank数组，手动每次对列union，最后减去不重复的集合即可。

#### 1021. Remove Outermost Parentheses
不需要判断是否合格，只需要判断是不是最外面的括号即可，用stack的思维

#### 1037. Valid Boomerang
用乘法代替除法