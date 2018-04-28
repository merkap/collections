package list;

import java.util.ArrayList;
import java.util.List;

public class ConvertToObjectArray {

    public static GreekLetter[] toArray(List<GreekLetter> letterList) {
        GreekLetter[] objArray = new GreekLetter[letterList.size()];
        letterList.toArray(objArray);
        return objArray;
    }

    public static void main(String... args) {

        List<GreekLetter> letterList = new ArrayList<>();
        letterList.add(new GreekLetter("Gamma", 3));
        letterList.add(new GreekLetter("Omega", 24));
        letterList.add(new GreekLetter("Alpha", 1));

        GreekLetter[] objArray = toArray(letterList);

        for (GreekLetter anObjArray : objArray) {
            System.out.println(anObjArray);
        }
    }

    static class GreekLetter {

        private String letter;
        private Integer position;

        GreekLetter(String letter, Integer position) {
            this.letter = letter;
            this.position = position;
        }

        @Override
        public String toString() {
            return "{" +
                    "letter='" + letter + '\'' +
                    ", position=" + position +
                    '}';
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;

            if (obj == null || getClass() != obj.getClass()) return false;

            GreekLetter greekLetter = (GreekLetter) obj;

            if (letter != null ? !letter.equals(greekLetter.letter) : greekLetter.letter != null)
                return false;

            return position != null ? position.equals(greekLetter.position) : greekLetter.position == null;
        }
    }
}