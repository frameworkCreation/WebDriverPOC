@echo off
TASKKILL /IM IEDriverServer.exe /F
TASKKILL /IM chromedriver.exe /F
TASKKILL /IM geckodriver.exe /F
TASKKILL /IM iexplorer.exe /F
TASKKILL /IM chrome.exe /F
TASKKILL /IM firefox.exe /F
Pause