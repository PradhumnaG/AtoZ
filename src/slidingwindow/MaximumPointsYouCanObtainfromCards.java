package slidingwindow;
 class MaximumPointsYouCanObtainfromCards {
    public int maxScore(int[] cardPoints, int k) {
        int lsum = 0;
        int rsum = 0;
        int maxSum = 0;
        int n = cardPoints.length;

        // Step 1: Calculate the sum of the first k elements (initial window)
        for (int i = 0; i < k; i++) {
            lsum += cardPoints[i];
        }

        // Initialize maxSum with the sum of the first k elements
        maxSum = lsum;

        // Step 2: Slide the window
        // Remove one element from the left and add one from the right
        int rightIndex = n - 1;
        for (int i = k - 1; i >= 0; i--) {
            // Remove the last element of the current left chunk
            lsum = lsum - cardPoints[i];
            // Add the last element of the array (from the right)
            rsum = rsum + cardPoints[rightIndex];
            // Move the right pointer inwards
            rightIndex = rightIndex - 1;

            // Update the maximum sum found so far
            maxSum = Math.max(maxSum, lsum + rsum);
        }

        return maxSum;
    }
}
