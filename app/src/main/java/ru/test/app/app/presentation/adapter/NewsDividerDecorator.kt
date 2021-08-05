package ru.test.app.app.presentation.adapter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import ru.test.app.R
import ru.test.app.utils.extensions.getColorCompat

class NewsDividerDecorator(
    context: Context
) : RecyclerView.ItemDecoration() {

    private val dividerHeight = context.resources.getDimension(R.dimen.history_divider_height).toInt()
    private val grayColor: Int = context.getColorCompat(R.color.divider)
    private val paint = Paint().apply {
        this.style = Paint.Style.FILL
    }

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.set(0, 0, 0, dividerHeight)
    }

    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        for (i in 0 until parent.childCount - 1) {
            val view: View = parent.getChildAt(i)

            paint.color = grayColor

            c.drawRect(
                view.left.toFloat(),
                view.bottom.toFloat(),
                view.right.toFloat(),
                view.bottom.toFloat() + dividerHeight,
                paint
            )
        }
    }
}
