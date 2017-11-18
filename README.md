# jjwt Consumer Example

This is an example project that is using [jjwt](https://github.com/jwtk/jjwt).  The purpose of this project is to help test usage of the jjwt jar.  Since Java 9 is deprecating jaxb in the SE jdk, special care has to be taken for libraries that expect the jaxb classes.

## Prereqs for Mac

I did my testing in OS X.  You can do the testing in the following sections in any OS as long as you have multiple versions of java and manually set your JAVA_HOME before running maven.  I'm using [jenv](http://www.jenv.be/) to manage my java & JAVA_HOME in these examples.

Enable jenv to work with mvnw if you haven't before:
(otherwise, mvnw doesn't respect the version of java jenv is specifying)
https://github.com/gcuisinier/jenv/issues/78

```shell
jenv enable-plugin export
```

## Testing jjwt 

### Java 7

Set jdk1.7:

```shell
jenv local 1.7
```

Confirm the java version maven will use is 1.7:

```shell
./mvnw -version
```

```
Maven home: /Users/ryan/.m2/wrapper/dists/apache-maven-3.5.2-bin/28qa8v9e2mq69covern8vmdkj0/apache-maven-3.5.2
Java version: 1.7.0_51, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.7.0_51.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.1", arch: "x86_64", family: "mac"
```


Now build with java 7 (the maven profile to target 1.7 will kick in):

```shell
./mvnw clean verify
```

```
[INFO] Surefire report directory: /Users/ryan/projects/java/jjwt-consumer-example/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running ExampleTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.048 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ jjwt-consumer-example ---
[INFO] Building jar: /Users/ryan/projects/java/jjwt-consumer-example/target/jjwt-consumer-example-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.255 s
[INFO] Finished at: 2017-11-18T14:21:56-05:00
[INFO] Final Memory: 16M/310M
[INFO] ------------------------------------------------------------------------
```

### Java 8

Set jdk1.8:

```shell
jenv local 1.8
```

Confirm the java version maven will use is 1.8:

```shell
./mvnw -version
```

```
Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T03:58:13-04:00)
Maven home: /Users/ryan/.m2/wrapper/dists/apache-maven-3.5.2-bin/28qa8v9e2mq69covern8vmdkj0/apache-maven-3.5.2
Java version: 1.8.0_40, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk1.8.0_40.jdk/Contents/Home/jre
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.1", arch: "x86_64", family: "mac"
```


Now build with java 8 (the maven profile to target 1.8 will kick in):

```shell
./mvnw clean verify
```

```
[INFO] Surefire report directory: /Users/ryan/projects/java/jjwt-consumer-example/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running ExampleTest
Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.052 sec

Results :

Tests run: 1, Failures: 0, Errors: 0, Skipped: 0

[INFO] 
[INFO] --- maven-jar-plugin:2.4:jar (default-jar) @ jjwt-consumer-example ---
[INFO] Building jar: /Users/ryan/projects/java/jjwt-consumer-example/target/jjwt-consumer-example-0.0.1-SNAPSHOT.jar
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.159 s
[INFO] Finished at: 2017-11-18T14:23:06-05:00
[INFO] Final Memory: 16M/209M
[INFO] ------------------------------------------------------------------------
```


### Java 9

Set jdk1.9:

```shell
jenv local 9.0
```

Confirm the java version maven will use is 1.9:

```shell
./mvnw -version
```

```
Apache Maven 3.5.2 (138edd61fd100ec658bfa2d307c43b76940a5d7d; 2017-10-18T03:58:13-04:00)
Maven home: /Users/ryan/.m2/wrapper/dists/apache-maven-3.5.2-bin/28qa8v9e2mq69covern8vmdkj0/apache-maven-3.5.2
Java version: 9.0.1, vendor: Oracle Corporation
Java home: /Library/Java/JavaVirtualMachines/jdk-9.0.1.jdk/Contents/Home
Default locale: en_US, platform encoding: UTF-8
OS name: "mac os x", version: "10.13.1", arch: "x86_64", family: "mac"
```


Now build with java 9 (the maven profile to target 1.9 will kick in):

```shell
./mvnw clean verify
```

```
[INFO] Surefire report directory: /Users/ryan/projects/java/jjwt-consumer-example/target/surefire-reports

-------------------------------------------------------
 T E S T S
-------------------------------------------------------
Running ExampleTest
Tests run: 1, Failures: 0, Errors: 1, Skipped: 0, Time elapsed: 0.065 sec <<< FAILURE!
testExerciseBase64Codec(ExampleTest)  Time elapsed: 0.009 sec  <<< ERROR!
java.lang.NoClassDefFoundError: javax/xml/bind/DatatypeConverter
    at io.jsonwebtoken.impl.Base64Codec.encode(Base64Codec.java:21)
    at Example.exerciseBase64Codec(Example.java:8)
    at ExampleTest.testExerciseBase64Codec(ExampleTest.java:11)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:564)
    at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
    at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
    at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
    at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
    at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
    at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
    at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
    at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
    at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
    at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
    at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
    at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
    at org.apache.maven.surefire.junit4.JUnit4Provider.execute(JUnit4Provider.java:252)
    at org.apache.maven.surefire.junit4.JUnit4Provider.executeTestSet(JUnit4Provider.java:141)
    at org.apache.maven.surefire.junit4.JUnit4Provider.invoke(JUnit4Provider.java:112)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
    at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
    at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
    at java.base/java.lang.reflect.Method.invoke(Method.java:564)
    at org.apache.maven.surefire.util.ReflectionUtils.invokeMethodWithArray(ReflectionUtils.java:189)
    at org.apache.maven.surefire.booter.ProviderFactory$ProviderProxy.invoke(ProviderFactory.java:165)
    at org.apache.maven.surefire.booter.ProviderFactory.invokeProvider(ProviderFactory.java:85)
    at org.apache.maven.surefire.booter.ForkedBooter.runSuitesInProcess(ForkedBooter.java:115)
    at org.apache.maven.surefire.booter.ForkedBooter.main(ForkedBooter.java:75)
Caused by: java.lang.ClassNotFoundException: javax.xml.bind.DatatypeConverter
    at java.base/jdk.internal.loader.BuiltinClassLoader.loadClass(BuiltinClassLoader.java:582)
    at java.base/jdk.internal.loader.ClassLoaders$AppClassLoader.loadClass(ClassLoaders.java:185)
    at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:496)
    ... 32 more


Results :

Tests in error: 
  testExerciseBase64Codec(ExampleTest): javax/xml/bind/DatatypeConverter

Tests run: 1, Failures: 0, Errors: 1, Skipped: 0

[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 2.387 s
[INFO] Finished at: 2017-11-18T14:26:10-05:00
[INFO] Final Memory: 15M/51M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.apache.maven.plugins:maven-surefire-plugin:2.12.4:test (default-test) on project jjwt-consumer-example: There are test failures.
[ERROR] 
[ERROR] Please refer to /Users/ryan/projects/java/jjwt-consumer-example/target/surefire-reports for the individual test results.
[ERROR] -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoFailureException
```

You can also see the problem by just running the main method:

```shell
./mvnw exec:java -Dexec.mainClass=Example
```

```
[INFO] Scanning for projects...
[INFO] 
[INFO] ------------------------------------------------------------------------
[INFO] Building An example usage of JWT to show the jaxb problems with Java 9 0.0.1-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO] 
[INFO] --- exec-maven-plugin:1.6.0:java (default-cli) @ jjwt-consumer-example ---


Expected: abc123
[WARNING] 
java.lang.NoClassDefFoundError: javax/xml/bind/DatatypeConverter
    at io.jsonwebtoken.impl.Base64Codec.encode (Base64Codec.java:21)
    at Example.exerciseBase64Codec (Example.java:8)
    at Example.main (Example.java:15)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:564)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:282)
    at java.lang.Thread.run (Thread.java:844)
Caused by: java.lang.ClassNotFoundException: javax.xml.bind.DatatypeConverter
    at java.net.URLClassLoader.findClass (URLClassLoader.java:466)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:563)
    at java.lang.ClassLoader.loadClass (ClassLoader.java:496)
    at io.jsonwebtoken.impl.Base64Codec.encode (Base64Codec.java:21)
    at Example.exerciseBase64Codec (Example.java:8)
    at Example.main (Example.java:15)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke0 (Native Method)
    at jdk.internal.reflect.NativeMethodAccessorImpl.invoke (NativeMethodAccessorImpl.java:62)
    at jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke (DelegatingMethodAccessorImpl.java:43)
    at java.lang.reflect.Method.invoke (Method.java:564)
    at org.codehaus.mojo.exec.ExecJavaMojo$1.run (ExecJavaMojo.java:282)
    at java.lang.Thread.run (Thread.java:844)
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 0.732 s
[INFO] Finished at: 2017-11-18T14:27:22-05:00
[INFO] Final Memory: 10M/34M
[INFO] ------------------------------------------------------------------------
[ERROR] Failed to execute goal org.codehaus.mojo:exec-maven-plugin:1.6.0:java (default-cli) on project jjwt-consumer-example: An exception occured while executing the Java class. javax/xml/bind/DatatypeConverter: javax.xml.bind.DatatypeConverter -> [Help 1]
[ERROR] 
[ERROR] To see the full stack trace of the errors, re-run Maven with the -e switch.
[ERROR] Re-run Maven using the -X switch to enable full debug logging.
[ERROR] 
[ERROR] For more information about the errors and possible solutions, please read the following articles:
[ERROR] [Help 1] http://cwiki.apache.org/confluence/display/MAVEN/MojoExecutionException
```
