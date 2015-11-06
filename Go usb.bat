@echo off
adb connect 192.168.1.196:5555
adb devices
pause
adb -s  192.168.1.196:5555 usb
adb devices
pause