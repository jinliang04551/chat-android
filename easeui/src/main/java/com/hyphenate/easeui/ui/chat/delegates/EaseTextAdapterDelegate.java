package com.hyphenate.easeui.ui.chat.delegates;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.hyphenate.chat.EMMessage;
import com.hyphenate.easeui.interfaces.MessageListItemClickListener;
import com.hyphenate.easeui.model.styles.EaseMessageListItemStyle;
import com.hyphenate.easeui.viewholder.EaseChatRowViewHolder;
import com.hyphenate.easeui.viewholder.EaseTextViewHolder;
import com.hyphenate.easeui.widget.chatrow.EaseChatRow;
import com.hyphenate.easeui.widget.chatrow.EaseChatRowText;

public class EaseTextAdapterDelegate extends EaseMessageAdapterDelegate<EMMessage, EaseChatRowViewHolder> {

    public EaseTextAdapterDelegate() {
    }

    public EaseTextAdapterDelegate(MessageListItemClickListener itemClickListener, EaseMessageListItemStyle itemStyle) {
        super(itemClickListener, itemStyle);
    }

    @Override
    public boolean isForViewType(EMMessage item, int position) {
        mIsSender = isMessageSender(item);
        Log.e("TAG", "isForViewType isSender = "+ mIsSender);
        return item.getType() == EMMessage.Type.TXT;
    }

    @Override
    protected EaseChatRow getEaseChatRow(ViewGroup parent, boolean isSender) {
        Log.e("TAG", "getEaseChatRow isSender = "+isSender);
        return new EaseChatRowText(parent.getContext(), isSender);
    }

    @Override
    public EaseChatRowViewHolder createViewHolder(View view, MessageListItemClickListener itemClickListener, EaseMessageListItemStyle itemStyle) {
        return new EaseTextViewHolder(view, itemClickListener, itemStyle);
    }

}
