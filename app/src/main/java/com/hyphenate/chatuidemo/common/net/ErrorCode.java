package com.hyphenate.chatuidemo.common.net;

import com.hyphenate.EMError;
import com.hyphenate.chatuidemo.R;

/**
 * 定义一些本地的错误code
 */
public class ErrorCode extends EMError {
    /**
     * 当前网络不可用
     */
    public static final int EM_NETWORK_ERROR = -2;

    /**
     * 未登录过环信
     */
    public static final int EM_NOT_LOGIN = -8;

    /**
     * result解析错误
     */
    public static final int EM_PARSE_ERROR = -10;

    /**
     * 网络问题请稍后重试
     */
    public static final int EM_ERR_UNKNOWN = -20;

    /**
     * 添加自己为好友
     */
    public static final int EM_ADD_SELF_ERROR = -100;

    /**
     * 已经是好友
     */
    public static final int EM_FRIEND_ERROR = -101;

    /**
     * 已经添加到黑名单中
     */
    public static final int EM_FRIEND_BLACK_ERROR = -102;

    public enum Error {
        EM_NETWORK_ERROR(ErrorCode.EM_NETWORK_ERROR, R.string.em_error_network_error),
        EM_NOT_LOGIN(ErrorCode.EM_NOT_LOGIN, R.string.em_error_not_login),
        EM_PARSE_ERROR(ErrorCode.EM_PARSE_ERROR, R.string.em_error_parse_error),
        EM_ERR_UNKNOWN(ErrorCode.EM_ERR_UNKNOWN, R.string.em_error_err_unknown),
        EM_ADD_SELF_ERROR(ErrorCode.EM_ADD_SELF_ERROR, R.string.em_error_err_unknown),
        EM_FRIEND_ERROR(ErrorCode.EM_FRIEND_ERROR, R.string.em_error_err_unknown),
        EM_FRIEND_BLACK_ERROR(ErrorCode.EM_FRIEND_BLACK_ERROR, R.string.em_error_err_unknown),
        UNKNOWN_ERROR(-9999, 0);


        private int code;
        private int messageId;

        private Error(int code, int messageId) {
            this.code = code;
            this.messageId = messageId;
        }

        public static Error parseMessage(int errorCode) {
            for (Error error: Error.values()) {
                if(error.code == errorCode) {
                    return error;
                }
            }
            return UNKNOWN_ERROR;
        }


        public int getMessageId() {
            return messageId;
        }


    }
}
