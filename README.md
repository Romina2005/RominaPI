## Sistem de gestionare a studentilor

Leuca Romina-Anamaria

## Descriere
Sistemul permite stocarea datelor studenților unei facultăți. Utilizatorul aplicației
poate adăuga, edita și șterge un student, poate căuta studenții înregistrați după nume și
poate vizualiza informațiile studentului, precum numele, specializarea, notele obținute la
diferite materii, etc.

## Obiective
-Stocarea, organizarea și accesarea datelor despre studenți, materii și note.

-Simplificarea procesului de calcul al mediilor generale și al mediilor pe materii.

-Oferirea unei interfețe grafice ușor de utilizat, care să reducă timpul necesar gestionării datelor.

-Asigurarea salvării permanente a datelor despre studenți într-o bază de date 

-Oferirea unui instrument care să ajute cadrele didactice să gestioneze rapid și organizat datele despre studenți.


## Arhitectura
1.Stratul de prezentare:

•Rol: Gestionează interfața grafică și interacțiunea cu utilizatorul.

•Clase principale:
•MainFrame – Fereastra principală a aplicației.
•UIManagerUtil – Configurarea aspectului grafic al aplicației (culori, fonturi, stiluri).

2.Stratul logicii aplicației 

•Rol: Gestionează logica principală a aplicației, cum ar fi manipularea informațiilor despre studenți și calcularea statisticilor.

•Clase principale:
•Student – Reprezintă un student și gestionează informațiile legate de acesta (nume, specializare, note, calcul medii).

3.Stratul de acces la date

•Rol: Gestionează interacțiunea cu baza de date pentru stocarea și extragerea informațiilor.

•Clase principale:
•DatabaseManager – Se ocupă de conectarea la baza de date Derby și executarea interogărilor SQL.

4.Stratul de utilitare:

•Rol: Oferă funcționalități auxiliare care sunt utilizate de alte straturi.

•Clase principale:
•UIManagerUtil – Personalizează aspectul grafic al aplicației.



## Functionalitati/Exemple utilizare
•Butoane pentru acțiuni frecvente: Adaugă student, Detalii student.

• Afiseaza toti: O pagina care afișează toți studenții cu nume,
specializare, medie generală, etc.

• Funcționalitate de căutare: O bară de căutare unde introducem numele studentului asupra caruia dorim sa interactionam

• O pagină dedicată care arată toate informațiile despre un student selectat(Detalii student): o Nume, specializare, materii, medie generală, și notele pe materii.

• O opțiune de modificare a detaliilor unui student

• Un buton de stergere student 
