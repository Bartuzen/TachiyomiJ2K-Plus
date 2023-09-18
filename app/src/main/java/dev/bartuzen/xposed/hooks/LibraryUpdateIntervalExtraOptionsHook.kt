package dev.bartuzen.xposed.hooks

import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedHelpers

class LibraryUpdateIntervalExtraOptionsHook {
    companion object {
        fun init(classLoader: ClassLoader) {
            XposedHelpers.findAndHookMethod(
                "eu.kanade.tachiyomi.ui.setting.SettingsLibraryController",
                classLoader,
                "setupPreferenceScreen",
                XposedHelpers.findClass("androidx.preference.PreferenceScreen", classLoader),
                object : XC_MethodHook() {
                    override fun afterHookedMethod(param: MethodHookParam) {
                        val preference = XposedHelpers.callMethod(
                            param.result,
                            "findPreference",
                            arrayOf(CharSequence::class.java),
                            "pref_library_update_interval_key",
                        )

                        XposedHelpers.callMethod(
                            preference,
                            "setEntries",
                            arrayOf(List::class.java),
                            listOf(
                                "Manual",
                                "Every hour",
                                "Every 6 hours",
                                "Every 12 hours",
                                "Daily",
                                "Every 2 days",
                                "Every 3 days",
                                "Weekly",
                            ),
                        )
                        XposedHelpers.callMethod(
                            preference,
                            "setEntryValues",
                            arrayOf(List::class.java),
                            listOf(0, 1, 6, 12, 24, 48, 72, 168),
                        )
                    }
                },
            )
        }
    }
}
