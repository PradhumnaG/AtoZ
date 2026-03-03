package slidingwindow;

 import java.util.Arrays;

class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        // Sort the greed factors and cookie sizes
        Arrays.sort(g);
        Arrays.sort(s);

        int childIndex = 0;
        int cookieIndex = 0;

        // Traverse through both arrays
        while (childIndex < g.length && cookieIndex < s.length) {
            // If the current cookie is big enough for the current child
            if (s[cookieIndex] >= g[childIndex]) {
                // The child is content, move to the next child
                childIndex++;
            }
            // Regardless of whether the cookie was used or too small,
            // we move to the next cookie.
            cookieIndex++;
        }

        // The childIndex will represent the exact number of children we managed to make content
        return childIndex;
    }
}
