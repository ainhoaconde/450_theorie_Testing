const { By, Builder, Browser } = require("selenium-webdriver");
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

      it("List all students", async function () {
        await driver.get("http://localhost:4200");
        await sleep(500);

        let listButton = await driver.findElement(By.name("listButton"));

        await listButton.click();
        await sleep(500);

      });
    });
  },
  { browsers: [Browser.CHROME] }
);
