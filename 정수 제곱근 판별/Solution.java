class Solution {
	public long solution(long n) {
		double root = Math.sqrt(n);
        
		if (root == (long) root)
			return (long) ((long) (root + 1) * (root + 1));
		else
			return -1;
	}
}
