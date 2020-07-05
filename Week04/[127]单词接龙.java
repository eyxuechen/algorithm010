//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
// 
//
// 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典中的单词。 
// 
//
// 说明: 
//
// 
// 如果不存在这样的转换序列，返回 0。 
// 所有单词具有相同的长度。 
// 所有单词只由小写字母组成。 
// 字典中不存在重复的单词。 
// 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。 
// 
//
// 示例 1: 
//
// 输入:
//beginWord = "hit",
//endWord = "cog",
//wordList = ["hot","dot","dog","lot","log","cog"]
//
//输出: 5
//
//解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//     返回它的长度 5。
// 
//
// 示例 2: 
//
// 输入:
//beginWord = "hit"
//endWord = "cog"
//wordList = ["hot","dot","dog","lot","log"]
//
//输出: 0
//
//解释: endWord "cog" 不在字典中，所以无法进行转换。 
// Related Topics 广度优先搜索


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    Deque<String> queue;
    Set<String>  visited;
    Set<String> words;
    String endword;


    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(wordList==null||wordList.size()==0||!wordList.contains(endWord))
            return 0;
        words=new HashSet<>(wordList);
        endword=endWord;
        visited=new HashSet<>();
        queue=new ArrayDeque<>();
        queue.add(beginWord);
        visited.add(beginWord);
        int count=0;
        while(!queue.isEmpty()) {
            count++;
            int levelSize=queue.size();
            for(int i=0;i<levelSize;i++) {
                String word = queue.removeFirst();
                if(word.equals(endWord)) return count;
                getNextLevel(word);
            }
        }
        return 0;
    }

    private void  getNextLevel(String word) {
        char[] chars=word.toCharArray();
        List<String> list=new ArrayList<>();
        for(int i=0;i<word.length();i++){
            char old=chars[i];
            for(char c='a';c<='z';c++){
                if(c==old)continue;
                chars[i]=c;
                String next=String.valueOf(chars);
                if(words.contains(next)&&!visited.contains(next)){
                    queue.addLast(next);
                    words.remove(next);
                    visited.add(next);
                }
                chars[i]=old;
            }
        }


    }

}
//leetcode submit region end(Prohibit modification and deletion)
