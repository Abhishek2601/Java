package ex.abhi.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by abhishekshukla on 1/22/17.
 */
public class JourneyToTheMoon {
    private final List<Set<Integer>> countrySet ;

    public JourneyToTheMoon(List<Set<Integer>> countrySet) {
        this.countrySet = countrySet;
    }

    public void add(int v1 , int v2){
        boolean foundFirst = false;
        boolean foundSecond = false;
        int firstIndex = -1;
        int secondIndex = -1;

        for(int i=0;i<countrySet.size();i++){
            Set<Integer> group = countrySet.get(i);    //contains o(
            if(group.contains(v1) || group.contains(v2)){
                if(!foundFirst){
                    firstIndex = i;
                    foundFirst = true;
                }else{
                    secondIndex = i;
                    foundSecond = true;
                }
                group.add(v1);
                group.add(v2);

            }
        }
        if(!foundFirst) {
            Set<Integer> newCountry = new HashSet<>();
            newCountry.add(v1);
            newCountry.add(v2);
            countrySet.add(newCountry);
        }
        if(foundSecond){
            Set<Integer> group1 = countrySet.get(firstIndex);
            Set<Integer> group2 = countrySet.get(secondIndex);
            countrySet.remove(secondIndex);
            group1.addAll(group2);
        }

    }

    public int numOfCountries(){
        return countrySet.size();
    }

    @Override
    public String toString(){
        return countrySet.toString();
    }

    public int totalWays(){
        int sum =0;
        for(int i =0; i<countrySet.size();i++){
            for(int j=i+1;j<countrySet.size();j++){
                sum += (countrySet.get(i).size()) * (countrySet.get(j).size());
            }
        }
        return sum;
    }

    public static void main(String [] args){
        JourneyToTheMoon g = new JourneyToTheMoon(new ArrayList<>());
        g.add(1,2);
        g.add(3,4);
        g.add(5,6);
        g.add(7,6);
        g.add(2,3);
        System.out.println(g.numOfCountries());
        System.out.print(g.totalWays());
    }
}
