  _____ ___ __  __   _     _ 
 |_   _| __|  \/  | /_\   / |
   | | | _|| |\/| |/ _ \  | |
   |_| |___|_|  |_/_/ \_\ |_|
                             
Nume:    Maftei Stefan - Radu
Grupa:   324CD
Materie: POO

	Cele doua caractere, Romeo si Julieta, au fost reprezentate de clasa Character.
Fiecare are un nume, un cod pentru codificarea din matricea orasului si pozitia in
matrice. Orasul este reprezentat de clasa CityMap, avand matricea propriu-zisa si
dimensiunile ei.
	In clasa Game are loc determinarea pozitiei de intalnire cu cel mai mic cost,
impreuna cu efortul depus de fiecare personaj. In aceasta clasa avem cele doua
caractere, matricea orasului de tipul CityMap, 2 matrici de reprezentare a lungimii
caii pe care o poate urma fiecare personaj si numele fisierului de unde vom citi
matricea orasului (cu extensia ".in").
	Pentru pozitia fiecarui caracter am implementat clasa Point, in care sunt
coordonatele x si y, dar si distanta unui punct pana la pozitia unui caracter de la
care s-a pornit calcularea lungimii. Distanta incepe de la zero, adica punctul de
start are distanta zero fata de el, iar in matrice punctul de start e reprezentat de
numarul 1 (zero este pentru obstacole). Astfel, mereu cand vom updata distanta si
numarul din matrice vor fi: distanta_noua_nevizitata = distanta_vecina_vizitata + 1,
iar nr_matrice = distanta_vecina_vizitata + 2.
	Vom privi problema din perspectiva lui Romeo, apoi din perspectiva Julietei.
Amandoi vor merge pana la celalalt, considerand ca celalalt sta pe loc. Astfel vom
folosi algoritmul lui Lee si un BFS ca sa verificam si updata punctele prin care
va trece fiecare caracter. Ca sa verificam fiecare punct din matrice prin care se
poate trece vom folosi o coada de Point(s), in care vom stoca vecinii fiecarei pozitii.
Daca pozitia este nevizitata se procedeaza cum s-a descris mai sus la updatarea distantei
si numarului din matrice corespunzator pozitiei.
	Avand doua matrici astfel construite, vom sti care este drumul cel mai scurt pe
care il pot urma. Distanta aflata pentru ambele caractere este identica (evident) si,
stiind ca ambele caractere incep cu distanta 1 si se misca in acelasi timp, inseamna
ca distanta la care se vor intalni este ((distanta_aflata + 1) / 2 + 1). Astfel, ca sa
determinam punctul la care se intalnesc cele doua caractere este de ajuns sa verificam
in ambele matrici daca punctele cu aceeasi distanta ca cea determinata sunt de fapt si
aceeasi pozitie. Daca da, afisam distanta si pozitia, iar daca nu exista un astfel de
punct inseamna ca cele doua caractere nu se intalnesc urmand drumul cel mai scurt.
(nu se pot intalni pana apune soarele)
	In cazul in care vecinii unui punct sunt obstacole, iar caracterul nu poate trece
se va intoarce distanta -1, ceea ce inseamna ca cele doua caractere nu se pot intalni.
	Aceste concluzii sunt scrise intr-un fisier, cu acelasi nume ca si cel de input,
doar cu extensia ".out" .