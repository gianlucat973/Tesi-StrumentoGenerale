echo "inserisci qui i comandi per lo starting del Back-End della tua applicazione web"
sudo apt update
sudo apt install openjdk-8-jdk openjdk-8-jre
echo "Installata versione di java numero"
java -version 
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master
mvn clean install
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master/target
echo "Vediamo quali file jar si trovano in cartella target"
ls -a
echo "Proviamo ad eseguire ${{ secrets.NOME_JAR_WEBAPP }}.jar"
java -jar users-0.0.1-SNAPSHOT.jar
