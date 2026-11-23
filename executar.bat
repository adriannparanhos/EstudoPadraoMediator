@echo off
chcp 65001 >nul
setlocal

:: Verifica se o java esta no PATH; se nao estiver, usa o Corretto 21 instalado no usuario
where javac >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    set "JAVAC_CMD=javac"
    set "JAVA_CMD=java"
) else (
    if exist "%USERPROFILE%\.jdks\corretto-21.0.10\bin\javac.exe" (
        set "JAVAC_CMD=%USERPROFILE%\.jdks\corretto-21.0.10\bin\javac.exe"
        set "JAVA_CMD=%USERPROFILE%\.jdks\corretto-21.0.10\bin\java.exe"
    ) else (
        echo [ERRO] JDK nao encontrado no PATH. Abra o projeto no IntelliJ IDEA ou configure o JAVA_HOME.
        pause
        exit /b 1
    )
)

if not exist bin mkdir bin

echo Compilando o projeto EstudoPadraoMediator...
"%JAVAC_CMD%" -encoding UTF-8 -d bin src\antipadrao\*.java src\chat\*.java src\smarthome\*.java src\trafegoaereo\*.java src\MainEstudoMediator.java
if %ERRORLEVEL% NEQ 0 (
    echo [ERRO] Falha na compilacao.
    pause
    exit /b 1
)

echo Compilacao concluida com sucesso! Iniciando Menu Interativo...
echo.
"%JAVA_CMD%" -cp bin MainEstudoMediator
pause
