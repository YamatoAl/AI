import java.util.*;

public class AIPlayer extends Player{
	public void play(){
		ArrayList<Move> moves;
		moves = getAvailableMoves();
		
		int next=testNext(moves);
		System.out.println(moves.get(next));
		mark(moves.get(next));
	}
	
	public int testNext(ArrayList<Move> moves){
		ArrayList<Integer> scores = new ArrayList();
		
		for(int i=0;i<moves.size();i++){
			scores.add(new Integer(score(moves.get(i))));
		}
		
		int maxMove=0;
		Integer maxScore=scores.get(0);
		for(int i=1;i<moves.size();i++){
			if(maxScore<scores.get(i)){
				maxMove=i;
				maxScore=scores.get(i);
			}
		}
		return maxMove;
	}
	
	public int score(Move m){
		ArrayList<Move> moves;
		Board b=getNextState(getCurrentState(),m);

		if(isGameOver(b))return 10000;
		
		int theScore=0;
		moves=getAvailableMoves(b);
		for(int i=0;i<moves.size();i++){
			theScore+=testEnemy(getNextState(b,m));
		}
		return theScore;
	}
	
	public int testEnemy(Board b){
		ArrayList<Move> moves;
		moves=getAvailableMoves(b);
		
		int theScore=0;
		for(int i=0;i<moves.size();i++){
			Board bNext=getNextState(b,moves.get(i));
			if(isGameOver(bNext)) theScore-=1;
			else{
				theScore+=testMe(bNext);
			}
		}
		return theScore;
	}
	
	public int testMe(Board b){
		ArrayList<Move> moves;
		moves=getAvailableMoves(b);
		
		int theScore=0;
		for(int i=0;i<moves.size();i++){
			Board bNext=getNextState(b,moves.get(i));
			if(isGameOver(bNext)) theScore+=1;
			else{
				theScore+=testEnemy(bNext);
			}
		}
		return theScore;
	}
}