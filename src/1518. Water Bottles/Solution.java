/* 1518. Water Bottles */
public class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles;
        while (numBottles >= numExchange) {
            int bonus = numBottles / numExchange, empty = numBottles % numExchange;
            res += bonus;
            numBottles = bonus + empty;
        }
        return res;
    }
}