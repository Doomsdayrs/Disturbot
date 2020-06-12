package com.revolutionarygamesstudio.disturbot.common.obj

/**
 * disturbot
 * 12 / 06 / 2020
 */
object UniqueInt {
    private var currentInt = 0

    /**
     * Gives a completely unique int, always +1 from the last
     */
    @Synchronized
    public fun getUniqueInt() = currentInt.let { currentInt++;currentInt }
}