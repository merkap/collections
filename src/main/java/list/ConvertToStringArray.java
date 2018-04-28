package list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConvertToStringArray {

    public static void main(String[] args) {

        List<String> nameList = new ArrayList<>(Arrays.asList("Mr.Green", "Mr.Yellow", "Mr.Red"));

        String[] strArray = new String[nameList.size()];
        nameList.toArray(strArray);

        for (String aStrArray : strArray) {
            System.out.println(aStrArray);
        }
    }
}