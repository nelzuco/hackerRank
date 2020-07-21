package com.redlink;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        //LOAD DATA
        List<Integer> b = new ArrayList<Integer>();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        b.add(5);
        b.add(4);
        b.add(3);
        b.add(2);
        b.add(1);
        b.add(3);
        b.add(4);


        //System.out.println("RESULTADO: " + birthday(b,3,2));

        int[] ar = {1, 2, 3, 4, 5, 4, 3, 2, 1, 3, 4};
        //System.out.println("RESULTADO: " + divisibleSumPairs(6,3,ar));

        System.out.println(migratoryBirds(b));
    }


    // Complete the migratoryBirds function below.
    static int migratoryBirds(List<Integer> arr) {
        final int[] result = {0,0};
        //key is value of array, value is counter
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (Integer element : arr) {
            if (map.containsKey(element)) {
                map.put(element, map.get(element) + 1); // increase counter if contains
            } else
                map.put(element, 1);
        }
        map.forEach((k,v)->{if(result[0] < v){result[0] = v;result[1] = k;}
        });
        return result[1];
    }


    // Complete the divisibleSumPairs function below.
    static int divisibleSumPairs(int n, int k, int[] ar) {
        int result = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if (((ar[i]+ar[j])%k) == 0) {
                    result++;
                }
            }
        }
        return result;
    }

    // Complete the birthday function below.
    static int birthday(List<Integer> s, int d, int m) {
        int parcial,result=0;
        for (int i=0; i<s.size(); i++) {
            parcial = s.get(i);
            if (i+m <= s.size()){
                for(int j=i+1; j<i+m; j++){
                    parcial = parcial + s.get(j);
                }
                if (parcial == d) {
                    result++;
                }
            }
        }
        return result;

    }



    // Complete the breakingRecords function below.
    static int[] breakingRecords(int[] scores) {
        int minScore=scores[0],maxScore=scores[0];
        int [] resultScores= {0,0};
        for (int i=1;i<scores.length;i++){
            if(scores[i] > maxScore){
                maxScore = scores[i];
                resultScores[0]++;
            }
            if(scores[i] < minScore){
                minScore = scores[i];
                resultScores[1]++;
            }
        }
        return resultScores;
    }

    static int getTotalX(List<Integer> a, List<Integer> b) {
        /*
         * Complete the 'getTotalX' function below.
         *
         * The function is expected to return an INTEGER.
         * The function accepts following parameters:
         *  1. INTEGER_ARRAY a
         *  2. INTEGER_ARRAY b
         */
        int result = 0;
        for (int numA:a) {
            for (int numB:b) {
                if (numA%numB ==0){
                    result++;
                }
            }
        }
        return result;
    }


    // Complete the kangaroo function below.
    static String kangaroo(int x1, int v1, int x2, int v2) {
        /*kangaroo has the following parameter(s):
        x1, v1: integers, starting position and jump distance for kangaroo 1
        x2, v2: integers, starting position and jump distance for kangaroo 2*/
        while (x1 < x2){
            if((x1+=v1) == (x2+=v2)){
                return "YES";
            }
        }
        return "NO";
    }

    // Complete the countApplesAndOranges function below.
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges){
        /*s: integer, starting point of Sam's house location.
        t: integer, ending location of Sam's house location.
        a: integer, location of the Apple tree.
        b: integer, location of the Orange tree.
        apples: integer array, distances at which each apple falls from the tree.
        oranges: integer array, distances at which each orange falls from the tree.
        */
        int appleResult = 0, orangeResult = 0;
        for (int apple: apples) {
            apple += a;
            if (between(apple,s,t)){
                appleResult++;
            }
        }
        for (int orange: oranges) {
            orange += b;
            if (between(orange,s,t)){
                orangeResult++;
            }
        }
        System.out.println(appleResult);
        System.out.println(orangeResult);
    }

    public static boolean between(int i, int minValueInclusive, int maxValueInclusive) {
        return (i >= minValueInclusive && i <= maxValueInclusive);
    }


    public static boolean esMultiplo(int n1, int n2){
        if (n1%n2==0)
            return true;
        else
            return false;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        List<Integer> samRules = new ArrayList<Integer>();
        int tries;
        for (int nota:grades) {
            if (nota >= 38){
                tries = 0;
                while(!esMultiplo(nota, 5) && (tries < 3)){
                    tries++;
                    nota++;
                }
                if (tries < 3){
                   samRules.add(nota);
                }else {
                   samRules.add(nota - tries);
                }
            }else{
                samRules.add(nota);
            }
        }
        return samRules;
    }

    public static void escribe (String a, LinkedList<Character> conjunto, List<String> permutaciones) {
        if (conjunto.size()==1)
        {
            permutaciones.add(a+conjunto.get(0));
            System.out.println(a+conjunto.get(0));
        }
        for (int i=0;i<conjunto.size();i++)
        {
            Character b = conjunto.remove(i);
            escribe (a+b, conjunto, permutaciones);
            conjunto.add(i,b);
        }
    }

    public static void quadrants (List<List<Integer>> p, List<String> queries) {
        for (int i=0; i<queries.size(); i++){
            String query[] = queries.get(i).split(" ");
            switch(query[0]) {
                case "X" :
                    queryProcess(p, 1, Integer.parseInt(query[1])-1, Integer.parseInt(query[2]));
                    break;
                case "Y" :
                    queryProcess(p, 0, Integer.parseInt(query[1])-1, Integer.parseInt(query[2]));
                    break;
                default :
                    queryProcessC(p, Integer.parseInt(query[1])-1, Integer.parseInt(query[2]));
            }
        }
    }

    public static void queryProcess(List<List<Integer>> p, int pos, int ini, int end){
        for (int i=ini; i<end; i++) {
            p.get(i).set(pos, p.get(i).get(pos) * (-1));
        }
    }

    public static void queryProcessC(List<List<Integer>> p, int ini, int end) {
        int[] quadrants = {0, 0, 0, 0};
        for (int i=ini; i<end; i++) {
            quadrants[devolverCuadrante(p.get(i).get(0), p.get(i).get(1))]++;
        }
        System.out.println(quadrants[0]+" "+quadrants[1] +" "+quadrants[2]+" "+quadrants[3]);
    }

    public static int devolverCuadrante(int i, int j){
        if (i > 0) {
            if (j > 0){
                return 0;
            }else{
                return 3;
            }
        }else{
            if (j > 0){
                return 1;
            }else{
                return 2;
            }
        }
    }



    public static int[] devolverCuadranteDos(int i, int j){
        if (i == 0){
            if (j == 0){
                return new int[]{1,2,3,4};
            }
            if (j > 0){//cuadrante I y II
                return new int[]{1,2};
            }else{//cuadrante III y IV
                return new int[]{3,4};
            }
        }
        if (i > 0) {//cuadrantes I IV
            if (j > 0){//cuadrante I
                return new int[]{1};
            }else{//cuadrante IV
                return new int[]{4};
            }
        }else{//cuadrantes II III
            if (j > 0){
                return new int[]{2};
            }else{
                return new int[]{3};
            }
        }
    }

    public static void timeConversion(String input){
        DateFormat df = new SimpleDateFormat("hh:mm:ss aa");
        DateFormat outputformat = new SimpleDateFormat("HH:mm:ss");
        Date date = null;
        String output = null;
        try{
            //Converting the input String to Date
            date= df.parse(input);
            //Changing the format of date and storing it in String
            output = outputformat.format(date);
            //Displaying the date
            System.out.println(output);
        }catch(ParseException pe){
            pe.printStackTrace();
        }

    }

    public static void birthDayCake(int[] arr) {
        int longitud = arr.length,max = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<longitud; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
            if (map.containsKey(arr[i])){
                map.put(arr[i], map.get(arr[i])+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        System.out.println(map.get(max));
    }


    public static void miniMaxSum(int[] arr) {
        int longitud = arr.length;
        long sum, max = 0, min = 9999999999L;
        for (int i=0; i<longitud; i++) {
            sum = 0;
            for (int j=0; j<longitud; j++) {
                if (i != j) {
                    sum = sum + arr[j];
                }
            }
            if (sum < min){
                min = sum;
            }
            if (sum > max){
                max = sum;
            }
        }
        System.out.print(min + " " + max);
    }

    public static void diagonalDifference(int[] arr) {
        // Write your code here
        int longitud = arr.length;
        int zeros = 0, positivos = 0, negativos = 0, num = 0;
        for (int i = 0; i < longitud; i++){
            num = arr[i];
            if (num > 0){
                positivos++;
            } else if (num < 0){
                negativos++;
            }else{//num = 0
                zeros++;
            }
        }
        System.out.println(positivos/longitud);
        System.out.println(negativos/longitud);
        System.out.println(zeros/longitud);
    }
}
