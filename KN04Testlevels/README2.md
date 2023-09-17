# Aufgabe 2 - JUnit Zusammenfassung
 
 ### JUnit-Funktionen
 JUnit ist ein beliebtes Framework für das Testen von Java-Anwendungen. Unten habe ich einige Funktionen von JUnit aufgezehlt mit jeweils einer kurzen Erklärung und einem Beispiel.

 1. **Annotationen**
*Erklärung:* Annotationen wie @Test werden verwendet, um Methoden als Testfälle zu kennzeichnen.
*Beispiel:*
```java
import org.junit.Test;

@Test
public void testAddition() {

}
```
2. **Assertions (Prüfungen)**
*Erklärung:* Assertions wie assertEquals werden verwendet, um zu überprüfen, ob erwartete und tatsächliche Werte übereinstimmen.

*Beispiel:*
```java
import static org.junit.Assert.assertEquals;

int result = add(2, 3);
assertEquals(5, result);
```
3. **Parametrisierte**
*Erklärung:* Parametrisierte Tests ermöglichen es, eine Methode mit verschiedenen Eingabewerten zu testen.

*Beispiel:*

```java
Copy code
@ParameterizedTest
@ValueSource(ints = {1, 2, 3})
void testMultiply(int value) {
    assertEquals(value * 2, multiplyByTwo(value));
}
```
4. **Test-Suiten**
*Erklärung:* Test-Suiten helfen dabei, verwandte Testklassen zusammenzufassen und auszuführen.

*Beispiel:*

```java
Copy code
@RunWith(Suite.class)
@Suite.SuiteClasses({TestClass1.class, TestClass2.class})
public class TestSuite {
    // Hier können keine Tests hinzugefügt werden, nur Testklassen
}
```
5.**Timeouts (Zeitlimits)**
*Erklärung: *Sie können angeben, wie lange ein Test maximal dauern darf.

*Beispiel:*

```java
Copy code
@Test(timeout = 1000) // 1 Sekunde
public void testZeitsensitiveOperation() {
    // Testcode hier
}
```
6. **Before- und After-Hooks**
*Erklärung:* Methoden, die mit @Before und @After annotiert sind, werden vor und nach jeder Testmethode ausgeführt.

*Beispiel:*

```java
Copy code
@Before
public void setUp() {
    // Vorbereitungscode
}

@After
public void tearDown() {
    // Aufräumcode
}
```
7. **Ignorierte Tests**
*Erklärung:* Tests, die mit @Ignore annotiert sind, werden während der Testausführung übersprungen.

*Beispiel:*

```java
Copy code
@Ignore("Dieser Test ist noch nicht implementiert")
@Test
public void testNichtImplementierteFunktion() {
    // Testcode hier
}
```
8. **Assertions mit**
*Erklärung:* JUnit 5 ermöglicht das Erstellen benutzerdefinierter Prüfungen mit mehr Flexibilität.

*Beispiel:*

```java
Copy code
import static org.junit.jupiter.api.Assertions.assertThrows;

assertThrows(ArithmeticException.class, () -> divide(1, 0));
```
9. **Testparameter mit Annotations (JUnit 5)**
*Erklärung:* Man können Testparameter mithilfe von Annotations an Testmethoden übergeben.

*Beispiel:*

```java
Copy code
@ParameterizedTest
@ValueSource(strings = {"Apfel", "Banane", "Kirsche"})
void testObst(String obst) {
    assertTrue(istLecker(obst));
}
```
### Referenz
Die Informationen habe ich von der [offiziellen JUnit-Dokumentation](https://junit.org/junit5/docs/current/user-guide/). Dort habe ich ausführliche Informationen zu den Funktionen und Verwendungszwecken von JUnit gefunden.
