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
		Predicate<VideoGame> filter = new Predicate<VideoGame>(){
			@Override
			public boolean test(VideoGame t) {
				if(t.getName().toLowerCase().contains(search.toLowerCase())){
					return true;
				} else {
					return false;
				}	
			}			
		};
		collectionFilter = collection.selectGames(filter);		
		return collectionFilter;
	}
	
	public ArrayList<VideoGame> showFreeGames(){
		ArrayList<VideoGame> collectionFilter;
		collectionFilter = collection.selectGames(p -> p.getPrice() == 0.0);	
		return collectionFilter;
	}
	
	public ArrayList<VideoGame> showGamesInGenre(String genre){
		ArrayList<VideoGame> collectionFilter;
		collectionFilter = collection.selectGames(g-> {
			boolean trueOrFalse = false;
			for(int i = 0; i < g.getGenres().size(); i++){
				if(g.getGenres().get(i).toLowerCase().equals(genre.toLowerCase())){
					trueOrFalse = true;
				}
			}
			return trueOrFalse;
		});
		return collectionFilter;
	}
}
