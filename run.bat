@echo off
REM Deaktiviert die Anzeige der ausgeführten Befehle im Terminal

echo [Kompiliere Java-Projekt...]
REM  Kompiliert alle .java-Dateien aus den model-, service-Paketen + Main.java
REM  Gibt die kompilierten .class-Dateien in den Ordner "bin" aus
javac -d bin src\model\*.java src\service\*.java src\Main.java

REM ❗ Prüft, ob beim Kompilieren ein Fehler aufgetreten ist
if %errorlevel% neq 0 (
    echo ❌ Fehler beim Kompilieren.
    pause
    exit /b
)

echo [Starte Simulation...]
REM Führt die Main-Klasse aus dem "bin"-Verzeichnis aus
java -cp bin Main

REM Wartet auf Tastendruck, damit sich das Terminal nicht sofort schließt
pause
