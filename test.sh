#!/bin/bash
cd ~
rm -rf PIB-PR1-Tests/
git clone https://github.com/nimarion/PIB-PR1-Tests.git
cp PRG-SPR/$1/*.java PIB-PR1-Tests/src/main/java/
cd PIB-PR1-Tests && mvn clean -Dtest=$2 surefire-report:report 
if [ -n "$3" ]; then
  mvn site -DgenerateReports=false
  echo "Open report in browser"  
  firefox ./target/site/surefire-report.html  
fi     
