[![Build Status](https://travis-ci.com/Dane1998/CA-1.svg?branch=master)](https://travis-ci.com/Dane1998/CA-1)




Index siden:
Index siden virker som den skal, men det er værd at lægge mærke til at selvom det ikke ser sådan ud, så virker "reload names" knappen. Sagen er bare at siden selv reloader hvis man tilføjer nye medlemmer via URL'en, så den skal i teorien aldrig bruges, selvom den "backend-wise" virker helt som planlagt.


Car siden:
Car siden virker som planlagt, dog er den ligesom index siden ikke ret pæn at kigge på. Sortering metoden på carsiden er ikke ret brugervenlig da man kun descencde eller ascende listen, og ikke finde data efter navn eller værdi. Det virker dog ved at klikke på toppen af hver tabel. 

Jokes siden halter lidt og mangler inputfeltet til at finde joke med id, men der findes en metode i vores projekt, man skal dog tilgå den via endpoint /api/jokes/(id på joken).
Siden kan dog få fat på alle jokes som bliver sat ind i databasen, hente dem og printe dem ud i en tabel. Af en eller anden grund kan id'et på jokes ikke findes når dataen bliver sat ind i tabelen selv om findJokesByID metoden fungerer og kan finde jokes når man skriver deres id. 

Test: Ikke alle metoderne har en tilhørende test som de nok burde ha' haft. 

Vi har brugt meget tid på at fikse et problem med databasen.




