In implementarea temei am urmarint sa rezolv cerinta temei, punand accent pe utilizarea corecta a Design Pattern-urilor si a principiilor OOP studiate (mostenire, polimorfism, incapsulare).

Am ales sa structurez aplicatia folosind urmatoarele 4 Design Pattern-uri, pentru a evita codul repetitiv si pentru a separa reponsabilitatile:

- Singleton (in clasa "Database") - Am folosit acest pattern pentru a asigura o singura instanta a bazei de date in memorie. Astfel, toate comenzile lucreaza pe aceleasi seturi de "servers" si "resourceGroups".

- Factory (in clasa "UserFactory") - Am folosit acest pattern pentru a simplifica crearea obiectelor de tip "User". In loc sa verific manual in "Main" ce tip de utilizator trebuie creat, clasa "UserFactory" analizeaza parametrii si returneaza instanta corecta ("Admin", "Operator" sau "User").

- Builder (in clasa "ServerBuilder") - Am folosit acest pattern, deoarece entitatea "Server" are multe atribute si ne-ar fi fost greu sa urmarim un constructor clasic. Builder-ul permite construirea pas cu pas a obiectului si setarea doar a parametrilor disponibili in fisierul de intrare.

- Command (interfata "Command" si clasa "CommandInvoker") - Am folosit acest pattern pentru a transforma fiecare operatiune (de ex: "ADD SERVER", "ADD EVENT") intr-o clasa separata care implementeaza interfata "Command". Asta a eliminat structurile imense de "if" si "else" si a facut codul mult mai usor de testat si extins.


Clasa "Main" am pastrat-o curata. Aceasta are rolul de a coordona executia.
Clasa "CommandInvoker" stie sa mapeze string-ul comenzii la clasa corespunzatoare. Programul itereaza prin toate fisierele primite ca argument, proceseaza liniile si scrie rezultatele sau erorile in fisiere de output.