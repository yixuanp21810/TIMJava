package com.sevlow.sdk.tim.bean.group;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author pengshiqing
 * @Date: 2019/12/6
 * @Description:
 */

@Data
public class ModifyGroupMemberInfoReq implements Serializable {

    private static final long serialVersionUID = 5148435499835343022L;

    @SerializedName("GroupId")
    private String groupId ;

    @SerializedName("Member_Account")
    private String memberAccount ;

    @SerializedName("role")
    private Role role ;

    @SerializedName("MsgFlag")
    private MsgFlag msgFlag ;

    /**
     *  群名片
     */
    @SerializedName("NameCard")
    private String nameCard ;

    /**
     *  禁言时间
     */
    @SerializedName("ShutUpTime")
    private Long shutUpTime ;


    public enum Role{
        /**
         *  管理员
         */
        Admin,

        /**
         *  普通成员
         */
        Member
    }

    public enum MsgFlag{

        /**
         *  代表接收并提示消息
         */
        AcceptAndNotify,
        /**
         *  代表不接收也不提示消息
         */

        Discard,

        /**
         *  代表接收消息但不提示
         */
        AcceptNotNotify
    }
}
