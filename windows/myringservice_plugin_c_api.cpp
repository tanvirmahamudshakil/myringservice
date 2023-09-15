#include "include/myringservice/myringservice_plugin_c_api.h"

#include <flutter/plugin_registrar_windows.h>

#include "myringservice_plugin.h"

void MyringservicePluginCApiRegisterWithRegistrar(
    FlutterDesktopPluginRegistrarRef registrar) {
  myringservice::MyringservicePlugin::RegisterWithRegistrar(
      flutter::PluginRegistrarManager::GetInstance()
          ->GetRegistrar<flutter::PluginRegistrarWindows>(registrar));
}
