@echo off
set workspace="<INSERT YOUR WORKSPACE PATH HERE>"
echo Using workspace: %workspace%
cd %workspace%\edu.tum.cs.ccts.protobuf.embedded\test
protoc --java_out=..\generated-src Test.proto
if ERRORLEVEL 1 (echo ERROR: see error message above!) else (echo Generated TestProtos.java successfully!)
pause