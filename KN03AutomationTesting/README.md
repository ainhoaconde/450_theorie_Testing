# Apache JMeter
- Apache JMeter™ ist eine Open-Source-Testanwendung
- Sie ist in Java geschrieben und dient dazu, das Verhalten von Anwendungen zu testen und die Leistung zu messen.
- Ursprünglich für Webanwendungen entwickelt, kann sie auch für andere Testszenarien eingesetzt werden.
- Apache JMeter kann die Leistung von statischen und dynamischen Ressourcen sowie von Webanwendungen testen.
- Es ermöglicht die Simulation hoher Belastungen auf verschiedene Systeme, um deren Robustheit zu überprüfen.
- Mit JMeter können Sie die Gesamtleistung unter verschiedenen Lastszenarien analysieren.

## JMeter Funktionalitäten
1. HTTP- und HTTPS-Anfragen: JMeter ermöglicht das Senden von HTTP- und HTTPS-Anfragen an Webseiten und Webdienste. Sie können GET-, POST-, PUT- und DELETE-Anfragen erstellen und anpassen.
2. Testplan: Es ist möglich einen Testplan zuerstellen, der alle Testelemente enthält, die für  die Test erforderlich sind.
3. Thread-Gruppen: Thread-Gruppen repräsentieren Benutzer oder Threads, die Anfragen an das Testziel senden
4. Sampler: Sampler repräsentieren die Art der Anfrage, die an das Testziel gesendet wird. JMeter unterstützt HTTP Request Sampler, JDBC Request Sampler, FTP Request Sampler und mehr.
5. Controller: Controller steuern die Ausführung der Sampler. 
6. Parametrisierung: Sie können CSV-Dateien oder Datenbankabfragen verwenden, um Testdaten zu parametrisieren und mehrere Datensätze in Ihren Tests zu verwenden.
7. Integration mit CI/CD-Pipelines: JMeter kann in Continuous Integration/Continuous Deployment (CI/CD)-Pipelines integriert werden, um automatisierte Leistungstests während des Entwicklungsprozesses durchzuführen.

# Bonus Aufgabe
**User Story: Validierung von Benutzereingaben für Name und Email**

**Ziel** Sicherstellen, dass die Eingaben des Benutzers für Name und Email sowohl auf der Frontend- als auch auf der Backend-Seite validiert werden.Damit verhindert wird, dass ungültige oder schädliche Daten in die Anwendung gelangen, die die Funktionalität beeinträchtigen könnten.

*Akzeptanzkriterien:*

1. **Name-Validierung (Frontend und Backend):**
   - Der Benutzer wird darauf hingewiesen, dass der Name mindestens drei Buchstaben enthalten muss, wenn er versucht, das Formular abzusenden.
   - Der Name darf keine Zahlen enthalten, und der Benutzer wird darauf hingewiesen.

2. **Email-Validierung (Frontend und Backend):**
   - Die Eingabe des Benutzers für die Email-Adresse wird auf Gültigkeit geprüft, um sicherzustellen, dass sie einer typischen Email-Formatierung entspricht.
   - Der Benutzer wird darauf hingewiesen.

3. **Backend-Validierung:**
   - Das Backend führt dieselben Validierungen für Name und Email durch, um sicherzustellen, dass ungültige Daten nicht in der Datenbank gespeichert werden.

4. **Zeitrahmen:**
   - Die Implementierung der Validierungen für Name und Email auf der Frontend- und Backend-Seite sollte innerhalb von 45 Minuten abgeschlossen sein.

**Definition of Done:**
- Die Validierung für Name und Email ist sowohl auf der Frontend- als auch auf der Backend-Seite implementiert und funktioniert wie erwartet.
- Dem Benutzer wird angezeit was er eingeben kann und was nicht.

**Reflektion**
Die Aufgabe, Benutzereingaben für Name und Email sowohl auf der Frontend- als auch auf der Backend-Seite zu validieren, war eine lehrreiche Erfahrung. Obwohl ich zu Beginn mit Maven und Angular nicht vertraut war, konnte ich mich schnell in die Thematik einarbeiten und die erforderlichen Abhängigkeiten finden. Die anfängliche Herausforderung bestand darin, mich mit den neuen Technologien vertraut zu machen und sicherzustellen, dass ich die richtigen Abhängigkeiten für die Validierung hinzufüge. Wo welche files sind.

**Vorgehungsweise**
1. Öffne 'pom.xml'
2. Hinzufügen von den Dependency
```xml
<dependency>
    <groupId>javax.validation</groupId>
    <artifactId>validation-api</artifactId>
    <version>2.0.1.Final</version> <!-- Update the version if necessary -->
</dependency>
<dependency>
    <groupId>org.hibernate.validator</groupId>
    <artifactId>hibernate-validator</artifactId>
    <version>7.0.1.Final</version> <!-- Update the version if necessary -->
</dependency>
```
1. Speichere die pom.xml-Datei und führe einen Buildvorgang aus, um die Abhängigkeiten herunterzuladen und in dein Projekt einzufügen.
