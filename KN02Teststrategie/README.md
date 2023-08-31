# Aufgabe 1

*Abstrakte Testfälle:*

| Testfall | Beschreibung |
|----------|--------------|
| Test 1   | Kaufpreis < 15'000 CHF, erwarteter Rabatt: 0% |
| Test 2   | 15'000 CHF <= Kaufpreis <= 20'000 CHF, erwarteter Rabatt: 5% |
| Test 3   | 20'000 CHF < Kaufpreis <= 25'000 CHF, erwarteter Rabatt: 7% |
| Test 4   | Kaufpreis > 25'000 CHF, erwarteter Rabatt: 8.5% |

*Konkrete Testfälle:*

| Testfall | Kaufpreis | Erwarteter Rabatt |
|----------|-----------|-------------------|
| Test 1   | 10'000 CHF| 0%                |
| Test 2   | 18'000 CHF| 5%                |
| Test 3   | 23'000 CHF| 7%                |
| Test 4   | 30'000 CHF| 8.5%              |

***
# Aufgabe 2
**Funktionale Black-Box Tests für die Plattform**
Link zurseite:https://www.rentalcars.com/de/city/ch/zurich/

| Testfall                 | Erwartetes Ergebnis                | Status |
|--------------------------|------------------------------------|--------|
| Sprach ändern                 | Erfolgreicher sprach geändert von Englisch auf Deutsch               |        |
| Aufgaben erstellen       | Neue Aufgabe wird angezeigt        |        |
| Aufgaben bearbeiten      | Änderungen werden gespeichert      |        |
| Aufgabenstatus aktualisieren | Status wird aktualisiert       |        |
| Prioritäten zuweisen (Datum, Zeit und Abholort)    | Aufgabe zeigt zugewiesene Priorität|        |
| Suchfunktion             | Korrekte Fahrzeuge werden angezeigt |        |
| Fahrzeug wird ausgewählt            | Korrekte Fahrzeug informationen werden angezeigt |        |
| Buchung weiter machen     | Versicherungsdetails wird angezeigt    |        |
| Benachrichtigungen       | Benachrichtigungen erhalten        |        |
| Angaben zum Hauptfahrer eintragen  | Angaben zum Hauptfahrer werden        |        |
| Rechnungadresse festlegen  | Rechnungsadresse Daten werden festgehalten     |        |
| Währung auswählen                 | Benutzer kann Währung auswählen mit welche er bezhalen will   |        |

***
# Aufgabe 3
1. Identifzieren Sie mögliche Black-Box Testfälle, welche Sie als Benutzer testen können.

Black-Box Tabelle
| Testfall | Eingabe   | Erwarteter Ergebnis |
|----------|-----------|-------------------|
| Navigationstest: | Wählen Sie verschiedene Menüoptionen ("a," "e," "w," "q") aus und folgen Sie den erwarteten Interaktionen.|Überprüfen Sie, ob das Programm durch das Menü navigiert und die beabsichtigten Aktionen ausführt.           |
| Kontolöschungstest  | Erstellen Sie ein Konto und versuchen Sie, es zu löschen| Stellen Sie sicher, dass der Prozess zur Kontolöschung wie erwartet funktioniert und die Absichten des Benutzers bestäti |

2. Welche Methoden im Code könnten für White-Box Testfälle verwendet werden?

White-Box Tabelle
| Testfall | Eingabe   | Erwarteter Ergebnis |
|----------|-----------|-------------------|
| Pfadabdeckung  | Geben Sie "e" ein, um ein Konto zu erstellen, und geben Sie dann gültige Daten für die Kontenerstellung ein.|Der Code solte die Logik zur Kontenerstellung korrekt ausführen.              |
| Fehlerbehandlung  |Eingabe von verschiedenen Stellen im Code ein ungültige Eingaben| Überprüfen von den Fehlerbehandlungsmechanismen (Ausnahmen, Meldungen) korrekt ausgelöst werden.            |
| Währungsumrechnungstest  | Führen der Überweisung mit verschiedenen Währungen durch.|   Sicher stellen, dass die Währungsumrechnungslogik wie beabsichtigt funktioniert             |

**Methoden**
chooseAccount(), editAccount(int accountNo),transfer(Account accFrom), createAccount(), getExchangeRate(): Testen von Eingabe für den Wechselkursabruf, indem 
gültige und ungültige Währungspaare eingeben werden.


1. Was würden Sie am Code generell verbessern, welche Best Practices fallen Ihnen ein
   + Verwendung von Enums für Aktionen und Währungen
     + Statt hartcodierte Zeichen zu verwenden, könnten Enums für die Aktionen ("e", "a", usw.) und Währungen (CHF, EUR, USD) erstellt werden. Dies würde die Lesbarkeit und Fehleranfälligkeit des Codes verbessern.

   + Trennung von Benutzereingabe und Logik
     + Die Benutzereingabe und die Logik sollten getrennt werden. Dies würde die Testbarkeit verbessern.

   + Validierung von Benutzereingaben 
     + Überall dort, wo Benutzereingaben sind sollte man idealerweise  Validierungen hinzu, um sicherzustellen, dass nur gültige Eingaben akzeptiert werden.

   + Tests 
     + automatisierte Tests schrieben damit in Zukunft Zeit gespaart werden kann.