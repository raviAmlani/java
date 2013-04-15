title Arrancando Regtel...
cd %DIRREGTEL%
min
set PATH=%DIRREGTEL%/jdk/jdk1.5.0_08/bin;%PATH%
set CLASSPATH=RegtelDaemon.jar;lib/trayicon.jar
start javaw -classpath %CLASSPATH% com.regtel.guidaemon.AplicationIcon
