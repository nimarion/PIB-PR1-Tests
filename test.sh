#!/bin/bash
cd ~
git clone https://github.com/nimarion/PIB-PR1-Tests.git
cp PRG-SPR/$1/*.java PIB-PR1-Tests/src/main/java/
cd PIB-PR1-Tests && mvn -Dtest=$2 test
