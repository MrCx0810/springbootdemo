package com.ch;

import com.ch.dao.admin.PowerDao;
import com.ch.dao.front.TokenDao;
import com.ch.dao.front.UserDao;
import com.ch.entity.Admin;
import com.ch.entity.User;
import com.ch.services.interf.front.UserInterf;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 * @Description:
 * @author: 小小小阿曦
 * @Date: 2017/12/22
 * @Time: 16:08
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTest {

    @Autowired
    UserDao userdao;
    @Autowired
    TokenDao tokenDao;
    @Autowired
    PowerDao powerDao;
    @Autowired
    UserInterf UserInterf;


    @Test
    public void testUser(){
        User user = new User();
        user.setLoginName("pp");
        user.setPassword("123");
        user.setNiceName("aa");
        User user2 = new User();
        user2.setLoginName("5555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555555");
        user2.setPassword("123");
        user2.setNiceName("aa");
        try {
            UserInterf.addUser(user.getLoginName(),user.getNiceName(),user.getPassword(),user.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            UserInterf.addUser(user2.getLoginName(),user2.getNiceName(),user2.getPassword(),user2.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdate(){
        User aa = userdao.queryUserByLoginName("aa");
        System.out.println("aa = " + aa);
    }

    @Test
    public void testDel(){
        userdao.deleteUserById(2);
    }

    @Test
    public void testTel(){
//        String tel = "111245456767";
//        boolean res = OftenTool.isPhoneNumber(tel);
//        System.out.println("res = " + res);
//        int hour = DateUtil.getHour(new Date());
//        System.out.println("hour = " + hour);
        Admin admin = new Admin();
        admin.setId(1);
        admin.setLoginName("cc");
        powerDao.updateAdminById(admin);
    }

    @Test
    public void testLog(){
        User user = new User();
        user.setLoginName("dasjkdjhdajhsdjhaksjdhkajhsdjahksjdhkajhdsjkahsjdhajkhsdkjahsdkjhakjshdjkahsdjkhaksjdhkjahsdkjahskdjhajkshdjkahsdjhaksjdhakjshdkjahsdkjahsjdhakjsdhkajhdkjahhskjdhakjsdhjahsdajhsdjkahsdkjhaksdhakshdklahdskajhsdkahsdkjahsdkjhakjsdhkajshdkjahsdkjhaskjdhhkajshdkjahsdkjahsdkjhasjkdhajshdkjahsdjahsdkjahskjdhaksjhdkjsahdjahsdjahsdjahsdjhasjdhajkshdjkashdkjahsdjkahskjdhajkshdjashdjahsdjkahskjdhaskjhdkjashdjahsdjahsdjkhasjdhhkajshdjkashdjksahjdhajsdhajkshdjkashdjahsdjhasjdhhajkshdjashdjahsdkjsahdjhaskjdhajshdjahsdjhasjkdhajkshdjahsdjashdjkahsdjkhaskjdhkajshdsajhdkjashdjkahsdjhasjdajshdjahsdjahsdjhasjdhhajshdjashdjahsdjhasjhdjkashdjahsjdhajshdjashdjhasjdhasjhdjsahdjkashdjahsjdkhjaksdhasjdhajkshdkjashdjasdjahsjdhajsdhjashdjashdjashdjashdjhasjdhjashdjashdjashdjahsjdhasjdhjkashdjashdjkahsdjahsdjhasjdhajshdjashdjahsdjahsdjkasdhajksjdjkasldjalksjdaklsjdkalskjdlkasjdalksjdlkasjdlkasjdklajsdkjaskldjlkasjdlkajsdkljaslkdjkasjdkasjdkasjdjkalsj");
        try {
            UserInterf.addUser(user.getLoginName(), "cc", "123","123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
