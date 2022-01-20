package sword_to_offer;

import java.util.EnumMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class 第一个只出现一次的字符 {
    public char firstUniqChar(String s) {
        LinkedHashMap<Character, Boolean> hm = new LinkedHashMap<>();
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            hm.put(ch[i], !hm.containsKey(ch[i]));
        }
        for(Map.Entry<Character, Boolean> entry : hm.entrySet()) {
            if (entry.getValue()) return entry.getKey();
        }
        return ' ';
    }
}
