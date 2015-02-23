# GUI-Idee

*   Erster View: Text eingeben und angeben auf welchen Plattformen gepostet werden
soll.
*   Zweiter View: Text für einzelne Plattformen nachbearbeiten.
*   Andere Views: Logins für alle Plattformen.

# Interface Entwurf

Es soll für jede Plattform/API eine Klasse zur Verfügung stehen die von der
Validierung des Inputs bis zur Authentifizierung gegenüber den Services und dem
Posten alles übernimmt.

Was müssen die Klassen können:

*   newPost
*   Senden
*   showEditPanel
*   showAddPanel
*   saveData
*   loadData
*   getDetailPanel
*   addPhoto  
    auch wenn die Methode nur ausgibt, dass kein Photo hochgeladen werden kann
*   addVideo

Konstruktor:  
soll leeren Prototyp liefern, dann ruft man loadData oder showAddPanel auf.


