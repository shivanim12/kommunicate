Infilect test
-------------

1) import this project and run it with java 8
2) you'll need to download ChromeDriver from this link https://chromedriver.storage.googleapis.com/index.html?path=83.0.4103.39/
3) set env variable BROWSER as the name of the browser you want to run the test with : chrome, opera, firefox etc..
4) set env variable DRIVER_TYPE as type of the driver based on the browser you have selected
5) set env variable DRIVER_PATH as the full path to the driver which you downloaded in step 2
6) set env variable SMTP_USER_NAME as your gmail id (This will be used to send email)
7) set env variable SMTP_PASSWORD as the password of the above email id (This will be used to send email)
8) set env variable TO_EMAIL as the email to which you want to send the error email to.
6) mvn clean install
7) run the java program