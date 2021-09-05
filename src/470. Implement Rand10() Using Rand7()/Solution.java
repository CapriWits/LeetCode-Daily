import java.util.*;

/* 470. Implement Rand10() Using Rand7() */
public class Solution extends SolBase {
    public int rand10() {
        int first, second;
        while ((first = rand7()) > 6);
        while ((second = rand7()) > 5);
        return (first&1) == 1 ? second : 5+second;
    }
}