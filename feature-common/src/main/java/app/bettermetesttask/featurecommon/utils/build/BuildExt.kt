package app.bettermetesttask.featurecommon.utils.build

import app.bettermetesttask.featurecommon.BuildConfig

const val DEV_BUILD = "debug"
const val RELEASE_BUILD = "release"

val isDevBuild: Boolean
    get() = BuildConfig.BUILD_TYPE == DEV_BUILD

val isReleaseBuild: Boolean
    get() = BuildConfig.BUILD_TYPE == RELEASE_BUILD
