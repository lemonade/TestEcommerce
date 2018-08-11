** PREPARATION
- Install Java Development Kit

<> Windows (7):
	Download and install JDK 1.8 at
	http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

<> Linux (Ubuntu)
	Run command: `sudo apt-get install openjdk-8-jdk`

- Download Apache Maven at
https://archive.apache.org/dist/maven/maven-3/3.3.9/binaries/apache-maven-3.3.9-bin.zip

- Add Maven binary to system path

<> Windows (7):
	Control Panel> System and Security> System> Advanced system settings>
	Environment variables> System variables> Choose `Path`> Edit>
	
	Add "[Maven directory]/bin" to path (; is separator) > OK> OK> OK
	
<> Linux (Ubuntu)
	export PATH=$PATH:[Maven directory]/bin

	
** RUN TEST
- Go to project folder and execute command `mvn test`
