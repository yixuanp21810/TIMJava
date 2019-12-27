package com.sevlow.sdk.tim.bean.group;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author pengshiqing
 * @Date: 2019/12/17
 * @Description:
 */
@Data
public class GroupInfoResult implements Serializable {

    private static final long serialVersionUID = 5079547005630920733L;

    private List<GroupInfo> GroupInfo ;
}
