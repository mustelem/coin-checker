#!/bin/bash
#assumes javac and maven installed

mvn install
java -cp target/coin-0.0.1-SNAPSHOT.jar com.hasdemir.coin.Coin


