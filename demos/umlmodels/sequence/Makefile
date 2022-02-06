clean:
	rm -f *.png *.svg

run:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar

blackbox:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar --headless blackbox.seq
	
example:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar --headless example.seq

gui1:
	java -jar sequence-10.0.jar

gui2:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar

run1:
	java -jar sequence-10.0.jar --headless $(example)

run2:
	java -Dzanthan.prefs=diagram.preferences -jar sequence-10.0.jar --headless $(example)