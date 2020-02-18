@echo off
setlocal enableextensions
pushd %~dp0

CD ..\build\libs

for /f "tokens=*" %%a in (
'dir /b *.jar'
) do (
set jarloc=%%a
)

java -jar %jarloc% < ..\..\test\input.txt > ..\..\test\ACTUAL.TXT

cd ..\..\test

FC ACTUAL.TXT EXPECTED.TXT >NUL && ECHO Test passed! || Echo Test failed!
