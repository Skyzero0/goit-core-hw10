package Task_3_CountWords;

import java.io.*;
import java.util.*;


public class WordsCounter {
    public void counter(String fileName) throws IOException {
//    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new FileReader("words.txt")); //приймаємо на вхід файл

        StringJoiner sj = new StringJoiner(" "); //читаємо кожен рядок і зєднуємо пробілом

        String s = bufferedReader.readLine();

        while (s!=null){
            if (s.length()==0){
                s= bufferedReader.readLine();
            }
            sj.add(s);
            s= bufferedReader.readLine();
        }
        bufferedReader.close();


        if (sj.length()==0){
            System.out.println("Файл пустий. Немає даних для зчитування");
            return;
        }
        addUniqueWords(mapWithWords(sj));
//        System.out.println(result);
    }

    private void addUniqueWords(Map<String, Integer> mp){    //метод для ортування і правильного виведення слів за кількістю їх повторів


        int [] yt = new int[mp.size()];                //записуємо кількість повторів кожного слова у масив
        int ii=0;
        for (Map.Entry<String,Integer>fdf: mp.entrySet()) {
            yt[ii++] = fdf.getValue();
        };

        int oo;
        for (int l = 0; l < yt.length; l++) {          //сортуємо масив
            for (int j = l+1; j < yt.length; j++) {
                if (yt[l]<yt[j]){
                    oo=yt[j];
                    yt[j]=yt[l];
                    yt[l]=oo;
                }
            }
        }

        for (int i:yt) {
            for (Map.Entry<String, Integer> fd : mp.entrySet()) {           //виводимо значення у порядку зменшення кількості їх повторень
                if (i == fd.getValue()){
                    System.out.println(fd.getKey()+" "+fd.getValue());
                    mp.remove(fd.getKey(),fd.getValue());
                    break;
                }
            }
        }
    }

    private Map<String,Integer> mapWithWords (StringJoiner sj) {
        String [] allWords = String.valueOf(sj).split(" "); // розбиваємо кожне слово в рядку пробілом і додаємо в масив
        Set<String> uniqueWords = new TreeSet<>() {};

        Collections.addAll(uniqueWords, allWords); //додаємо масив в колекцію, в якій елементи не можуть повторюватися

        Map<String,Integer> result = new HashMap<>(); // створюмо мапу, куди будуть заноситись результати

        int p = 0;
        for (String g:uniqueWords) {        //порівнюємо кожен елемент колекції з кожним елементом масиву і рахуємо кількість одинакових слів
            for (String h:allWords) {
                if (g.equals(h)){
                    p++;
                }
            }
            result.put(g,p);
            p=0;
        }
        return result;
    }


//    public void counter(String fileName) throws IOException {
//        InputStream fis = new FileInputStream(fileName);
//        Scanner scanner = new Scanner(fis);
//
//        Map<String, Integer> map = new HashMap<>();
//        while (scanner.hasNext()) {
//            String s = scanner.nextLine();
//            String[] words = s.split(" ");
//            for (String word : words) {
//                if (!word.equals("")) {
//                    if (!map.containsKey(word)) {
//                        map.put(word, 1);
//                    } else {
//                        map.put(word, map.get(word) + 1);
//                    }
//                }
//            }
//        }
//
//        Comparator<String> comparator = (o1, o2) -> {
//            if (Objects.equals(map.get(o1), map.get(o2))) return 0;
//            return map.get(o1) < map.get(o2) ? 1 : -1;
//        };
//        Map<String, Integer> sortedMap = new TreeMap<>(comparator);
//        sortedMap.putAll(map);
//        System.out.println("sortedMap = " + sortedMap);
//    }
}
