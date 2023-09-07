const { By, Builder, Browser,until  } = require('selenium-webdriver');
const { suite } = require('selenium-webdriver/testing');
const assert = require("assert");

function sleep(ms) {
  return new Promise(resolve => setTimeout(resolve, ms));
}

suite(function (env) {
  describe('Test script', function () {
    let driver;

    before(async function () {
      driver = await new Builder().forBrowser('chrome').build();
    });

    after(async () => await driver.quit());

    it('First Selenium script', async function () {
        await driver.get('https://www.selenium.dev/selenium/web/web-form.html');
        let title = await driver.getTitle();
        assert.equal("Web form", title);
      
        await driver.manage().setTimeouts({ implicit: 500 });
      
        let textBox = await driver.findElement(By.name('my-text'));
        let submitButton = await driver.findElement(By.css('button'));
      
        await textBox.sendKeys('Selenium');
        await sleep(500);
        await submitButton.click();
        await sleep(500);
      
        await driver.wait(until.elementLocated(By.id('message')), 5000); 
      
        let message = await driver.findElement(By.id('message'));
        let value = await message.getText();
        assert.equal("Received!", value);
      });
  });
}, { browsers: [Browser.CHROME, Browser.FIREFOX]});
