package com.example.demo2.test;

import javax.swing.plaf.synth.SynthSpinnerUI;
import java.io.PipedOutputStream;
import java.util.*;

public class SortByCounts {

    public static void main(String[] args) {
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

//        int arr[] = {1,1,1,3,3,32,5,6,6,7,8};
//        System.out.println(Arrays.toString(arr));
//        int[] ints = sortArr(arr);
//        System.out.println(Arrays.toString(ints));
    }


    private static int[] sortArr(int[] arr) {
        int max = 0;
        Set<Object> result = new HashSet<Object>();
        Map<Object, Integer> mp = new HashMap<Object, Integer>();
        for (int i = 0; i < arr.length; i++) {
            Integer num = mp.put(arr[i], 1);
            if (num != null) {
                mp.put(arr[i], num + 1);
                if (num > max) {
                    result.clear();//移除此set中所有元素
                    result.add(arr[i]);
                    max = num;
                } else if (num == max) {
                    result.add(arr[i]);
                }
            }
        }
        Set set = mp.entrySet();
        Map.Entry[] entries = (Map.Entry[]) set.toArray(new Map.Entry[set.size()]);

        Arrays.sort(entries, new Comparator() {
            public int compare(Object arg0, Object arg1) {
                Long key1 = Long.valueOf(((Map.Entry) arg0).getValue().toString());
                Long key2 = Long.valueOf(((Map.Entry) arg1).getValue().toString());
                return key1.compareTo(key2);
            }
        });

        int[] ids = new int[entries.length];

        for (int i = entries.length - 1; i >= 0; i--) {
            Map.Entry entry = entries[i];
            ids[i] = Integer.parseInt(entry.getKey().toString());
        }
        return ids;
    }
}
