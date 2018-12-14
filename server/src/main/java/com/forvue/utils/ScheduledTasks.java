package com.forvue.utils;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by gqc on 2018/12/14.
 * 定时任务工具类
 */
@Component
public class ScheduledTasks  {
    //每隔24小时执行 fixedRate = 60*1000*60*24


    //定时发送邮件24小时
    @Scheduled(fixedRate = 60*1000*60*24)
    public void scheduledEmail() throws Exception {
        ReptileUtil re=new ReptileUtil();
        String weatherText=re.getWeatherText();
        EmailUtil em=new EmailUtil();
        em.forEmail(weatherText);
    }
}
