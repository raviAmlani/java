title Instalando Servicio Regtel...
cd %DIRREGTEL%
set JSEXE=%DIRREGTEL%\JavaService.exe
echo Instalando servicio de windows...
echo ...
"%JSEXE%" -install "RegtelDaemon"  "%DIRREGTEL%\jdk\jdk1.5.0_08\jre\bin\server\jvm.dll" -Djava.class.path="%DIRREGTEL%\RegtelDaemon.jar;%DIRREGTEL%\lib\jdom.jar;%DIRREGTEL%\lib\basic-core1.0.0.jar;%DIRREGTEL%\lib\core2.0.0.jar;%DIRREGTEL%\lib\iaik_jce_full.jar;%DIRREGTEL%\lib\iaik_smime.jar;%DIRREGTEL%\lib\itext-2.0.6.jar;%DIRREGTEL%\lib\jdom-b9.jar;%DIRREGTEL%\lib\PFDCoreHash.1.0.0.jar" -start com.regtel.daemon.UtilScan -stop com.regtel.daemon.UtilScan -method cerrarServicio -err "%DIRREGTEL%\errors.txt" -current "%DIRREGTEL%" -description "Servicio de Regtel"
echo Iniciando servicio...
net start "RegtelDaemon"
pause