package dev.bartuzen.xposed.hooks

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers

class RemoveNotificationsHook {
    companion object {
        fun init(classLoader: ClassLoader) {
            XposedHelpers.findAndHookMethod(
                "eu.kanade.tachiyomi.data.library.LibraryUpdateService",
                classLoader,
                "checkIfMassiveUpdate",
                object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        param.result = false
                    }
                },
            )

            XposedHelpers.findAndHookMethod(
                "eu.kanade.tachiyomi.data.download.DownloadNotifier",
                classLoader,
                "massDownloadWarning",
                object : XC_MethodHook() {
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        param.result = null
                    }
                },
            )
        }
    }
}
