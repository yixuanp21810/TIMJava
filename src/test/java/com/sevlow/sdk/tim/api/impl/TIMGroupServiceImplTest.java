package com.sevlow.sdk.tim.api.impl;

import com.sevlow.sdk.tim.api.TIMGroupService;
import com.sevlow.sdk.tim.api.TIMService;
import com.sevlow.sdk.tim.api.test.TestModule;
import com.sevlow.sdk.tim.bean.chat.MsgCustomContent;
import com.sevlow.sdk.tim.bean.group.*;
import com.sevlow.sdk.tim.common.error.TIMException;
import com.sevlow.sdk.tim.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import javax.inject.Inject;
import java.util.*;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.api.impl
 * @date 2019-05-27 23:39
 * @Description:
 */
@Slf4j
@Guice(modules = {TestModule.class})
public class TIMGroupServiceImplTest {

	@Inject
	private TIMService timService;

	private TIMGroupService groupService;

	@BeforeTest
	public void before() {
		this.groupService = timService.getGroupService();
	}


	@Test
	public void testGetAllGroup() throws TIMException {
		AllGroupResult allGroup = groupService.getAllGroup(GroupInfo.Type.Public);
		Assert.assertNotNull(allGroup);
	}

	@Test
	public void testPageAllGroup() throws TIMException {
		AllGroupResult allGroup = groupService.pageGroup(0,10,GroupInfo.Type.Public);
		Assert.assertNotNull(allGroup);
	}


	@Test
	public void testGetGroupInfo() throws TIMException {
		String groupId = "77719615328747520" ;
		List<GroupInfo> list = groupService.getGroupInfo(Arrays.asList(groupId));
		Assert.assertNotNull(list);
	}


	@Test
	public void testCreateGroup() throws TIMException {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupId("119384433261281280");
		groupInfo.setType(GroupInfo.Type.Public);
		groupInfo.setApplyJoinOption(GroupInfo.ApplyJoinOption.FreeAccess);
		groupInfo.setName("147");
		System.out.println(groupInfo.toString());
		CreateGroupResult group = groupService.createGroup(groupInfo);
		Assert.assertNotNull(group);
	}

	@Test
	public void testUpdateGroup() throws TIMException {
		GroupInfo groupInfo = new GroupInfo();
		groupInfo.setGroupId("124895374392426496");
//		groupInfo.setType(GroupInfo.Type.Public);
//		groupInfo.setApplyJoinOption(GroupInfo.ApplyJoinOption.FreeAccess);
//		groupInfo.setName("huahua");
		groupInfo.setShutUpAllMember(GroupInfo.ShutUpAllMember.On);
		groupService.updateGroup(groupInfo);
	}


	@Test
	public void testJoinGroup() throws TIMException {
		List<String> list = Arrays.asList("105269240084299776","74897564679274496");
		AddGroupResult addGroupResult = groupService.addGroupMember("122718508491472896",list, SilenceEnum.QUIET);
		System.out.println("11111");
	}


	@Test
	public void testDeleteGroupMember() throws TIMException {
		List<String> list = Arrays.asList("105269240084299776");
		groupService.deleteGroupMember("122718508491472896",list, SilenceEnum.QUIET,"你好你好");

	}


	@Test
	public void testModifyGroupMemberInfo() throws TIMException {
		GroupMemberInfo info = new GroupMemberInfo();
		info.setGroupId("122666654936072192");
		info.setMemberAccount("105269240084299776");
		//info.setRole(GroupMemberInfo.Role.Admin);
		info.setNameCard("你好666");
		info.setMsgFlag(GroupMemberInfo.MsgFlag.Discard);
		groupService.modifyGroupMemberInfo(info);

	}


	@Test
	public void testDestroyGroup() throws TIMException {
		groupService.destroyGroup("124118461335994368");
	}

	@Test
	public void testForbidSendMsg() throws TIMException {
		groupService.forbidSendMsg("11231",Arrays.asList("74940051523371008"),100);
	}


	@Test
	public void testGetShuttedMember() throws TIMException {
		ShuttedMemberResult member = groupService.getShuttedMember("11231");
		Assert.assertNotNull(member);
	}


	@Test
	public void testSendGroupMsg() throws TIMException {
		groupService.sendGroupMsg("124835802260701184","124826573399392256",true,"你好11");
	}


	@Test
	public void testSendGroupSystemNotification() throws TIMException {
		groupService.sendGroupSystemNotification("124281248687325184",null,"你好111");
	}

	@Test
	public void testSentGroupCustomMsg() throws TIMException {
		Map map = new HashMap();
		map.put("action","9");
		map.put("type","10");
		map.put("name","你好");

		MsgCustomContent msg = new MsgCustomContent();
		msg.setSound("dingdong.aiff");
		msg.setExt("您有一条系统消息");
		msg.setDesc("您有一条系统消息");

		msg.setData(JsonUtils.toJson(map));
		groupService.sentGroupCustomMsg("124905622138257408","98471889676009472",null,msg);
	}


	@Test
	public void testImportGroupMember() throws TIMException {
		// 117954688241893376   72779248246456320  69887072709640192  17612021831
		List<ImportMember> members = new ArrayList<>();
		ImportMember member1 = new ImportMember("72356624357916672");
		ImportMember member2 = new ImportMember("69887072709640192");
		ImportMember member3 = new ImportMember("17612021831");
		members.add(member1);
		members.add(member2);
		members.add(member3);
		AddGroupResult result = groupService.importGroupMember("117954688241893376", members);
		Assert.assertNotNull(result);
	}


}
