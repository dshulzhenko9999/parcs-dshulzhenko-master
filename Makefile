all: run

clean:
	rm -f out/Bluck.jar out/RabinKarp.jar

out/Bluck.jar: out/parcs.jar src/Bluck.java src/Input.java src/Result.java
	@javac -cp out/parcs.jar src/Bluck.java src/Input.java src/Result.java
	@jar cf out/Bluck.jar -C src Bluck.class -C src Input.class -C src Result.class
	@rm -f src/Bluck.class src/Input.class src/Result.class

out/RabinKarp.jar: out/parcs.jar src/RabinKarp.java src/Input.java src/Result.java
	@javac -cp out/parcs.jar src/RabinKarp.java src/Input.java src/Result.java
	@jar cf out/RabinKarp.jar -C src RabinKarp.class -C src Input.class -C src Result.class
	@rm -f src/RabinKarp.class src/Input.class src/Result.class

build: out/Bluck.jar out/RabinKarp.jar

run: out/Bluck.jar out/RabinKarp.jar
	@cd out && java -cp 'parcs.jar:Bluck.jar' Bluck

