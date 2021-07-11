# Burp Suite Extension Template

Template codes for burp extension developers.

## Motivation
As far as I could find, there is no sample extension that describes how to set up github actions and build by command line. Therefore, I created it.

## Installation
In Burp, go to the Extender tool, and the Extensions tab, and add a new extension. Select the extension type "Java", and specify the location of your JAR file.

## How to Build
### IntelliJ IDEA
If you are using intellij, you can build it with the following steps.

1. Open the Project Structure dialog: `File` -> `Project Structure`
2. Set target artifact: `Artifacts` -> `Add` -> `JAR` -> `From modules with dependencies...`
3. Close the Create JAR from Modules dialog: `OK`
4. Close the Project Structure dialog: `Apply` -> `OK`
5. Build JAR: `Build` -> `Build Artifacts` -> `Example:jar` -> `Build`

### Command line

```
$ mvn install
```

## Usage
A menu is added. It's available from HTTP History tab.

<img src="img/menu.png" width=400px>

Click on the menu to output the log.

<img src="img/log.png" width=600px>

A tab will also be added, when you add an extension.

<img src="img/tab.png" width=700px>

## LICENSE

MIT License

Copyright (C) 2021 tkmru
