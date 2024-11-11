# LPOOT1
Trabalho da disciplina de linguagem de programacao orientada a objeto

Descri¸c˜ao do Trabalho Pr´atico
Universidade Federal de Mato Grosso do Sul
Faculdade de Computa¸c˜ao
Disciplina: Linguagem de Programa¸c˜ao Orientada a Objetos
29 de outubro de 2024
1 Introdu¸c˜ao
Neste documento est˜ao detalhados os procedimentos que devem ser seguidos
para o desenvolvimento do Trabalho1 Pr´atico e constituir´a como parte da nota
final da disciplina de LPOO. E fortemente recomendado que os estudantes aces- ´
sem com frequˆencia este documento para esclarecer poss´ıveis d´uvidas, estar
ciente do cronograma e estar a par de poss´ıveis atualiza¸c˜oes/altera¸c˜oes no trabalho.
2 Objetivo
O objetivo deste trabalho ´e implementar usando a linguagem de programa¸c˜ao
Java um sistema de combates de um jogo de RPG (Role Playing Game). Para
isso, deve ser implementada a possibilidade de escolha entre trˆes personagens
principais, cada um possuindo armas e habilidades ´unicas.
3 Personagens
Inicialmente, estar˜ao presentes para escolha trˆes tipos de personagens: Mago
Paladino e Cl´erigo. Todos possuem trˆes status: sa´ude, for¸ca e destreza com
pontos variando de 0.0 a 10.0. Quando os pontos de sa´ude de um personagem se
tornam menor que 1.0, ele ´e declarado morto. Al´em disso, tamb´em s˜ao capazes
de desferir ataques e se defender quando atacados.
3.1 Armas
Cada personagem ´e capaz de carregar uma arma compat´ıvel com seu perfil, isto
´e: um Mago n˜ao pode carregar uma arma de um Paladino ou Cl´erigo (e viceversa). Al´em disso, cada arma possui um modificador de for¸ca de ataque
1Adaptado de [Mark, A. R.]
1
cujo valor varia de 0.0 a 1.0, ou seja: de 0 a 100%. A seguir, listamos as armas
dispon´ıveis para cada classe com os respectivos c´odigos de cada uma:
• Mago:
– Magia da transmuta¸c˜ao: reduz o c´alcio dos ossos do oponente,
deixando-os mais porosos. Modificador: 0.25.
– Psi-kappa: com o poder de telecinese, arremessa o oponente `a
distˆancia. Modificador: 0.5.
• Paladino:
– Espada: possui uma lˆamina afiada mas ´e fr´agil. Modificador: 0.3.
– Lan¸ca: ataques em longa distˆancia. Modificador: 0.5.
• Cl´erigo:
– Martelo: apesar de pesado, ´e uma arma letal. Modificador: 0.6.
– Ma¸ca: por ser mais leve, ´e mais f´acil de manusear. Modificador: 0.4.
O diagrama UML que descreve a rela¸c˜ao das classes projetadas para este
sistema de RPG pode ser visualizado na Figura 1. As classes que possuem nomes
em it´alico s˜ao classes abstratas, isto ´e, classes que n˜ao podem ser instanciadas e
servem apenas como classes-base (ou superclasses) que devem ser herdadas por
outras classes concretas, representadas pelo nome em negrito.
2
3.2 Batalha
Ao ser criado, o personagem deve receber o nome de seu tipo (“Mago”, “Paladino” ou “Cl´erigo”), o valor de seus status iniciais (sa´ude, for¸ca e destreza) e
carregar uma arma compat´ıvel para usar (Arma de Mago, de Paladino ou de
Cl´erigo). Essas invariantes devem ser definidas e validadas no construtor das
classes concretas dos personagens.
De forma a simplificar a l´ogica da batalha, temos:
• Quando um personagem A ataca um personagem B:
– Verifique se o personagem A est´a vivo:
∗ Se o personagem A estiver vivo, deve ser impressa a mensagem “O < personagemA > ataca o < personagemB > com
< arma >.”, por exemplo: “O Mago ataca o Paladino com
Psi-kappa.”
∗ Se o personagem A estiver morto, deve ser impressa a mensagem “O < personagemA > n˜ao consegue atacar, pois est´a
morto.”
3
– O ataque ´e bem-sucedido (n˜ao ´e defendido por B) quando A
possui destreza maior que a respectiva destreza de B:
∗ Se B estiver vivo:
· Ent˜ao a sa´ude do personagem B deve ser subtra´ıda pela
quantidade de pontos de for¸ca do personagem A × modificador de ataque da arma de A.
· Deve ser impressa a mensagem: “O ataque foi efetivo com
X pontos de dano!”
∗ Se B estiver morto, deve ser impressa a mensagem: “Pare!
O < personagemB > j´a est´a morto!”
– O ataque ´e mal sucedido (´e defendido e revidado por B) quando
A possui destreza menor que a respectiva destreza de B:
∗ Se B estiver vivo:
· Ent˜ao a sa´ude do personagem A deve ser subtra´ıda pela
quantidade de pontos de for¸ca do personagem B × modificador de ataque da arma de B.
· Deve ser impressa a mensagem: “O ataque foi inefetivo e
revidado com X pontos de dano!”
∗ Se B estiver morto, deve ser impressa a mensagem: “Pare! O
< personagemB > j´a est´a morto!”
– O ataque ´e defendido (´e anulado por B) quando A possui destreza
igual `a respectiva destreza de B:
∗ Se B estiver vivo:
· Ent˜ao nem A nem B sofrem danos nas suas respectivas sa´udes.
· Deve ser impressa a mensagem: “O ataque foi defendido,
ningu´em se machucou!”
∗ Se B estiver morto, deve ser impressa a mensagem: “Pare! O
< personagemB > j´a est´a morto!”
• Ap´os um personagem A atacar um personagem B:
– Deve ser impresso na tela o status dos personagens A e B, por exemplo:
Mago [Sa´ude: 10.0, For¸ca: 6.0, Destreza: 4.0, Magia da
Transmuta¸c˜ao]
Paladino [Sa´ude: 10.0, For¸ca: 5.0, Destreza: 6.0, Espada]
– Caso um personagem tenha morrido, o status deve ser impresso como:
Mago [Sa´ude: 10.0, For¸ca: 6.0, Destreza: 4.0, Magia da
Transmuta¸c˜ao]
Paladino [Morreu, For¸ca: 5.0, Destreza: 6.0, Espada]
4
4 Entrada
O programa deve receber como entrada as informa¸c˜oes necess´arias para criar
dois personagens com seus pontos de sa´ude, for¸ca, destreza e arma carregada.
Os c´odigos de cada personagem e respectiva arma foram listados na Se¸c˜ao 3.1.
Logo ap´os, s˜ao especificados os ´ındices dos personagens que ser˜ao o atacante e
o defensor.
Por exemplo, para criar dois personagens:
• Cl´erigo com 10 pontos de sa´ude, 6 de for¸ca, 4 de destreza com Martelo;
• Mago com 10 pontos de sa´ude, 5 de for¸ca, 6 de destreza com Magia da
Transmuta¸c˜ao;
Ter´ıamos como entrada:
3 10 6 4 1
1 10 5 6 1
E seria impresso:
Cl´erigo [Sa´ude: 10.0, For¸ca: 6.0, Destreza: 4.0, Martelo]
Mago [Sa´ude: 10.0, For¸ca: 5.0, Destreza: 6.0, Magia da Transmuta¸c~ao]
A seguir, o programa esperaria como entrada a sequˆencia de ataques. A
sequˆencia de ataques deve ser informada com dois n´umeros: o primeiro n´umero
do personagem atacante e o segundo n´umero do personagem defensor. Por
exemplo, para informar o ataque do Cl´erigo contra o Mago, a entrada seria:
1 2
Para informar o fim da batalha, a entrada deve ser informada com o n´umero
zero:
0
5 Atribui¸c˜ao de grupos
O trabalho dever´a ser feito individualmente.
6 Cronograma
• In´ıcio dos trabalhos: 14/10/2024;
• Entrega: 17/11/2024 - Submeter via AVA o c´odigo junto de um relat´orio
que contenha:
– Explica¸c˜ao da organiza¸c˜ao do c´odigo:
∗ Clareza de coment´arios;
– Dificuldades encontradas;
– Solu¸c˜oes de implementa¸c˜ao.
5
7 Avalia¸c˜ao do trabalho
• Nota da Vers˜ao Final: valor no intervalo [0,10] que ser´a atribu´ıdo de acordo
com o cumprimento das atividades solicitadas para a vers˜ao da entrega
final. Tamb´em ser˜ao considerados: organiza¸c˜ao, coment´arios no c´odigo e
relat´orio.
Aten¸c˜ao: casos de pl´agio ser˜ao tratados com extremo rigor.
8 Dicas e Sugest˜oes
• Inicie o trabalho o quanto antes. O tempo voa!
• Retire as d´uvidas quanto ao entendimento dos elementos que comp˜oem o
trabalho. Isso possibilitar´a detectar poss´ıveis falhas a tempo de corrigi-las.
• Verifique com frequˆencia a documenta¸c˜ao de ajuda do Java, muitas informa¸c˜oes ´uteis podem ser encontradas l´a.
6
