// https://leetcode.com/problems/text-justification/
// 原理其实很简单，把数字算清楚，条件设好

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new LinkedList<> ();
        int head = 0, tail = 0, count = 0;
        while(tail < words.length) {
            if(head == tail) {
                count = words[head].length();
            } else if(count + words[tail].length() + 1 <= maxWidth) {
                count += words[tail].length() + 1;
            } else {
                tail--;
                result.add(helper(words, maxWidth, head, tail, count));
                head = tail + 1;
                count = 0;
            }
            tail++;
        }
        StringBuilder lastLine = new StringBuilder ();
        for(int i = head; i < words.length; i++) {
            lastLine.append(words[i]);
            if(i != words.length - 1) {
                lastLine.append(" ");
            }
        }
        if(lastLine.length() != 0) {
            while(lastLine.length() < maxWidth) {
                lastLine.append(" ");
            }
            result.add(lastLine.toString());
        }
        
        return result;
    }
    
    private String helper(String[] words, int maxWidth, int head, int tail, int count) {
        StringBuilder sb = new StringBuilder();
        if(tail > head) {
            int smallSpace = (maxWidth - count) / (tail - head), largeSpaceCount = (maxWidth - count) - smallSpace * (tail - head);
            for(int i = head; i <= tail; i++) {
                sb.append(words[i]);
                if(i != tail) {
                    if(largeSpaceCount-- > 0) {
                        appendSpace(sb, smallSpace + 2);
                    } else {
                        appendSpace(sb, smallSpace + 1);
                    }
                }
            }
        } else {
            sb.append(words[head]);
            while(sb.length() < maxWidth) {
                sb.append(" ");
            }
        }
        
        return sb.toString();
    }
    
    private void appendSpace(StringBuilder sb, int spaceNum) {
        for(int i = 0; i < spaceNum; i++) {
            sb.append(" ");
        }
    }
}