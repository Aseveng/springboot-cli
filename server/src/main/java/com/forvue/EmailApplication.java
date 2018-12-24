package com.forvue;

import com.forvue.utils.ScheduledTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by gqc on 2018/12/14.
 */
//定时任务的注解
@EnableScheduling
//@SpringBootApplication
public class EmailApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(EmailApplication.class, args);

       ScheduledTasks scheduledTasks =new ScheduledTasks();
       scheduledTasks.scheduledEmail();

    }
}
