const { By, Builder, Browser, until } = require("selenium-webdriver");
const { suite } = require("selenium-webdriver/testing");
function sleep(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}

suite(
  function (env) {
    describe("Student", function () {
      let driver;

      before(async function () {
        driver = await new Builder().forBrowser("chrome").build();
      });

      after(async () => await driver.quit());

      it("Add a new student", async function () {
        await driver.get("http://localhost:4200");
        await sleep(500);

        let addButton = await driver.findElement(By.name("addButton"));
        await addButton.click();

        const nameLabel = await driver.findElement(By.id("name"));
        await nameLabel.sendKeys("SeleniumTestStudent");

        const emailLabel = await driver.findElement(By.id("email"));
        await emailLabel.sendKeys("SeleniumTestStudent@selenium.com");
        await sleep(500);
        
        let submitButton = await driver.findElement(By.name("submitButton"));
        await submitButton.click();
      });
    });
  },
  { browsers: [Browser.CHROME] }
);
