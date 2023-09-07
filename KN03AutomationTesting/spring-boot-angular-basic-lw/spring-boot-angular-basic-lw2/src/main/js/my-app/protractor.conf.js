exports.config = {
  framework: "jasmine",
  specs: ["./e2e/student-list.js"],
  multiCapabilities: [
    {
      browserName: "chrome",
    },
    {
      browserName: "MicrosoftEdge", 
    },
  ],
  seleniumServerJar:
    "./node_modules/protractor/node_modules/webdriver-manager/selenium/selenium-server-standalone-3.141.59.jar",
};
