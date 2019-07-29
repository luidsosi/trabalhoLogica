# trabalhoLogica

1. Um congresso vai oferecer vários cursos de uma hora de duração cada. Participantes podem
se inscrever em mais de um curso. Os organizadores do congresso desejam agendar os horários do
cursos de acordo com as inscrições dos aluno. Ou seja, cursos que possuem inscrição de um mesmo
aluno não podem ser ofertados no mesmo horário.
a) Os organizadores do congresso querem saber se e possível reservar apenas três horas para
oferecer todos os cursos. Apresente um programa para criar um arquivo Dimacs que representa as
restricões de horario dos cursos. Seu programa deve receber as informações de inscrições dos cursos
a partir de um arquivo com a seguinte padronização (Fig. 1):
Figure 1: Exemplo Arquivo
em que as linhas que aparecem antes do # representam os cursos e os pares de numeros depois
do # representam cursos que possuem alunos em comum. Por exemplo, a linha com 1 2 representa
que os cursos HTML e PHP têm alunos em comum.
b) Os organizadores do congresso querem saber se e possível reservar apenas cinco horas para
oferecer todos os cursos. Modifique seu programa para lidar com a nova quantidade de horas.

Regras:
1. "todo curso deve possuir somente uma única cor", onde a cor seria um horário específico.
2. "um curso não pode possuir a mesma cor de um curso que possui alunos em comum".

Atômicas:
1. Seja cij, representando que o curso i possui cor j;
2. Seja aij, representando que o curso i compartilha aluno com o curso j;

Fórmulas:
1. cij -> !(ci1 ^ ... ^ ci(j-1) ^ ci(j+1) ^ ... ^ cin), onde n = numero de cores;
2. (cik ^ cjk) -> !aij, onde i != j;
