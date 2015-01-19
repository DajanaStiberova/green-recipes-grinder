#!/bin/sh
. ./setGrinderEnv.sh
java -classpath $CLASSPATH net.grinder.TCPProxy -http clojure -console > grinder.clj
