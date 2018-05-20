package app.eccweizhi.androidinstantapptemplate.base.ui


class ScreenIdentifier {
    companion object {
        private const val SCHEME = "https://"
        private const val HOST = "androidinstantapptemplate.eccweizhi.app"

        const val URI_FEATURE_ONE = "$SCHEME$HOST/featureone"
        const val URI_FEATURE_TWO = "$SCHEME$HOST/featuretwo"
    }
}