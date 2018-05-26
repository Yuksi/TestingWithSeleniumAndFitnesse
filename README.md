# TestingWithSeleniumAndFitnesse
I started test with login to mail ukr.net

running java -jar fitnesse-standalone.jar -p 2222 (because default port is already in use)



fitnesse test is:
!define TEST_SYSTEM {slim}
 
!path D:\documents\java\IdeaProjects\test\target\classes
 
| letter.MailFixture |  
| login | psw | login? |  
| yuksi_test | test_yuksi | true |  
| yuksi_test | te | false |  
| yuk | te | false |  
| abracadabraabracadabra | te | false |  
|  | te | false |  
| yuksi_test |  | false |  
| ??// |  | false |

for now - I have exception in fitnesse - java.lang.NoClassDefFoundError: org/openqa/selenium/WebDriver
dependencies are in project, so I didn't find out the reason yet
