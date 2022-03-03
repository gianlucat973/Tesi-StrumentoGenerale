echo "inserisci qui i comandi per lo starting del Front-End della tua applciazione web"

echo "Inizio comandi installazione precondizioni"
sudo apt update
sudo apt -y install curl dirmngr apt-transport-https lsb-release ca-certificates
curl -sL https://deb.nodesource.com/setup_12.x | sudo bash
sudo apt install nodejs
sudo npm cache clean -f
sudo npm install -g n
sudo n stable
sudo n 12.20       
echo "Versione di node: "
node -v
echo "Versione di npm: "
npm -v
echo "Inizio init di npm"
npm init
echo "Inizio install di npm"
npm install
echo "Provo ad INSTALLARE bcrypt"
npm install bcrypt
npm fund
echo "Fine comandi installazione Node"

echo "Inizio comandi esecuzione Frontend"
cd /home/runner/work/Tesi-StrumentoGenerale/Tesi-StrumentoGenerale/insert-here-your-web-app/angular-java-example-master/root/frontend
echo "Siamo nella directory FE, proviamo a lanciarlo in esecuzione"
echo "Inizio init di npm"
npm init
echo "Inizio init di npm"
npm install
echo "Installazione npm effettuata, prossimo comando: npm start"
npm start &
