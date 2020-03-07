package Hackerblocks;

import java.util.*;

public class Hashtrick {
    static HashMap<Integer,Integer> map = new HashMap<>();
    static void hashtrick(int arr[],int n){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!map.containsKey(arr[i])){
                map.put(arr[i],i);
                list.add(arr[i]);
            }else{
                map.put(arr[i],i);
            }
        }
        int ans[] = new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
    }
    static HashMap<Integer, Integer> sortByValue(HashMap<Integer, Integer> hm) {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(hm.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>();
        for (Map.Entry<Integer, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        hashtrick(arr,n);
        HashMap<Integer, Integer> res = sortByValue(map);
        for (int val : res.keySet()) {
            System.out.println(val);
        }
    }
}
