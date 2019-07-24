import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> rows = File.read("C:\\www\\TrabalhoLogica\\src\\teste.txt");
		
		ArrayList<Discipline> disciplines = new ArrayList<Discipline>();
		
		
		int i;
		for (i = 0; i < rows.size(); i++) {
			if (rows.get(i).equals("#")) {
				i++;
				break;
			}
			disciplines.add(new Discipline(Integer.parseInt(rows.get(i).split(" ")[0]), rows.get(i).split(" ")[1]));
		}
		
		for (; i < rows.size(); i++) {
			System.out.println(rows.get(i));
			disciplines.get(Integer.parseInt(rows.get(i).split(" ")[0]) - 1).
				addDisciplinesStudentsCommon(Integer.parseInt(rows.get(i).split(" ")[1]));
		}

		disciplines.forEach(discipline -> System.out.println("Id:" + discipline.getId() + ", Nome:" + discipline.getName() + ", Comum: " + discipline.printDisciplinesStudentsCommon()));
		
		String dimacs = "";
		int quantityHours = 3;
		
	}

}
