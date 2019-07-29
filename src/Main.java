import java.util.ArrayList;

public class Main {
	public static void main(String[] args) {
		ArrayList<String> rows = File.read("C:\\www\\TrabalhoLogica\\src\\teste.txt");
		
		ArrayList<Discipline> cursos = new ArrayList<Discipline>();
		
		
		int i;
		for (i = 0; i < rows.size(); i++) {
			if (rows.get(i).equals("#")) {
				i++;
				break;
			}
			cursos.add(new Discipline(Integer.parseInt(rows.get(i).split(" ")[0]), rows.get(i).split(" ")[1]));
		}
		
		int contador = 0;
		for (; i < rows.size(); i++) {
			contador++;
			cursos.get(Integer.parseInt(rows.get(i).split(" ")[0]) - 1).
				addDisciplinesStudentsCommon(Integer.parseInt(rows.get(i).split(" ")[1]));
		}
		
		String dimacs = "c arquivo referente a modelagem de horario dos cursos\n";
		
		int quantidadeHoras = 5;
		int quantidadeAtomicasHoraCurso =  quantidadeHoras * cursos.size();
		int quantidadeAtomicasAlunosComum = (cursos.size() * (cursos.size() -1)); 
		int quantidadeAtomicas = quantidadeAtomicasHoraCurso + quantidadeAtomicasAlunosComum;
		int quantidadeClausulas = (quantidadeHoras * (quantidadeHoras - 1) * cursos.size()) + (quantidadeAtomicasAlunosComum * quantidadeHoras) + contador;
		
		dimacs += "p cnf " + quantidadeAtomicas + " " + quantidadeClausulas + " \n";
		
		for (int j = 0; j < cursos.size(); j++) {
			for (int j2 = 1; j2 <= quantidadeHoras; j2++) {
				for (int k = 1; k <= quantidadeHoras; k++) {
					if (k != j2) {
						dimacs += "-" + (j*quantidadeHoras + j2) + " -" + (j*quantidadeHoras + k) + " \n";
					}
				}
			}
		}
		
		for (int j = 0; j < cursos.size(); j++) {
			for (int j2 = 0; j2 < cursos.size(); j2++) {
				for (int k = 1; k <= quantidadeHoras; k++) {
					if (j != j2) {
						dimacs += "-" + (j*quantidadeHoras + k) + " -" + (j2*quantidadeHoras + k) + " "
								+ "-" + (quantidadeAtomicasHoraCurso + (j*cursos.size() + j2)) + " \n";
					}
				}
			}
		}
		
		for (int j = 0; j < cursos.size(); j++) {
			for (int j2 = 0; j2 < cursos.get(j).getDisciplinesStudentsCommon().size(); j2++) {
				dimacs += (quantidadeAtomicasHoraCurso + ((cursos.get(j).getId()-1) * cursos.size()) +  (cursos.get(j).getDisciplinesStudentsCommon().get(j2) - 1)) + "\n";
			}
		}
		
		File.write("C:\\www\\TrabalhoLogica\\src\\dimacs.txt", dimacs);
	}

}
