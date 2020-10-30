/*LC1518: Water Bottles
https://leetcode.com/problems/water-bottles/
Given numBottles full water bottles,
you can exchange numExchange empty
water bottles for one full water bottle.

The operation of drinking a full water
bottle turns it into an empty bottle.

Return the maximum number of water bottles you can drink.

Example 1:
Input: numBottles = 9, numExchange = 3
Output: 13
Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 9 + 3 + 1 = 13.

Example 2:
Input: numBottles = 15, numExchange = 4
Output: 19
Explanation: You can exchange 4 empty bottles to get 1 full water bottle.
Number of water bottles you can drink: 15 + 3 + 1 = 19.

Example 3:
Input: numBottles = 5, numExchange = 5
Output: 6

Example 4:
Input: numBottles = 2, numExchange = 3
Output: 2

Constraints:
1 <= numBottles <= 100
2 <= numExchange <= 100*/
class Sln1 {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans=numBottles;
        while (numBottles>=numExchange){
            int rem=numBottles%numExchange;
            numBottles/=numExchange;
            ans+=numBottles;
            numBottles+=rem;
        }
        return ans;
    }
    //T:O(lgn)
}
/*O(1):
Key observation: A full bottle of water = A empty bottle +
One (bottle) unit of water.

e.g., for test case: 9, 3:
3 empty bottles can exchange a full bottle
of water implies 3 empty bottles exchange
a empty bottle + one (bottle) unit of water,
which in turn means (3 - 1) = 2 empty bottles can exchange one (bottle) unit of water.

Further more, if you only have 2 empty bottles remaining, you can NOT exchange it for a (bottle) unit of water.

Substitue the number 3 above by numExchange, we get a important conclusion:
(numExchange - 1) empty bottles can exchange one (bottle) unit of water, unless you have only numExchange left.

we need to get the floor value of numBottles / (numExchange - 1), that is why we need to minus 1 additionally in the numerator: (numBottles - 1)/ (numExchange - 1).

See the explanation of a more general question here for the derivation details.*/
class Sln2{
    public int numWaterBottles(int numBottles, int numExchange){
        return numBottles+(numBottles-1)/(numExchange-1);
    }
    //T:O(1).
}