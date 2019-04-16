@ECHO OFF
setlocal EnableDelayedExpansion
set git_hrp=C:\Users\jbolanos\.ssh\ttsautotestru01
set python_path=C:\Python37-32
set /P profile=Set profile name(e.g. TestAgrigator.xml or Others\TestAgrigator.xml):
set /P c=choose daily or night(default) build to test[D/N]?
if /I "%c%" EQU "D" (
set path="\\moscow\ru\QA\CM\Daily_Repository"
set build_type="D"
) else (
set path="\\moscow\ru\QA\CM\Build_Repository"
set build_type="N"
)
set /P treat_version=Set version of Treat without build number (e.g. 13.0.0 or 13.1.0 or 14.0.1):
set /P build_number=Set build number without version (e.g. 25):
start /B /WAIT %python_path%\python.exe %git_hrp%\run_hrp.py %profile% %path%\Treat-%treat_version%\TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number%\Treat.zip -p test -s Test\%username% -b TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number% -i default.ini -m "%username%@aligntech.com"
start /B /WAIT %python_path%\python.exe %git_hrp%\run_hrp.py %profile% %path%\Treat-%treat_version%\TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number%\Treat.zip -p report -s Test\%username% -b TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number% -i default.ini -m "%username%@aligntech.com"
start /B /WAIT %python_path%\python.exe %git_hrp%\run_hrp.py %profile% %path%\Treat-%treat_version%\TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number%\Treat.zip -p notify -s Test\%username% -b TRT-REL%treat_version:.=%%build_type%-JOB1-%build_number% -i default.ini -m "%username%@aligntech.com"