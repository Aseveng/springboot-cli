package com.forvue;

import com.forvue.utils.EmailUtil;
import com.forvue.utils.ReptileUtil;
import com.forvue.utils.ScheduledTasks;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by gqc on 2018/12/13.
 */

@EnableScheduling
public class EmailTest {

    @Test
    public void testEmail() throws Exception {
//        ReptileUtil re=new ReptileUtil();
//        String weatherText=re.getWeatherText();
//        EmailUtil em=new EmailUtil();
//        em.forEmail(weatherText);
        ScheduledTasks scheduledTasks=new ScheduledTasks();
        scheduledTasks.scheduledEmail();
    }
}
