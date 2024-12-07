import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class day1 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        Scanner s = new Scanner(new File("inputs\\day1"));

        while(s.hasNextLine()){
            String line = s.nextLine();
            String[] inputs = line.split(" {3}");
            list1.add(Integer.parseInt(inputs[0]));
            list2.add(Integer.parseInt(inputs[1]));
        }

        System.out.println("The total distance is " + computeTotalDistance(list1, list2));
        System.out.println("The similarity score is " + getSimilarityScore(list1, list2));
    }

    // Compute the distance between the two lists
    public static int computeTotalDistance(ArrayList<Integer> list1, ArrayList<Integer> list2){
        Collections.sort(list1);
        Collections.sort(list2);
        int totDistance = 0;
        for(int i = 0; i < list1.size(); i++){
            totDistance += Math.abs(list1.get(i) - list2.get(i));
        }

        return totDistance;
    }

    // Compute the similarity score by a weighted sum of the occurrencies of each element of list1 in list2
    public static int getSimilarityScore(ArrayList<Integer> list1, ArrayList<Integer> list2){
        HashMap<Integer, Integer> occurrenciesMap = new HashMap<>();
        for(int el : list2) occurrenciesMap.put(el, 1 + occurrenciesMap.getOrDefault(el, 0));

        int similarityScore = 0;
        for(int el : list1) similarityScore += (el * occurrenciesMap.getOrDefault(el, 0));
        return similarityScore;
    }

}
