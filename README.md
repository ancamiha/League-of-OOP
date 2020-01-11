Enache Anca - Mihaela 324CD

-----ETAPA 1-----
Proiectul meu contine 4 package-uri: abilities, heroes, main si map.

-package-ul main contine 3 clase
    GameInput si GameInputLoader realizeaza citirea din fisier, creearea jucatorilor
si returnarea unor liste si valori necesare in main.
    In Main se apeleaza metoda load() pentru citirea din fisier, se realizeaza harta
prin utilizarea makeMap, din package-ul map si are loc desfasurarea jocului.
Se seteaza tipul locatie pentru fiecare jucator din lista de eroi, se verifica
fiecare jucator prin metoda de tip boolean getStillApply() daca acesta trebuie
sa primeasca damage overtime, apoi are loc lupta. Pentru lupta se parcurge 
matricea harta si se cauta 2 jucatori aflati pe aceeasi casuta si se apeleaza 
metodele ce apartin implementarii design pattern-ului Visitor "accept". In cazul
in care unul dintre jucatori este Wizard acesta va fi primul ce va fi atacat pentru
a determina damage-ul primit fara race modifiers. Dupa se verifica daca vreunul din
jucatori a murit, daca a murit se apeleaza metoda increaseXP() ce creste XP-ul 
eroului castigator si eventual creste si nivelul acestuia. Dupa ce au loc toate
rundele se scrie rezultatul in fisier prin apelui metodei "print" din clasa 
Singleton "PrintResult".

-package-ul map contine 2 clase
    TypeOfField clasa de tip enum ce contine tipurile de teren existente in joc.
    Clasa Singleton Map, ce contine metoda statica makeMap ce primeste ca argumente
informatii despre dimensiune si o lista de stringuri ce contine descrierea locatiilor.
In makeMap(...) parcurg o matrice de tip TypeOfField[] si pun cu ajutorul unui switch
informatiile sustrase din lista de stringuri.

-package-ul heroes contine 7 clase, 5 dintre acestea fiind inrudite
    HeroType, clasa enum ce contine tipurile eroilor.
    PrintResult scrie rezultatul in fisierul de output.
    Hero, clasa abstracta contine un constructor ce initializeaza jucatorii cu 
informatii importante si getterii si setterii aferenti. De asemenea contine metode 
ce dau update la anumite informatii, metoda "increaseXP" ce creste xp-ul eroului
castigator, metoda "levelUp" ce creste nivelul eroului castigator daca se depaseste
un anumit xp, metoda "moveHero" ce realizeaza deplasarea eroului pe harta, metoda
"overTimeAbilities" ce initializeaza informatiile necesare damage-ului overtime.
Clasa Hero contine si metodele abstracte "accept" si "interactWith" ce implementeaza
design pattern-ul Visitor folosindu-se de Double Dispatch pentru a usura accesul la
abilitatile utilizate in lupta dintre doi eroi.
    Clasa Hero este mostenita de clasele: Knight, Rogue, Pyromancer si Wizard.
    Cele 4 clase sunt similare, continand metoda getValueOfHp, ce returneaza in functie
de baseDamage si levelHp valoarea maxima a hp-ului unui erou si implementarea metodelor
"accept" si "interactWith". In "interactWith" se calculeaza damage-ul si se da update
la hp-ul victimei. Daca victima este Wizard se calculeaza si damage-ul fara race 
modifiers si se seteaza campul "damageReceived" al eroului de tip Wizard.

-package-ul abilities contine 5 clase ce sunt inrudite
    Abilities, clasa abstracta ce contine numai metode abstracte si 4 campuri ce contin
valoarea modificatorului de teren corespunzator fiecarui erou.
    Cele 4 clase ce mostenesc clasa Abilities implementeaza metodele abstracte definite
in aceasta. Metodele "getRaceModifiersFirst" si "getRaceModifiersSecond" returneaza
valoarea amplificatorului de rasa corespunzator victime pentru prima si a doua 
abilitate.
    Metodele "firstAbility" si "secondAbility" calculeaza damage-ul fara amplificator
rasa in functie de regulile oferite in eneuntul temei.
    Metoda "getDamage" returneaza damage-ul total rezultat din ambele abilitati cu tot
cu amplificatori de rasa.
    Metoda "getDamageWithoutM" returneaza damage-ul total rezultat din ambele 
abilitati fara amplificatori de rasa.


-----ETAPA 2-----
    Pentru adaptarea codului la cerintele etapei a doua am adaugat schimbat un pic 
codul din prima etapa adaugand un Factory pentru ingeri.
    Etapa a doua a cuprins familiarizarea cu 2 noi design pattern-uri: Strategy si
Observer si implementarea unui Visitor pentru interactiunea ingeri-eroi.
    Astfel, pentru a implementa Strategy, am adaugat 2 clase, "FirstStrategy" si 
"SecondStrategy", si o interfata , Strategt,  in package-ul "hero" si o metoda noua
in clasa "Hero". Cele 2 clase calculeaza noile caracteristiti optinute in urma
modificarilor dupa alegerea unei strategii, iar prin metoda din clasa Hero 
se alege strategia potrivita in functie de conditiile date in enunt.
    Pentru a implementa Observer, am creat un package nou, "wizard" in care am 7 
clase: TheGreatWizard, WizardSubject, ObserveAngelAction, ObserveAppearence, 
ObserveKilled, ObserveKilledByAngel, ObserveLevelChange. 
    Clasa abstracta TheGreatWizard observa schimbarile aduse personajelor prin
suprascrierea metodei "update" in fiecare clasa de tip Observe.
    Clasa ObserveAngelAction, printeaza ori de cate ori un inger ajuta sau 
loveste un erou, ObserveAppearence printeaza locul in care apare ingerul.
ObserveKilled printeaza daca un erou a omorat alt erou, ObserveKilledByAngel
printeaza daca un inger a omorat un erou si ObserveLevelChange printeaza  daca
eroul avanseaza in nivel.
    Clasa WizardSubject contine obiectele observate cat si setter-ii necesari
acestora, o metoda "attach" pentru a adauga un observer in lista de observers
si o metoda "notifyAllObservers" pentru apelul metodei "update".
    Pentru a implementa Visitorul am adaugat o metoda abstracta in clasa Hero,
"acceptAngel" ce are ca argument un inger si o meroda abstracta in clasa Angel,
"actionOn" ce are ca argument un erou.
    Pentru a implementa ingerii am creat cate o clasa separat pentru fiecare,
clasele mostenind clasa abstracta Angel.

