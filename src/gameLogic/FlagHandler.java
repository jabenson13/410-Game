package gameLogic;
import java.util.ArrayList;

public class FlagHandler {
	
	public static ArrayList<Boolean> isSubset (Player p1, Player p2, ArrayList<Boolean> flags) {
		Player Player1 = p1; // not necessarily Player1, it's a name for any player that is input first in the arguments
		Player Player2 = p2; // same as Player1
		int index = -1;
		
		if(Player1.drawnNumbers.containsAll(Player2.drawnNumbers)){
			// update flag that P1 has P2
			index = (Player1.playerID - 1) * 4;
			index = index + (Player2.playerID - 1);
			flags.set(index, true);
			//System.out.println("A flag has been updated");
		}
		if (Player2.drawnNumbers.containsAll(Player1.drawnNumbers)) {
			// update flag that P2 has P1
			index = (Player2.playerID - 1) * 4;
			index = index + (Player1.playerID - 1);
			flags.set(index, true);
			//System.out.println("A flag has been updated");
		}
		else {
			// nothing happens
		}
		return flags;
	}
	
	public static ArrayList<Boolean> flagReset (){ // resets the flags to their default values
		ArrayList<Boolean> flags = new ArrayList<Boolean>();
		for(int i=0; i<16; i++) {
			if(i % 5 == 0) {
				flags.add(true);
			}
			else {
				flags.add(false);
			}
		}
		
		return flags;
	}
//	public static boolean isRoundDone (ArrayList<Boolean> flags){
//		ArrayList<Boolean> subset;
//		ArrayList<Boolean> compare = new ArrayList<Boolean>();
//		
//		for(int i=0; i<4; i++) {
//			compare.add(true);
//		}
//		for(int index = 0; index<16; index+=4) {
//			for(int i=index; i<4; i++) {
//				subset = new ArrayList<Boolean>();
//				subset.add(flags.get(index + i));
//				if (subset.equals(compare)){
//					System.out.println("is done");
//					return true;
//				}
//			}
//		}
//		
//		return false;
//	}
	
	public static boolean isRoundDone (ArrayList<Boolean> flags) {
		boolean isDone = false;
		int count = 0;
		for(int p = 0; p < 4; p++) {
			count = 0;
			for(int i = p*4; i < (p*4)+4; p++) {
				
				if(flags.get(p) == false) {
					break;
				}else {
					count++;
				}
				if (count == 4) {
					isDone = true;
				}
			}
			if(isDone == true) {
				break;
			}
			
			
			
		}
		
		return isDone;
		
	}
	public static void flagsToString(ArrayList<Boolean> flags) {
		String output = "";
		for(int i=0; i<flags.size(); i++) {
			if(flags.get(i) == true) {
				output += i;
				output += ": true - ";
			}
			else if(flags.get(i) == false) {
				output += i;
				output += ": false - ";
			}
		}
		System.out.println(output);
	}
	
	
	
	
	
}