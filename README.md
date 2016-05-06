ui-test

UI Test set for Pipeline project

Structure introduction

This set is composed of 2 modules: ui-testsuite and ui-common
ui-common includes all common functions that are used in testcases. Common functions are divided in .java files according to products, features and modules of Platform.
ui-testsuite includes all testcases which are executed to test our products. It is divided in packages according to products, features, and modules of Platform. Each package contains one or more .java files which are testsuites. Each testsuite that includes one or more testcases is respective to one feature of Platform.

How to build the project

    Prerequisite
    Make sure that mvn 3.0.4 or later version is installed.
    Make sure that git bash is installed.
    Browsers must be available, at least Chrome
    Launch test Here are steps to build this project.
    Step 1: Make sure that the server is launched
    Step 2: Clone this project from github by typing a command: git@svc.tek-experts.com:hp/ui-test.git
    Step 3: On terminal, go to ui-test folder.
    Step 4: Type a command: mvn clean install [-P] [-Dbrowser=] -DbaseUrl= Where: is id of profile in the ui-testsuite/pom.xml. 
    This is a must = chrome | iexplorer. If not, Chrome is used by default = The url to Pipeline project. 
    If not, url http://10.12.14.205:8089/ is used by default 
    Example: Assume a profile with id "login-func" is defined in the ui-testsuite/pom.xml 
    To run test cases of this profile on Chrome, with Url "c9w21908.itcs.hpecorp.net", run the following command: 
    mvn clean install -Plogin-func -Dbrowser=chrome -DbaseUrl=c9w21908.itcs.hpecorp.net
