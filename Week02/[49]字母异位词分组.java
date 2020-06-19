//给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。 
//
// 示例: 
//
// 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// 说明： 
//
// 
// 所有输入均为小写字母。 
// 不考虑答案输出的顺序。 
// 
// Related Topics 哈希表 字符串


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        //统计每个字符串每个字符出现的次数，并拼接成串放入map，作为归组。
        Map<String,List<String>> charN=new HashMap<>();
        for(String str:strs) {
            Map<Character, Integer> counter = new TreeMap<>();
            char[] cahrs = str.toCharArray();
            for (char c : cahrs) {
                counter.put(c, counter.getOrDefault(c, 0) + 1);
            }
            String key=genKey(counter);
            List<String> list=charN.getOrDefault(key,new ArrayList<>());
            list.add(str);
            charN.put(key,list);
        }
        return map2lst(charN);
    }
    private String genKey(Map<Character,Integer> map){
        StringBuilder sb=new StringBuilder();
        for(Map.Entry entry:map.entrySet()){
            sb.append(entry.getKey())
                    .append(entry.getValue());
        }
        return  sb.toString();
    }

    private List<List<String>> map2lst(Map<String,List<String>> map){
        List<List<String>> list=new ArrayList<>();
        list.addAll(map.values());
        return list;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
