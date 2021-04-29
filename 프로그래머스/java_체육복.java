class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] has = new int[n];
        int i;
        
        for (i = 0; i < has.length; i++)
            has[i] = 1;

        for (i = 0; i < lost.length; i++) {
            has[lost[i]-1] -= 1;
        }
            
        for (i = 0; i < reserve.length; i++) {
            has[reserve[i]-1] += 1;
        }
        
        for (i = 0; i < has.length; i++) {
            if (has[i] == 0 && i != 0 && i != has.length-1) {
                if (has[i-1] > 1) {
                    has[i]++;
                    has[i-1]--;
                } else if (has[i+1] > 1) {
                    has[i]++;
                    has[i+1]--;
                }
            } else if (has[i] == 0 && i == 0) {
                if (has[i+1] > 1) {
                    has[i]++;
                    has[i+1]--;
                }
            } else if (has[i] == 0 && i == has.length-1) {
                if (has[i-1] > 1) {
                    has[i]++;
                    has[i-1]--;
                }
            }
        }
        
        for (i = 0; i < has.length; i++) {
            if (has[i] > 0)
                answer++;
        }
        
        return answer;
    }
}
