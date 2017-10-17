package be.pxl.lambdaexpressions.opdracht3;

import java.util.ArrayList;
import java.util.function.Predicate;

public class GameBrowser {
	private GameCollection collection;
	
	public GameBrowser(GameCollection collection){
		this.collection = collection;
	}
	
	public ArrayList<VideoGame> showGamesForSearch(String search){
		ArrayList<VideoGame> collectionFilter;
		Predicate<String> filter = new Predicate<String>(){
			@Override
			public boolean test(String t) {
				if(t.contains(search.toLowerCase())){
					return true;
				} else {
					return false;
				}		
			}			
		};
		collectionFilter = collection.selectGames(filter);		
		return collectionFilter;
	}
}
