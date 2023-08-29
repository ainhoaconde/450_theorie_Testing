# Aufgabe 1
### Test Tabelle

| Testart           | Durchführung                                                                                       |
|-------------------|----------------------------------------------------------------------------------------------------|
| **Unit Test**        | Kleine Einheiten des Codes werden isoliert getestet, um sicherzustellen, dass sie korrekt arbeiten. |
| **Integrationstest** | Mehrere Einheiten werden zusammengeführt und als Gruppe getestet, um ihre Interaktion zu prüfen.   |
| **Funktionstest**   | Die Funktionen einer Software werden auf ihre Erfüllung der Anforderungen hin überprüft.            |
| **Regressionstest**   | Früher funktionierende Teile des Codes werden erneut getestet, um sicherzustellen, dass sie nach Änderungen immer noch funktionieren.|
| **Penetration Testing** | Ein autorisierter Tester sucht nach Schwachstellen, um potenzielle Angriffspunkte aufzudecken.      |
| **Manuelles Testing**   | Tester führen manuelle Tests aus, um Probleme zu erkennen, die schwer zu automatisieren sind.      |
| **Stress Testing**    | Die Software wird unter extremen Bedingungen getestet, um Leistung, Stabilität und Skalierbarkeit zu überprüfen. |


# Aufgabe 2
### Fehler vs Mangel
Wenn wir vom Testen reden, dann kommen wir unweigerlich zu den Begriffen “Fehler” oder “Mangel”. Hier gibt es einen Unterschied:

*Fehler*
Wir reden von einem “Fehler”, wenn eine Anforderung nicht erfüllt wird. Wir haben eine Abweichung zwischen dem IST-Verhalten (also was das System während des Tests macht) und dem SOLL-Verhalten (was in der Spezifikation oder in den Anforderungen festgelegt wurde).

*Mangel*
Ein Mangel liegt vor, wenn eine gestellte Anforderung oder eine berechtigte Erwartung nicht angemessen erfüllt wird. So kann es sein, dass z.Bsp. eine Berechnung korrekt ausgeführt wird, jedoch wird die Berechnung nicht korrekt dargestellt (z.Bsp. in einem GUI).
**Beispiel für einen Software-Fehler:**
Beispiel bei einer Website. Der Warenkorb eines Benutzers sollte immer aktualisiert werden, wenn er Produkte hinzufügt oder entfernt. Ein Software-Fehler tritt auf, wenn der Warenkorb nicht korrekt aktualisiert wird, sobald ein Benutzer ein Produkt hinzufügt. Dies führt dazu, dass der tatsächliche Zustand des Warenkorbs nicht mit dem erwarteten Zustand übereinstimmt, was zu Fehlern bei der Bestellabwicklung und zur Verwirrung der Benutzer führen kann.

**Beispiel für einen Software-Mangel:**
zum Beispiel in einem GUI: Eine Software ähnlich wie jira,in dem der Benutzer Aufgaben mit Prioritäten zuweisen kann. Ein Software-Mangel könnte auftreten, wenn die Prioritäten der Aufgaben zwar korrekt gespeichert werden, jedoch auf der Benutzeroberfläche nicht ordnungsgemäss angezeigt werden. Zum Beispiel werden Aufgaben mit hoher Priorität nicht farblich hervorgehoben, wie es in den Anforderungen vorgesehen war. Dies führt dazu, dass die Benutzer Schwierigkeiten haben, die Priorität der Aufgaben zu erkennen.

**Beispiel für hohen Schaden bei einem Software-Fehler:**
Flugbuchungssoftware enthält einen Fehler im Buchungssystem. Wenn ein Benutzer versucht, einen Flug zu buchen, aber das Buchungssystem irrtümlich den Preis verdoppelt, könnte dies zu erheblichem finanziellen Schaden führen. Wenn Tausende von Flugtickets zu einem falschen Preis verkauft werden, können sowohl die Fluggesellschaft als auch die Kunden erhebliche Verluste erleiden. Dieser Fehler könnte auch das Vertrauen der Kunden in die Zuverlässigkeit der Software und des Unternehmens beeinträchtigen.

Es ist wichtig, Software-Fehler und -Mängel sorgfältig zu verwalten, um die Qualität und Zuverlässigkeit von Softwareprodukten sicherzustellen und potenziellen Schaden für Benutzer und Unternehmen zu minimieren

# Aufgabe 3
