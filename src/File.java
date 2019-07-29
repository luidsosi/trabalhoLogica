import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class File {

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	public static ArrayList<String> read(String path) {
		try {
			BufferedReader reader = new BufferedReader(new FileReader(path));
			
			ArrayList<String> rows = new ArrayList<String>();
			
			String row = reader.readLine();
			
			while (row != null) {
				rows.add(row);
		        row = reader.readLine();
			}
			
			reader.close();
			
			return rows;
		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
			return null;
		}
	}
	
	public static void write(String path, String message) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(path));
			
			writer.write(message);
			
			writer.close();
		} catch (Exception e) {
			System.err.printf("Erro na abertura do arquivo: %s.\n", e.getMessage());
		}
	}

}
