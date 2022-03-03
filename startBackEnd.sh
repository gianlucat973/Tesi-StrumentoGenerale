echo "inserisci qui i comandi per lo starting del Back-End della tua applicazione web"
sudo apt update
sudo apt install openjdk-11-jdk openjdk-11-jre
echo "Installata versione di java numero"
java -version 
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/root/backend
mvn clean install
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/root/backend/target
echo "Vediamo quali file jar si trovano in cartella target"
ls -a
java -jar backend-0.0.1-SNAPSHOT.jar &
