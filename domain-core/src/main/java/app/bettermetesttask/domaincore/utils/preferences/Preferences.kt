package app.bettermetesttask.domaincore.utils.preferences

interface Preferences {

    companion object {
        const val KEY_FIRST_LAUNCH = "first_launch"
    }

    fun isFirstLaunch(): Boolean

    fun markAlreadyLaunched()

}