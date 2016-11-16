; Name of our application
Name "Number 2 Text"

; The file to write
OutFile "N2T_Installer.exe"

; Set the default Installation Directory
InstallDir "$PROGRAMFILES\N2T"

; Set the text which prompts the user to enter the installation directory
DirText "Elija el directorio donde desea instalar la aplicación."

; ----------------------------------------------------------------------------------
; *************************** SECTION FOR INSTALLING *******************************
; ----------------------------------------------------------------------------------

Section "" ; A "useful" name is not needed as we are not installing separate components

; Set output path to the installation directory. Also sets the working
; directory for shortcuts
SetOutPath $INSTDIR\

File n2t.jar
File n2t.exe

WriteUninstaller $INSTDIR\Uninstall.exe

; ///////////////// CREATE SHORT CUTS //////////////////////////////////////

CreateDirectory "$SMPROGRAMS\N2T"

CreateShortCut "$SMPROGRAMS\N2T\Ejecutar N2T.lnk" "$INSTDIR\n2t.exe"

CreateShortCut "$SMPROGRAMS\N2T\Desinstalar N2T.lnk" "$INSTDIR\Uninstall.exe"

; ///////////////// END CREATING SHORTCUTS ////////////////////////////////// 

; //////// CREATE REGISTRY KEYS FOR ADD/REMOVE PROGRAMS IN CONTROL PANEL /////////

WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\N2T" "DisplayName"\
"N2T (remove only)"

WriteRegStr HKLM "Software\Microsoft\Windows\CurrentVersion\Uninstall\N2T" "UninstallString" \
"$INSTDIR\Uninstall.exe"

; //////////////////////// END CREATING REGISTRY KEYS ////////////////////////////

MessageBox MB_OK "Instalación Exitosa!"

SectionEnd

; ----------------------------------------------------------------------------------
; ************************** SECTION FOR UNINSTALLING ******************************
; ---------------------------------------------------------------------------------- 

Section "Uninstall"
; remove all the files and folders
Delete $INSTDIR\Uninstall.exe ; delete self
Delete $INSTDIR\n2t.jar

RMDir $INSTDIR

; now remove all the startmenu links
Delete "$SMPROGRAMS\N2T\Ejecutar N2T.lnk"
Delete "$SMPROGRAMS\N2T\Desinstalar N2T.lnk"
RMDIR "$SMPROGRAMS\N2T"

; Now delete registry keys
DeleteRegKey HKEY_LOCAL_MACHINE "SOFTWARE\N2T"
DeleteRegKey HKEY_LOCAL_MACHINE "SOFTWARE\Microsoft\Windows\CurrentVersion\Uninstall\N2T"

SectionEnd