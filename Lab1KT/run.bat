echo off
set path=C:\Users\Snoop_dog40\.jdks\openjdk-14.0.2\bin
set include=C:\Users\Snoop_dog40\.jdks\openjdk-14.0.2\include
set lib=C:\Users\Snoop_dog40\.jdks\openjdk-14.0.2\lib
set link=C:\Users\Snoop_dog40\.jdks\openjdk-14.0.2\bin
javac -version Lab1Skrynnik.java
java Lab1Skrynnik
javap -c Lab1Skrynnik >1.txt
javadoc Lab1Skrynnik.java -d 1
pause