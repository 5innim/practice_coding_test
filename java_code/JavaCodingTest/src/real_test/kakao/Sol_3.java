package real_test.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Sol_3 {

    public static void main(String[] args) {

        //[[1, 2, 3, 4, 5, 6], [3, 3, 3, 3, 4, 4], [1, 3, 3, 4, 4, 4], [1, 1, 4, 4, 5, 5]]
        int[][] dice = {
            {1, 2, 3, 4, 5, 6},
            {3, 3, 3, 3, 4, 4},
            {1, 3, 3, 4, 4, 4},
            {1, 1, 4, 4, 5, 5}
        };

        // [[1, 2, 3, 4, 5, 6], [2, 2, 4, 4, 6, 6]]
//        int [][] dice = {
//            {1, 2, 3, 4, 5, 6},
//            {2, 2, 4, 4, 6, 6}
//        };

        Solution3 solution2 = new Solution3();
        solution2.solution(dice);
    }

}

class Solution3 {
    public int[] solution(int[][] dice) {
        ArrayList<Integer> answer = new ArrayList<>();
        int maxValue = 0;
        int n = dice.length;

        Deque<Integer> stack = new LinkedList<>();
        Integer[] array = new Integer[n];

        for (int i=0; i<n; i++) {
            array[i] = i;
        }

        ArrayList<ArrayList<Integer>> arrayList = new ArrayList<>();
        combination(stack, array, 0, n, n/2, arrayList);

        for (int i=0; i<(arrayList.size())/2; i++) {
            ArrayList<Integer> aList = new ArrayList<>();
            aList.addAll(arrayList.get(i));

            ArrayList<Integer> bList = new ArrayList<>();
            for (int j=0; j<n; j++) {
                bList.add(j);
            }

            bList.removeAll(arrayList.get(i));

             ArrayList<Integer> aResult = new ArrayList<>();
             combinationDice(stack, dice, aList, 0, aResult);

             ArrayList<Integer> bResult = new ArrayList<>();
             combinationDice(stack, dice, bList, 0, bResult);
//            ArrayList<Integer> aResult = new ArrayList<>();
//            combinationDice(stack, dice, aList, 0, aResult);
//            aResult.sort((o1, o2) -> o2 - o1);
//
//            ArrayList<Integer> bResult = new ArrayList<>();
//            combinationDice(stack, dice, bList, 0, bResult);
//            bResult.sort((o1, o2) -> o2 - o1);

            int aWin = 0;
            int bWin = 0;

             for (int aScore : aResult) {
                 for (int bScore : bResult) {
                     if (aScore > bScore) {
                         aWin += 1;
                     } else if (aScore < bScore) {
                         bWin += 1;
                     }
                 }
             }
//            for (int a=0; a<aResult.size(); a++) {
//                for (int b=0; b<bResult.size(); b++) {
//                    if (aResult.get(a) > bResult.get(b)) {
//                        aWin += (bResult.size() - b);
//                        break;
//                    } else if (aResult.get(a) < bResult.get(b)) {
//                        bWin += 1;
//                    }
//                }
//            }


            for (int aScore : aResult) {
                for (int bScore : bResult) {
                    if (bScore > aScore) {
                        aWin += 1;
                    } else if (bScore < aScore) {
                        bWin += 1;
                    }
                }
            }

            if (aWin > bWin) {
                if (maxValue < aWin) {
                    maxValue = aWin;
                    aList.sort((o1, o2) -> o1 - o2);
                    answer = aList;
                }
            } else if (aWin <bWin) {
                if (maxValue < bWin) {
                    maxValue = bWin;
                    bList.sort((o1, o2) -> o1 - o2);
                    answer = bList;
                }
            }

        }

        int[] arrayAnswer = new int[answer.size()];
        for (int i=0; i<answer.size(); i++) arrayAnswer[i] = answer.get(i) + 1;

        return arrayAnswer;
    }

    void combination(
        Deque<Integer> stack, Integer[] array, int start, int n, int r, ArrayList<ArrayList<Integer>> result) {
        if (r == 0) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            arrayList.addAll(stack);
            result.add(arrayList);
            return;
        }
        if (n - start < r) return;
        for (int i=start; i<n; i++) {
            stack.offerLast(array[i]);
            combination(stack, array, i + 1, n, r - 1, result);
            stack.pollLast();
        }
    }

    void combinationDice(
        Deque<Integer> stack, int dice[][], ArrayList<Integer> diceList, int s, ArrayList<Integer> result) {
        if (s >= diceList.size()) {
            int sum = 0;
            for (int value : stack) {
                sum += value;
            }
            result.add(sum);
            return;
        }


        for (int c : dice[diceList.get(s)]) {
            stack.offerLast(c);
            combinationDice(stack, dice, diceList, s + 1, result);
            stack.pollLast();
        }

    }

//    void sortDice(int[][] dice) {
//        ArrayList<List<Integer>> diceList = new ArrayList<>();
//
//        for (int i=0; i<dice.length; i++) {
//            Integer[] d = Arrays.stream(dice[i]).boxed().toArray(Integer[]::new);
//            List<Integer> dList = Arrays.asList(d);
//            dList.sort((o1, o2) -> o2 - o1);
//            diceList.add(dList);
//        }
//
//        for (int i=0; i<dice.length; i++) {
//            dice[i] =
//        }
//
//    }

}
