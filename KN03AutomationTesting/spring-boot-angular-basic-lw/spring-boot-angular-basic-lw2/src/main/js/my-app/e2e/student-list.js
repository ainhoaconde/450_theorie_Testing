const { Builder, By, Key, until } = require('selenium-webdriver');

async function runTest() {
  // Webdriver initialisieren (verwenden Sie den richtigen Browser-Driver und den Pfad dazu)
  const driver = await new Builder().forBrowser('chrome').build();

  try {
    // Webseite besuchen
    await driver.get('http://localhost:4200/');  // Hier die URL Ihrer Angular-Anwendung eintragen

    // Hier den Namen des zu überprüfenden Studenten eintragen
    const expectedStudentName = 'Jonas';

    // Button finden und darauf klicken (angenommen, es ist ein <button> mit einer bestimmten ID)
    const button = await driver.findElement(By.id('button_id'));
    await button.click();

    // Studentenliste finden (angenommen, sie ist in einem <ul> mit einer bestimmten ID)
    const studentList = await driver.findElement(By.id('student-list'));

    // Alle Studenten in der Liste abrufen
    const studentNames = await studentList.findElements(By.className('student-name'));

    // Überprüfen, ob der erwartete Student in der Liste ist
    let found = false;
    for (const studentName of studentNames) {
      const text = await studentName.getText();
      if (text.includes(expectedStudentName)) {
        found = true;
        break;
      }
    }

    if (found) {
      console.log(`Student "${expectedStudentName}" wurde gefunden.`);
    } else {
      console.error(`Student "${expectedStudentName}" wurde nicht gefunden.`);
    }
  } finally {
    // WebDriver beenden
    await driver.quit();
  }
}

// Test ausführen
runTest();
