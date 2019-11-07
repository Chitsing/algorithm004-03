import java.util.*;

class group_anagrams{
    public static List<List<String>> group_anagrams_order(String[] strs){
        //排除特殊情况，如果给定的集合为空，则返回空集。
        if(strs.length == 0) return new ArrayList();
        //定义hm为hashmap；
        HashMap<String,List<String>> hm = new HashMap<>();
        //遍历给定的数组
        for (int i =0; i < strs.length; i++){
            //定义一个字符串，用来处理排序和存储
            char[] temp_arr = strs[i].toCharArray();
            Arrays.sort(temp_arr);//排序
            //获取temp_arrdd的value值(即字母本身)，及对应的元素值，存入哈希表对应位置。
            String key = String.valueOf(temp_arr);
            //如果hm遍历的新词与老的value值相同，则放在这个哈希表里的同样位置。
            if(hm.containsKey(key))  hm.get(key).add(strs[i]);
            else{
                //如果新词的value值和哈希表里面的不一样，就新建一个字符串组，并把新词放进这个数组
                List<String> temp = new ArrayList<String>();
                temp.add(strs[i]);
                hm.put(key,temp);
            }
        }
        //把hm的value都输出，但不输出keys
        return new ArrayList<List<String>>(hm.values());
    }

    public static void main(String[] args){
        String[] strs2 ={"ab","ba","cd","dc"};
        //String[] strs2 ={"a","a","a"};
        List<List<String>>  res = group_anagrams_order(strs2);
        System.out.println(res);
    }
}