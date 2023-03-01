package com.xaoyv.magicbox.ui.splash;

import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.xaoyv.magicbox.R;
import com.xaoyv.magicbox.base.BaseDialog;
import com.xaoyv.magicbox.constant.UrlConstant;
import com.xaoyv.magicbox.ui.web.WebActivity;
import com.xaoyv.magicbox.util.StringUtil;

public class UserArgumentDialog extends BaseDialog {
    private TextView tvNode, tvNotAgree, tvAgree;

    private Listener listener;
    public interface Listener {
        void onAgree();
        void onDisAgree();
    }

    public void setListener(Listener listener) {
        this.listener = listener;
    }

    public UserArgumentDialog(@NonNull Context context) {
        super(context);
        initView();
        initData();
        initListener();
    }

    private void initListener() {
        tvNotAgree.setOnClickListener(v -> {
            dismiss();
            if (listener != null) {
                listener.onDisAgree();
            }
        });
        tvAgree.setOnClickListener(v -> {
            dismiss();
            if (listener != null) {
                listener.onAgree();
            }
        });
    }

    private void initData() {
        tvNode.setText(getContext().getString(R.string.privacy_thank));
        tvNode.append(StringUtil.buildClickSpannableString(
                getContext().getString(R.string.privacy_privacy),
                getContext().getResources().getColor(R.color.box_bb86fc),
                () -> WebActivity.start(getContext(), UrlConstant.URL_PRIVACE)
        ));
        tvNode.append(getContext().getString(R.string.privacy_and));
        tvNode.append(StringUtil.buildClickSpannableString(
                getContext().getString(R.string.privacy_user),
                getContext().getResources().getColor(R.color.box_bb86fc),
                () -> WebActivity.start(getContext(), UrlConstant.URL_USER_PRIVACE)
        ));
        tvNode.append(getContext().getString(R.string.privacy_end));
        tvNode.setMovementMethod(LinkMovementMethod.getInstance());
        tvNode.setOnLongClickListener(v -> true);
    }

    private void initView() {
        tvNode = findViewById(R.id.tv_info);
        tvAgree = findViewById(R.id.tv_agree);
        tvNotAgree = findViewById(R.id.tv_not_agree);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.dialog_user_argument;
    }
}
