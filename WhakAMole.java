package whakamole;

import java.util.*;
public class WhakAMole{
	int score, molesLeft, attempts, dimension;

	Character[][] moleGrid;

	private Boolean[][] mole;
	private Boolean[][] whaked;
	Random myRandom = new Random();
	
	public boolean isWhaked(int x,int y){
		return whaked[x][y];
	}
	public boolean isMole(int x,int y){
		return mole[x][y];
	}

	public WhakAMole(int numAttempts, int gridDimension){
		dimension = gridDimension;

		
		moleGrid = new Character[gridDimension][gridDimension];
		mole = new Boolean[gridDimension][gridDimension];
		whaked = new Boolean[gridDimension][gridDimension];
		for(int i = 0; i < gridDimension; i++){
			for(int j = 0; j < gridDimension; j++){
				boolean myVal = myRandom.nextBoolean();
				mole[i][j]=myVal;
			}
		}
		
	}
	public boolean place(int x, int y){
		//make sure that we are placing within the legal confines of the grid
		return x >= 0 && y >=0 && x < dimension && y < dimension;
	}
	public void whak(int x, int y){
		if(isMole(x,y)){ 
			this.score++;
			this.molesLeft--;

		}else{
			this.attempts++;
		}

	}
	public void printGridToUser(){
		for(int i = 0; i < dimension; i++){
			for(int j = 0; j < dimension; j++){
				if(isWhaked(i,j)){
					System.out.print('w');

				}else{
					System.out.print('*');
				}

			}
			System.out.println("");
		}

	}
	public void printGrid(){
		for(int i = 0; i < dimension; i++){
			for(int j = 0; j < dimension; j++){
				if(isWhaked(i,j)){
					System.out.print('w');

				}else if(mole[i][j]){
					System.out.print('M');
				}else{
					System.out.print('*');
				}

			}
			System.out.println("");
		}

	}
	public static void main(String[] args){
		WhakAMole game = new WhakAMole(10, 10);
		game.printGridToUser();


	}

}