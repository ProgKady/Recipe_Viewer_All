@echo off
echo ========================================
echo          Git Push Only - Kadysoft
echo ========================================
cd /d "C:\Users\Ahmed.ElKady\Documents\NetBeansProjects\RecipeMaker_Viewer_All"
echo.
git checkout master >nul 2>&1
git add .
git diff --cached --quiet
if %errorlevel% == 0 (
    echo.
    pause
    exit /b
)
echo.
git commit -m "Auto Update - %date% %time%"
echo.
git push origin master
if %errorlevel% neq 0 (
    echo.
    git push origin master --force-with-lease
)

echo.
echo ========================================
pause