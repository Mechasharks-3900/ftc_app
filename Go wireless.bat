@echo off
adb devices
pause
adb tcpip 5555
adb connect 192.168.1.131:5555
adb devices
pause