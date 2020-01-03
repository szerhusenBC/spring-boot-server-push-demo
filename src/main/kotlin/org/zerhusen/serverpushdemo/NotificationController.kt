package org.zerhusen.serverpushdemo

import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class NotificationController(val template: SimpMessagingTemplate) {

    var notifications = Notifications(0)

    @GetMapping("/notify")
    fun getNotification(): String { // Increment Notification by one
        notifications = notifications.increment()
        // Push notifications to front-end
        template.convertAndSend("/topic/notification", notifications)
        return "Send increase action to server!"
    }

}
