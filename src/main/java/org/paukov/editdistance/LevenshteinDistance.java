package org.paukov.editdistance;

/**
 * Created by dpaukov on 3/22/18.
 */
public class LevenshteinDistance {

    /**
     * Levenshtein distance is a measure of the similarity between two strings,
     * which we will refer to as the source string <code>source</code> and the
     * target string <code>target</code>. The distance is the number of
     * deletions, insertions, or substitutions required to transform s into t.
     *
     * @param source the source string
     * @param target the target string
     * @return Levenshtein distance
     */
    public static int calculate(String source, String target) {

        int d[][]; // matrix
        int n; // length of source
        int m; // length of target
        int i; // iterates through source
        int j; // iterates through target
        char s_i; // ith character of source
        char t_j; // jth character of target
        int cost; // cost

        // Step 1
        n = source.length();
        m = target.length();

        if (n == 0)
            return m;

        if (m == 0)
            return n;

        d = new int[n + 1][m + 1];

        // Step 2
        for (i = 0; i <= n; i++)
            d[i][0] = i;

        for (j = 0; j <= m; j++)
            d[0][j] = j;

        // Step 3
        for (i = 1; i <= n; i++) {
            s_i = source.charAt(i - 1);

            // Step 4
            for (j = 1; j <= m; j++) {
                t_j = target.charAt(j - 1);

                // Step 5
                if (s_i == t_j)
                    cost = 0;
                else
                    cost = 1;

                // Step 6
                d[i][j] = minimum(d[i - 1][j] + 1, d[i][j - 1] + 1,
                        d[i - 1][j - 1] + cost);
            }
        }

        // Step 7
        return d[n][m];
    }

    /**
     * Get minimum of three values
     */
    public static int minimum(int a, int b, int c) {
        int mi = a;
        if (b < mi)
            mi = b;

        if (c < mi)
            mi = c;

        return mi;
    }
}
