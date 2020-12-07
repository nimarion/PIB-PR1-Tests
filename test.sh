#!/bin/bash
cd ~
rm -rf PIB-PR1-Tests/
git clone -b $1 https://github.com/nimarion/PIB-PR1-Tests.git
cd PIB-PR1-Tests && wget https://gist.github.com/nimarion/4c17646d69cc8597d2ccf78196ffa8af/raw/43ba80ac96e49a7f430c0bec8ba11afec69bd3e1/apache-maven-3.6.3-bin.zip && unzip apache-maven-3.6.3-bin.zip 1> /dev/null
M2_HOME=apache-maven-3.6.3
M2=$M2_HOME/bin
PATH=$M2:$PATH
cp ~/PRG-SPR/$1/*.java ~/PIB-PR1-Tests/src/main/java/
cd ~/PIB-PR1-Tests && mvn clean surefire-report:report
if [ -n "$2" ]; then
  mvn site -DgenerateReports=false
  echo "Open report in browser"
  firefox ./target/site/surefire-report.html
fi