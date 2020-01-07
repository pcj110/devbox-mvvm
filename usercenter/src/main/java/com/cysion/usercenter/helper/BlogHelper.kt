package com.cysion.usercenter.helper

import androidx.fragment.app.FragmentActivity
import com.cysion.uibox.dialog.CANCEL
import com.cysion.uibox.dialog.CONFIRM
import com.cysion.uibox.dialog.OnTypeClickListener
import com.cysion.usercenter.R
import com.cysion.usercenter.entity.Blog
import com.cysion.wedialog.WeDialog
import kotlinx.android.synthetic.main.dialog_comment.view.*

object BlogHelper {

    //根据id得到列表中的博客
    fun getBlog(blogid: String, datalist: MutableList<Blog>): Blog? {
        var blog = null
        datalist.forEach {
            if (it.blogId.equals(blogid)) {
                return it
            }
        }
        return null
    }

    fun comment(
        src: FragmentActivity,
        clickListener: OnTypeClickListener?
    ) {
        WeDialog.custom(src)
                .layout(R.layout.dialog_comment)
                .setWidthRatio(0.8f)
                .show { df, dialogView, bundle ->
                    dialogView.tv_cancel.setOnClickListener {
                        df.dismissAllowingStateLoss()
                        clickListener?.invoke(CANCEL, "")
                    }
                    dialogView.tv_confirm.setOnClickListener {
                        df.dismissAllowingStateLoss()
                        clickListener?.invoke(CONFIRM, dialogView.etComment.text.toString().trim())
                    }
                }
    }
}