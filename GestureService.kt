package com.example.reelremote

import android.accessibilityservice.AccessibilityService
import android.accessibilityservice.GestureDescription
import android.graphics.Path
import android.view.accessibility.AccessibilityEvent

class GestureService : AccessibilityService() {

    override fun onAccessibilityEvent(event: AccessibilityEvent?) {}

    override fun onInterrupt() {}

    companion object {
        fun performSwipeUp(service: AccessibilityService) {
            val path = Path()
            path.moveTo(500f, 1500f)
            path.lineTo(500f, 500f)

            val gesture = GestureDescription.Builder()
                .addStroke(GestureDescription.StrokeDescription(path, 0, 200))
                .build()

            service.dispatchGesture(gesture, null, null)
        }

        fun performDoubleTap(service: AccessibilityService) {
            val path = Path()
            path.moveTo(500f, 1000f)

            val gesture1 = GestureDescription.Builder()
                .addStroke(GestureDescription.StrokeDescription(path, 0, 50))
                .build()

            val gesture2 = GestureDescription.Builder()
                .addStroke(GestureDescription.StrokeDescription(path, 150, 50))
                .build()

            service.dispatchGesture(gesture1, null, null)
            service.dispatchGesture(gesture2, null, null)
        }
    }
}
