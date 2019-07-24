import java.util.ArrayList;

public class Discipline {
	private int id;
	private String name;
	private ArrayList<Integer> disciplinesStudentsCommon;
	
	public Discipline() {
		this.disciplinesStudentsCommon = new ArrayList<Integer>();
	}
	
	public Discipline(int id, String name) {
		this.id = id;
		this.name = name;
		this.disciplinesStudentsCommon = new ArrayList<Integer>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Integer> getDisciplinesStudentsCommon() {
		return disciplinesStudentsCommon;
	}

	public void setDisciplinesStudentsCommon(ArrayList<Integer> alunosComum) {
		this.disciplinesStudentsCommon = alunosComum;
	}
	
	public void addDisciplinesStudentsCommon(int id) {
		this.disciplinesStudentsCommon.add(id);
	}
	
	public String printDisciplinesStudentsCommon() {
		String print = "";
		
		for (Integer dsc : disciplinesStudentsCommon) {
			print += + dsc + "; ";	
		}
				
		return print;
	}
}
