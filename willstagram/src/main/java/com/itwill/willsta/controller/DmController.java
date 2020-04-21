package com.itwill.willsta.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.itwill.willsta.domain.DM;
import com.itwill.willsta.domain.DmContents;
import com.itwill.willsta.domain.DmContentsCount;
import com.itwill.willsta.domain.Member;
import com.itwill.willsta.service.DmService;
import com.itwill.willsta.service.MemberService;

@Controller
public class DmController {
   @Autowired
   private DmService dmService;
   
   @ResponseBody
   @RequestMapping(value = "/sessionCheck", method = RequestMethod.POST, produces = "text/plain;charset=UTF-8")
   public String returnSessionCheck(HttpSession httpSession) {
      String mId = (String)httpSession.getAttribute("mId");
      Map<String, Member> memberInfo = dmService.getMemberInfo(mId);       
      String mImage = memberInfo.get("member").getmImage();
      String mName = memberInfo.get("member").getmName();
      return mId+","+mImage+","+mName;
   }
   @ResponseBody
   @RequestMapping(value = "/messages_room_create")
   public String messageRoomInsert(@RequestParam("mId") String mId,
                           @RequestParam("mIdYou") String mIdYou) {
      String isSuccess = "false";
      System.out.println("@@@@@@@@@@@@@@@@@mId:"+mId);
      System.out.println("@@@@@@@@@@@@@@@@@mIdYou:"+mIdYou);
      System.out.println(dmService.dmRoomSelectAll(mId));
      if(dmService.duplicateCheck(mId, mIdYou) == true) {
         isSuccess = "false";
      } else {
         if(dmService.dmFirstInsert(mId) != 0) {
            int dmNo = Integer.parseInt(dmService.dmGetCurrentDmNo());
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@dmNo:"+dmNo);
            dmService.dmLastInsert(dmNo, mIdYou);
            isSuccess = "true";
         }
      }
      return isSuccess;
   }
   
   @RequestMapping(value = "/messages", method = RequestMethod.GET)
   public String messageForm(HttpSession httpSession) {
      String mId = (String)httpSession.getAttribute("mId");
      List<DmContentsCount> notReadCount = dmService.dmAllNotReadCount(mId);
      for (DmContentsCount dmContentsCount : notReadCount) {
         System.out.println("나오니"+dmContentsCount.getDmNo()+":"+dmContentsCount.getDmChatReadCount());
      }
      List<DM> dmList = dmService.dmRoomSelectAll(mId); 
      System.out.println("@@@@@@@@mId:"+mId);
      httpSession.setAttribute("dmList", dmList);
      httpSession.setAttribute("mId", mId);
      return "messages";
   }
   
   @ResponseBody
   @RequestMapping(value = "/messageRoom_detail", produces = "application/json;charset=UTF-8")
   public List<DmContents> messageDetail(@RequestParam("dmNo") int dmNo) {
      List<DmContents> dmcList = dmService.dmNoSelectAll(dmNo);
      for (DmContents dmContents : dmcList) {
         System.out.println(dmContents);
      }
      return dmcList; 
   }
   @ResponseBody
   @RequestMapping(value = "/messages_insert", method = RequestMethod.POST)
   public int messagesInsert(@RequestParam("messages") String messages) {
      int rowCount = 0;
      String strs[] = messages.split(",");
      System.out.println(strs);
      if(strs != null && strs.length == 7) {
      String mId = strs[0];
      String mIdYou = strs[1];
      String contents = strs[2];
      String msgDate = strs[3];
      String dmNo = strs[4];
      String dmContentsImage = strs[5];
      Integer dmChatRead = Integer.parseInt(strs[6]);
      rowCount = dmService.dmcInsert(new DmContents(Integer.parseInt(dmNo), -999, contents, "sysdate", mId, dmContentsImage, dmChatRead));
      }
      return rowCount;
   }
   
   @ResponseBody
   @RequestMapping(value = "/messages_readChat", method = RequestMethod.POST)
   public int messageChatRead(@RequestParam("messages") String messages) {
      String strs[] = messages.split(",");
      System.out.println("수신자 리스트 클릭시"+strs);
      int rowCount = 0;
      if(strs != null && strs.length == 7) {
         String mId = strs[0];
         String mIdYou = strs[1];
         String contents = strs[2];
         String msgDate = strs[3];
         String dmNo = strs[4];
         String dmContentsImage = strs[5];
         Integer dmChatRead = Integer.parseInt(strs[6]);
         System.out.println("mId:"+mId);
         rowCount = dmService.dmcReadChat(new DmContents(Integer.parseInt(dmNo), -999, null, null, mId, null, dmChatRead));
         System.out.println(rowCount);
         }
      return rowCount;
   }
   
   /*
   @ResponseBody
   @RequestMapping(value = "/messages_notReadCount", method = RequestMethod.POST)
   public int messagesNotReadCount(@RequestParam("messages") String messages) {
      String strs[] = messages.split(",");
      int rowCount = 0;
      if(strs != null && strs.length == 7) {
         String mId = strs[0];
         String dmNo = strs[4];
         Integer dmChatRead = Integer.parseInt(strs[6]);
         System.out.println("mId:"+mId);
         rowCount = dmService.dmcReadChat(new DmContents(Integer.parseInt(dmNo), -999, null, null, mId, null, dmChatRead));
         System.out.println(rowCount);
         }
      return rowCount;
   }
   */
}