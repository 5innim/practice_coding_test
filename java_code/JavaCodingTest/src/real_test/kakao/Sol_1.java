package real_test.kakao;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Sol_1 {
    public static void main(String[] args) {
        String[] friends = new String[] {"a", "b", "c"};
        String[] gifts = new String[] {"a b", "b a", "c a", "a c", "a c", "c a"};
        Solution solution = new Solution();
        solution.solution(friends, gifts);
    }


}

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        HashMap<String, GiftRecord> hashMap = new HashMap<>();
        for (String f : friends) {
            hashMap.put(f, new GiftRecord(0, new HashMap<String, Integer>(), 0));
        }

        for (String g : gifts) {
            StringTokenizer st = new StringTokenizer(g);
            String a = st.nextToken();
            String b = st.nextToken();

            GiftRecord aGiftRecord = hashMap.get(a);
            aGiftRecord.giftScore += 1;
            if (aGiftRecord.gifts.get(b) == null) {
                aGiftRecord.gifts.put(b, 1);
            } else {
                Integer giftNum = aGiftRecord.gifts.get(b);
                aGiftRecord.gifts.put(b, 1 + giftNum);
            }

            GiftRecord bGiftRecord = hashMap.get(b);
            bGiftRecord.giftScore -= 1;
        }

        ArrayList<ArrayList<String>> arrayList = new ArrayList<>();
        Deque<String> deque = new LinkedList<>();
        combination(deque, friends, 0, friends.length, 2, arrayList);

        for (ArrayList<String> twoFriends : arrayList) {
            String a = twoFriends.get(0);
            String b = twoFriends.get(1);

            GiftRecord giftRecordA = hashMap.get(a);
            GiftRecord giftRecordB = hashMap.get(b);

            int aToB = (giftRecordA.gifts.get(b) == null) ? 0:giftRecordA.gifts.get(b);
            int bToA = (giftRecordB.gifts.get(a) == null) ? 0:giftRecordB.gifts.get(a);

            if (aToB > bToA) {
                giftRecordA.nextExpected += 1;
            } else if (aToB < bToA) {
                giftRecordB.nextExpected += 1;
            } else if (aToB == bToA) {
                if (giftRecordA.giftScore > giftRecordB.giftScore) {
                    giftRecordA.nextExpected += 1;
                } else if (giftRecordA.giftScore < giftRecordB.giftScore) {
                    giftRecordB.nextExpected += 1;
                }
            }
        }

        for (String f : friends) {
            answer = Math.max(answer, hashMap.get(f).nextExpected);
        }



        return answer;
    }

    class GiftRecord {
        int giftScore;
        HashMap<String, Integer> gifts;
        int nextExpected;
        GiftRecord(int giftScore, HashMap<String, Integer> gifts, int nextExpected) {
            this.giftScore = giftScore;
            this.gifts = gifts;
            this.nextExpected = nextExpected;
        }
    }
    void combination(Deque<String> stack, String[] array, int start, int n, int r, ArrayList<ArrayList<String>> result) {
        if (r == 0) {
            ArrayList<String> arrayList = new ArrayList<>();
            arrayList.add(stack.peekFirst());
            arrayList.add(stack.peekLast());
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


}
