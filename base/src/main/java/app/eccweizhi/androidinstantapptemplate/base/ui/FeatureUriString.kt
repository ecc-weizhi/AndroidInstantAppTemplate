package app.eccweizhi.androidinstantapptemplate.base.ui

import android.content.Intent
import android.net.Uri


class FeatureUriString {
    companion object {
        private const val SCHEME = "https://"
        private const val HOST = "androidinstantapptemplate.eccweizhi.app"

        const val SPRING = "$SCHEME$HOST/spring"
        const val SUMMER = "$SCHEME$HOST/summer"
        const val AUTUMN = "$SCHEME$HOST/autumn"
        const val WINTER = "$SCHEME$HOST/winter"

        // Spring feature
        const val SPRING_INTENT_KEY_PARAM_1 = "spring_param_1"

        // Summer feature
        const val SUMMER_INTENT_KEY_PARAM_1 = "summer_param_1"

        // Autumn feature
        const val AUTUMN_INTENT_KEY_PARAM_1 = "autumn_param_1"

        // Winter feature
        const val WINTER_INTENT_KEY_PARAM_1 = "winter_param_1"

        @JvmStatic
        fun newSpringIntent(param1: String): Intent {
            return Intent(Intent.ACTION_VIEW,
                    Uri.parse(FeatureUriString.SPRING)).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
                putExtra(SPRING_INTENT_KEY_PARAM_1,
                        param1)
            }
        }

        @JvmStatic
        fun newSummerIntent(param1: String): Intent {
            return Intent(Intent.ACTION_VIEW,
                    Uri.parse(FeatureUriString.SUMMER)).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
                putExtra(SUMMER_INTENT_KEY_PARAM_1,
                        param1)
            }
        }

        @JvmStatic
        fun newAutumnIntent(param1: String): Intent {
            return Intent(Intent.ACTION_VIEW,
                    Uri.parse(FeatureUriString.AUTUMN)).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
                putExtra(AUTUMN_INTENT_KEY_PARAM_1,
                        param1)
            }
        }

        @JvmStatic
        fun newWinterIntent(param1: String): Intent {
            return Intent(Intent.ACTION_VIEW,
                    Uri.parse(FeatureUriString.WINTER)).apply {
                addCategory(Intent.CATEGORY_BROWSABLE)
                putExtra(WINTER_INTENT_KEY_PARAM_1,
                        param1)
            }
        }
    }
}