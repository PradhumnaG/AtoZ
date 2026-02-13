package dinamicprogramming;
 class NinjaTraning  {
    public int maximumPoints(int mat[][]) {
        // Get the number of days (rows)
        int n = mat.length;

        // EDGE CASE: If there are no days, return 0
        if (n == 0) return 0;

        // 'prev' stores the max points possible ending with specific activities on the PREVIOUS day.
        // prev[0] = max points if we chose activity 0 yesterday
        // prev[1] = max points if we chose activity 1 yesterday
        // prev[2] = max points if we chose activity 2 yesterday
        int[] prev = new int[3];

        // 1. BASE CASE: Initialize with Day 0's points
        prev[0] = mat[0][0];
        prev[1] = mat[0][1];
        prev[2] = mat[0][2];

        // 2. ITERATE: Loop through Day 1 to Day N-1
        for (int day = 1; day < n; day++) {

            // 'curr' stores max points for the CURRENT day
            int[] curr = new int[3];

            // If we choose Activity 0 today, we must have chosen Activity 1 or 2 yesterday.
            // We take the max of those previous options and add today's points.
            curr[0] = mat[day][0] + Math.max(prev[1], prev[2]);

            // If we choose Activity 1 today, we must have chosen Activity 0 or 2 yesterday.
            curr[1] = mat[day][1] + Math.max(prev[0], prev[2]);

            // If we choose Activity 2 today, we must have chosen Activity 0 or 1 yesterday.
            curr[2] = mat[day][2] + Math.max(prev[0], prev[1]);

            // Update prev to curr for the next iteration
            // We manually copy values or reassign reference (reassigning is fine here as we make new curr next loop)
            prev = curr;
        }

        // 3. RESULT: Return the maximum of the three possibilities on the last day
        return Math.max(prev[0], Math.max(prev[1], prev[2]));
    }
    // code here


}
