package app.eccweizhi.androidinstantapptemplate.base.ui


class ScreenIdentifier {
    companion object {
        private const val SCHEME = "https://"
        private const val HOST = "androidinstantapptemplate.eccweizhi.app"

        const val URI_FEATURE_SPRING = "$SCHEME$HOST/spring"
        const val URI_FEATURE_SUMMER = "$SCHEME$HOST/summer"
        const val URI_FEATURE_AUTUMN = "$SCHEME$HOST/autumn"
        const val URI_FEATURE_WINTER = "$SCHEME$HOST/winter"
    }
}