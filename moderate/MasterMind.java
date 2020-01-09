package moderate;

import java.util.HashSet;
import java.util.Set;

class Result {
	private int hits;
	private int pseudoHits;
	
	public Result(int hits, int pseudoHits) {
		this.hits = hits;
		this.pseudoHits = pseudoHits;
	}
	
	@Override
	public String toString() {
		return "hits:"+hits+",\tpseudoHits:"+pseudoHits;
	}
}

public class MasterMind {

	public static final int MAX_COLORS = 4;
	
	public static void main(String[] args) {
		
		String solution = "RGGB";
		String guess = "YRRB";
		
		System.out.println("Solution:"+solution+", Guess:"+guess);
		Result r = findHitPseudoHit(solution, guess);
		System.out.println(r);
	}

	public static int code(char ch) {
		
		switch(ch) {
			case 'B':
				return 0;
			case 'G':
				return 1;
			case 'R':
				return 2;
			case 'Y':
				return 3;
				
			default:
				return -1;
				
		}	
	}
	
	private static Result findHitPseudoHit(String solution, String guess) {
		int counter = 0;
		int hit = 0;
		int[] freq = new int[MAX_COLORS];
		
		while(counter < solution.length() && counter < guess.length()) {			
			if(solution.charAt(counter) == guess.charAt(counter)) {
				hit++;
			} else {
				int code = code(solution.charAt(counter));
				freq[code]++;
			}
			counter++;
		}
	
		// finding pseudo hits
		int pseudo = 0;
		for(int i=0; i<guess.length(); i++) {
			int code = code(guess.charAt(i));
			if (code >= 0 && freq[code] > 0 && guess.charAt(i) != solution.charAt(i)) {
				pseudo ++;			//increment pseudo hit counter
				freq[code] --;		// decrement solution occurrence frequency once considered for pseudo hit.
			}
		}
		
		return new Result(hit, pseudo);
	}
}
