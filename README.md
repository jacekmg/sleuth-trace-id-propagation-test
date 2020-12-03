This project shows bug in spring-sleuth. - https://github.com/spring-cloud/spring-cloud-sleuth/issues/1748

In order to change Spring cloud version, go to base.gradle file and change springCloudVersion parameter.

With Hoxton.SR2 TraceIdControllerTest passes, with Hoxton.SR3 and above, the test fails.
