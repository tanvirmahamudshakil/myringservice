//
//  Generated file. Do not edit.
//

// clang-format off

#include "generated_plugin_registrant.h"

#include <myringservice/myringservice_plugin.h>

void fl_register_plugins(FlPluginRegistry* registry) {
  g_autoptr(FlPluginRegistrar) myringservice_registrar =
      fl_plugin_registry_get_registrar_for_plugin(registry, "MyringservicePlugin");
  myringservice_plugin_register_with_registrar(myringservice_registrar);
}
