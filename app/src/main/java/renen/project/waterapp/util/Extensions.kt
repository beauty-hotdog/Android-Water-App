package renen.project.waterapp.util

import android.content.res.Resources

fun pxToDp(px: Int): Int {
    return (px / Resources.getSystem().getDisplayMetrics().density).toInt()
}

fun dpToPx(dp: Int): Int {
    return (dp * Resources.getSystem().getDisplayMetrics().density).toInt()
}

fun isLastElement(position: Int, listSize: Int): Boolean {
    return position == listSize - 1
}