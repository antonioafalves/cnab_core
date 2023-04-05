all: clean package install

package:
	mvn package -DskipTests

clean:
	mvn clean

install:
	mvn install
