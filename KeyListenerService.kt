package com.example.reelremote

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.view.KeyEvent
import android.view.accessibility.AccessibilityEvent
import android.view.accessibility.AccessibilityManager

class KeyListenerService : Service() {

    private var accessibilityManager: AccessibilityManager? = null

    override fun onCreate() {
        super.onCreate()
        accessibilityManager = getSystemService(ACCESSIBILITY_SERVICE) as AccessibilityManager
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onUnbind(intent: Intent?): Boolean {
        return super.onUnbind(intent)
    }

    override fun onTaskRemoved(rootIntent: Intent?) {
        stopSelf()
    }

    // Earbud buttons intercept
    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        when (keyCode) {
            KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE -> {
                GestureService.performSwipeUp(this) // Next Reel
            }
            KeyEvent.KEYCODE_MEDIA_NEXT -> {
                GestureService.performDoubleTap(this) // Like Reel
            }
        }
        return super.onKeyDown(keyCode, event)
    }
}
