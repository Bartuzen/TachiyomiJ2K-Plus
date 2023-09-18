package dev.bartuzen.xposed

import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.callbacks.XC_LoadPackage
import dev.bartuzen.xposed.hooks.LibraryUpdateIntervalExtraOptionsHook
import dev.bartuzen.xposed.hooks.RemoveNotificationsHook

class XposedInit : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {
        val classLoader = lpparam.classLoader

        LibraryUpdateIntervalExtraOptionsHook.init(classLoader)
        RemoveNotificationsHook.init(classLoader)
    }
}
