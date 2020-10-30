/*https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
Aerith is playing a cloud hopping game.
In this game, there are sequentially
numbered clouds that can be thunderheads
or cumulus clouds. Her character must
jump from cloud to cloud until it reaches the start again.
To play, Aerith is given an array of clouds,
and an energy level . She starts from  and uses
unit of energy to make a jump of size  to cloud .
If Aerith lands on a thundercloud, ,
her energy () decreases by  additional units.
The game ends when Aerith lands back on cloud .

Given the values of , , and the configuration
of the clouds as an array , can you determine
the final value of  after the game ends?

For example, give  and , the indices of her path are .
Her energy level reduces by  for each jump to .
She landed on one thunderhead at an additional
cost of  energy units. Her final energy level is */
package hackerrank;
public class JumpingOnTheCloudRevisited {
    public int jumpingOnClouds(int[] c, int k) {
        int energy = 100;
        if (c == null || c.length == 0) return energy;
        int start = 0;
        int end = -1;
        int n=c.length;
        while (start != end) {
            start = (start+k)%n;
            if (c[start] == 1)
                energy -= 3;
            else
                energy -= 1;
            end = 0;
        }
        return energy;
    }
}