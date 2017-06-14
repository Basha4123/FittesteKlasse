import java.sql.ResultSet;
import java.util.ArrayList;

public class Klasse {
	
	private ArrayList<Schueler> schueler;
	
	public Klasse(){
		schueler = new ArrayList<Schueler>();
	}
	
	public Klasse(String[] klasse){
		
	}
	
	public void addSchueler(Schueler s){
		schueler.add(s);
	}
	
	public Schueler getSchueler(int index){
		return schueler.get(index);
	}
	
	public int getSize(){
		return schueler.size();
	}
	
	public String toString(){
		
		String result = "";
		
		for(int i = 0; i < schueler.size(); i++){
			result = result + schueler.toString() + '\n';
		}
		return result;
	}

}
