package app.eccweizhi.androidinstantapptemplate.base.ui


class ScreenIdentifier {
    companion object {
        private const val SCHEME = "https://"
        private const val HOST = "eccweizhi.app"

        const val URI_FEATURE_ONE = "$SCHEME$HOST/androidinstantapptemplate/featureone"
        const val URI_FEATURE_TWO = "$SCHEME$HOST/androidinstantapptemplate/featuretwo"
    }
}