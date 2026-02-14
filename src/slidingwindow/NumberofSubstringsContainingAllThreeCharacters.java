package slidingwindow;



 class NumberofSubstringsContainingAllThreeCharacters {
        public int numberOfSubstrings(String s) {
            int[] count = new int[3]; // Frequency array for a, b, c
            int left = 0;
            int result = 0;
            int n = s.length();

            for (int right = 0; right < n; right++) {
                // Add current character to wndow..
                count[s.charAt(right) - 'a']++;

                // While window is valid (has at least one of a, b, and c)
                while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                    // Remove character from the left to shrink window
                    count[s.charAt(left) - 'a']--;
                    left++;
                }

                // 'left' is now the number of valid substrings ending at 'right'
                // logic: indices 0, 1, ... left-1 are all valid starting points
                result += left;
            }

            return result;
        }
    }

