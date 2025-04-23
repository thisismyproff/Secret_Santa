@echo off
echo Compiling Java files...
javac -d out src\main\java\Secret_Santa\*.java src\main\java\Secret_Santa\model\*.java src\main\java\Secret_Santa\service\*.java src\main\java\Secret_Santa\util\*.java



if %ERRORLEVEL% neq 0 (
    echo Compile failed. Check your code!
    pause
    exit /b
)

echo Running the program...
java -cp out Secret_Santa.Main


pause
