package org.zerhusen.serverpushdemo

class Notifications(val count: Int) {
    fun increment(): Notifications {
        return Notifications(count + 1)
    }
}
