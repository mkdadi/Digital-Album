install:
	@javac src/*
	@echo -e 'compiled java files\nRun java src.Window to start app'
clean:
	rm src/*.class
